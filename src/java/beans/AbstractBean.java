/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import eihdms.EIHDMSPersistentManager;
import eihdms.User_detail;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.criterion.Restrictions;
import org.orm.PersistentException;
import org.orm.PersistentTransaction;
import utilities.GeneralUtilities;

/**
 *
 * @author bajuna
 */
//@ManagedBean
public abstract class AbstractBean<T> {

    private Class<T> entityClass;
    private User_detail user;

    public User_detail getUser() {
        return user;
    }

    public void setUser(User_detail user) {
        this.user = user;
    }
    private T selected;
    private String formstate = "view";
    private List<T> ts;
    private List<T> tsActive;

    public AbstractBean() {
    }

    //@PostConstruct
    public void init() {
        try {
            //ts = (List<T>) EIHDMSPersistentManager.instance().getSession().createQuery("from " + entityClass.getName()).list();
            ts = (List<T>) EIHDMSPersistentManager.instance().getSession().createCriteria(entityClass).list();
        } catch (PersistentException ex) {
            GeneralUtilities.clearsession();
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void clearCache(T t) {
        try {
            EIHDMSPersistentManager.instance().getSession().evict(t);
            EIHDMSPersistentManager.instance().getSession().flush();
            EIHDMSPersistentManager.instance().getSession().clear();
        } catch (PersistentException ex) {
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void evictObject(T t) {
        try {
            EIHDMSPersistentManager.instance().getSession().evict(t);
            //EIHDMSPersistentManager.instance().getSession().flush();
            //EIHDMSPersistentManager.instance().getSession().clear();
        } catch (PersistentException ex) {
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public List<T> getTs() {
        return ts;
    }

    public List<T> getTsActive() {
        try {
            tsActive = (List<T>) EIHDMSPersistentManager.instance().getSession().createCriteria(entityClass).add(Restrictions.eq("isactive", "Yes")).list();
        } catch (PersistentException ex) {
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tsActive;
    }

    public void setTsActive(List<T> tsActive) {
        this.tsActive = tsActive;
    }


    public void setTs(List<T> ts) {
        this.ts = ts;
    }

    public T getSelected() {
        return selected;
    }

    public void setSelected(T selected) {
        this.selected = selected;
    }

    public AbstractBean(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public String getFormstate() {
        return formstate;
    }

    public void setFormstate(String formstate) {
        this.formstate = formstate;
    }

    public void createLicense() {

    }

    public void add() {
        try {
            selected = entityClass.newInstance();
        } catch (InstantiationException ex) {
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        formstate = "add";
    }

    public void edit(T t) {
        selected = t;
        formstate = "edit";
    }

    public void view(T t) {
        selected = t;
        formstate = "view";
    }

    public void cancel() {
        selected = null;
        formstate = "view";
    }

    public void delete(T t) {
        selected = t;
        formstate = "delete";
    }

    public void save() {
        //no paramater
        Class noparams[] = {};

        //String parameter
        Class[] paramUser_detail = new Class[1];
        paramUser_detail[0] = User_detail.class;

        //Timestamp parameter
        Class[] paramTimestamp = new Class[1];
        paramTimestamp[0] = Timestamp.class;

        //int parameter
        Class[] paramInteger = new Class[1];
        paramInteger[0] = Integer.class;
        try {
            PersistentTransaction transaction = EIHDMSPersistentManager.instance().getSession().beginTransaction();
            if (formstate.equals("add")) {
//                Method method = selected.getClass().getMethod("setCreatedby", paramUser_detail);
//                method.invoke(selected, loginBean.getUser_detail());
                Method method = selected.getClass().getMethod("setAdd_date", paramTimestamp);
                method.invoke(selected, new Timestamp(new Date().getTime()));
            }
            if (formstate.equals("edit")) {
//                Method method = selected.getClass().getMethod("setModifiedby", paramUser_detail);
//                method.invoke(selected, loginBean.getUser_detail());
                Method method = selected.getClass().getMethod("setLast_edit_date", paramTimestamp);
                method.invoke(selected, new Timestamp(new Date().getTime()));
            }
            Method method = selected.getClass().getMethod(entityClass.getSimpleName()+"_id", noparams);
            int id = (int) method.invoke(selected);
            if (id > 0) {
                EIHDMSPersistentManager.instance().getSession().merge(selected);
            } else {
                Method methodsave = selected.getClass().getMethod("save", noparams);
                methodsave.invoke(selected);
            }
            transaction.commit();
            clearCache(selected);
            formstate = "view";
            selected = null;
            saveMessage();
        } catch (PersistentException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            GeneralUtilities.clearsession();
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete() {
        try {
            PersistentTransaction t = EIHDMSPersistentManager.instance().getSession().beginTransaction();
            Object findAAgain = EIHDMSPersistentManager.instance().getSession().merge(selected);
            EIHDMSPersistentManager.instance().getSession().delete(findAAgain);
            t.commit();
            formstate = "view";
            EIHDMSPersistentManager.instance().getSession().evict(selected);
            this.selected = null;

        } catch (PersistentException ex) {
            Logger.getLogger(AbstractBean.class
                    .getName()).log(Level.SEVERE, null, ex);
            FacesContext.getCurrentInstance()
                    .addMessage("Delete", new FacesMessage(ex.getMessage()));
        }
    }

    private void saveMessage() {
        LoginBean loginBean = new LoginBean();
        loginBean.saveMessage();
    }
}
