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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.hibernate.CacheMode;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Order;
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
    private List<T> tsDeleted;
    private List<T> tsAll;
    private List<T> tsActive;
    private List<T> filteredTs;

    public AbstractBean() {
    }

    //@PostConstruct
    public void init() {

    }

    public void initializelist() {
        try {
            if (entityClass != null) {
                clearCache(selected);
                String class_name = entityClass.getSimpleName().toLowerCase();
                if (class_name.equals("region")) {
                    ts = (List<T>) EIHDMSPersistentManager.instance().getSession().createCriteria(entityClass).add(Restrictions.ne("is_deleted", 1)).addOrder(Order.asc(entityClass.getSimpleName().toLowerCase() + "_name")).list();
                } else if (class_name.equals("district")) {
                    ts = (List<T>) EIHDMSPersistentManager.instance().getSession().createQuery("select d from District d ORDER BY d.region.region_name,d.district_name").list();
                } else if (class_name.equals("sub_district")) {
                    ts = (List<T>) EIHDMSPersistentManager.instance().getSession().createQuery("select sd from Sub_district sd ORDER BY sd.district.region.region_name,sd.district.district_name,sd.sub_district_name").list();
                } else if (class_name.equals("county")) {
                    ts = (List<T>) EIHDMSPersistentManager.instance().getSession().createQuery("select c from County c ORDER BY c.district.region.region_name,c.district.district_name,c.county_name").list();
                } else if (class_name.equals("sub_county")) {
                    ts = (List<T>) EIHDMSPersistentManager.instance().getSession().createQuery("select sc from Sub_county sc ORDER BY sc.county.district.region.region_name,sc.county.district.district_name,sc.county.county_name,sc.sub_county_name").list();
                } else if (class_name.equals("parish")) {
                    ts = (List<T>) EIHDMSPersistentManager.instance().getSession().createQuery("select p from Parish p ORDER BY p.sub_county.county.district.region.region_name,p.sub_county.county.district.district_name,p.sub_county.county.county_name,p.parish_name").list();
                } else if (class_name.equals("health_facility")) {
                    ts = (List<T>) EIHDMSPersistentManager.instance().getSession().createQuery("select hf from Health_facility hf ORDER BY hf.parish.sub_county.county.district.region.region_name,hf.parish.sub_county.county.district.district_name,hf.parish.sub_county.county.county_name,hf.parish.parish_name,hf.health_facility_name").list();
                } else {
                    ts = (List<T>) EIHDMSPersistentManager.instance().getSession().createCriteria(entityClass).add(Restrictions.ne("is_deleted", 1)).list();
                }
            } else {
                ts = new ArrayList<>();
            }
        } catch (PersistentException | HibernateException ex) {
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void clearCache(T t) {
        try {
            EIHDMSPersistentManager.instance().getSession().evict(t);
            EIHDMSPersistentManager.instance().getSession().flush();
            EIHDMSPersistentManager.instance().getSession().clear();
            EIHDMSPersistentManager.instance().getSession().getSessionFactory().getCache().evictDefaultQueryRegion();
            EIHDMSPersistentManager.instance().getSession().getSessionFactory().getCache().evictQueryRegions();
            //EIHDMSPersistentManager.instance().getSession().close();
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

    public List<T> getFilteredTs() {
        return filteredTs;
    }

    public void setFilteredTs(List<T> filteredTs) {
        this.filteredTs = filteredTs;
    }

    public List<T> getTsDeleted() {
        try {
            tsDeleted = (List<T>) EIHDMSPersistentManager.instance().getSession().createCriteria(entityClass).add(Restrictions.eq("is_deleted", 1)).list();
        } catch (PersistentException ex) {
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tsDeleted;
    }

    public void setTsDeleted(List<T> tsDeleted) {
        this.tsDeleted = tsDeleted;
    }

    public List<T> getTsAll() {
        try {
            if (entityClass != null) {
                tsAll = (List<T>) EIHDMSPersistentManager.instance().getSession().createCriteria(entityClass).list();
            } else {
                tsAll = new ArrayList<>();
            }
        } catch (PersistentException ex) {
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        return tsAll;
    }

    public void setTsAll(List<T> tsAll) {
        this.tsAll = tsAll;
    }

    public List<T> getTs() {
        return ts;
    }

    public List<T> getTsActive() {
        try {
            if (entityClass != null) {
                tsActive = (List<T>) EIHDMSPersistentManager.instance().getSession().createCriteria(entityClass).add(Restrictions.eq("is_active", 1)).add(Restrictions.ne("is_deleted", 1)).list();
            } else {
                tsActive = new ArrayList<>();
            }
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
        add();
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
        try {
            //no paramater
            Class noparams[] = {};
            Method method = t.getClass().getMethod("get" + entityClass.getSimpleName() + "_id", noparams);
            int id = (int) method.invoke(t);
            if (id > 0) {
                selected = t;
                formstate = "edit";
            }
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void view(T t) {
        selected = t;
        formstate = "view";
    }

    public void cancel() {
        add();
        //formstate = "view";
    }

    public void delete(T t) {
        try {
            //no paramater
            Class noparams[] = {};
            Method method = t.getClass().getMethod("get" + entityClass.getSimpleName() + "_id", noparams);
            int id = (int) method.invoke(t);
            if (id == 0) {
                return;
            }
            selected = t;
            Class[] paramTimestamp = new Class[1];
            paramTimestamp[0] = Timestamp.class;
            //int parameter
            Class[] paramInteger = new Class[1];
            paramInteger[0] = int.class;
            PersistentTransaction transaction = EIHDMSPersistentManager.instance().getSession().beginTransaction();
            method = selected.getClass().getMethod("setLast_edit_date", paramTimestamp);
            method.invoke(selected, new Timestamp(new Date().getTime()));
            method = selected.getClass().getMethod("setIs_deleted", paramInteger);
            method.invoke(selected, 1);
            EIHDMSPersistentManager.instance().getSession().merge(selected);
            transaction.commit();
            saveMessage();
            add();
            initializelist();
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PersistentException ex) {
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void save(int aUserDetailId) {
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
        paramInteger[0] = int.class;
        try {
            PersistentTransaction transaction = EIHDMSPersistentManager.instance().getSession().beginTransaction();
            if (formstate.equals("add")) {
//                Method method = selected.getClass().getMethod("setCreatedby", paramUser_detail);
//                method.invoke(selected, loginBean.getUser_detail());

                Method method = selected.getClass().getMethod("setAdd_date", paramTimestamp);
                method.invoke(selected, new Timestamp(new Date().getTime()));
                method = selected.getClass().getMethod("setIs_deleted", paramInteger);
                method.invoke(selected, 0);
                method = selected.getClass().getMethod("setAdd_by", paramInteger);
                method.invoke(selected, aUserDetailId);
            }
            if (formstate.equals("edit")) {
//                Method method = selected.getClass().getMethod("setModifiedby", paramUser_detail);
//                method.invoke(selected, loginBean.getUser_detail());
                Method method = selected.getClass().getMethod("setLast_edit_date", paramTimestamp);
                method.invoke(selected, new Timestamp(new Date().getTime()));
                method = selected.getClass().getMethod("setLast_edit_by", paramInteger);
                method.invoke(selected, aUserDetailId);
            }
            Method method = selected.getClass().getMethod("get" + entityClass.getSimpleName() + "_id", noparams);
            int id = (int) method.invoke(selected);
            if (id > 0) {
                EIHDMSPersistentManager.instance().getSession().merge(selected);
            } else {
                Method methodsave = selected.getClass().getMethod("save", noparams);
                methodsave.invoke(selected);
            }
//            EIHDMSPersistentManager.instance().getSession().flush();
//            EIHDMSPersistentManager.instance().getSession().clear();
            transaction.commit();
            clearCache(selected);
            formstate = "view";
            add();
            //initializelist();
            saveMessage();
        } catch (PersistentException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            GeneralUtilities.clearsession();
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int save_return_entity_id(int aUserDetailId) {
        int entity_id = 0;
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
        paramInteger[0] = int.class;
        try {
            PersistentTransaction transaction = EIHDMSPersistentManager.instance().getSession().beginTransaction();
            if (formstate.equals("add")) {
//                Method method = selected.getClass().getMethod("setCreatedby", paramUser_detail);
//                method.invoke(selected, loginBean.getUser_detail());

                Method method = selected.getClass().getMethod("setAdd_date", paramTimestamp);
                method.invoke(selected, new Timestamp(new Date().getTime()));
                method = selected.getClass().getMethod("setIs_deleted", paramInteger);
                method.invoke(selected, 0);
                method = selected.getClass().getMethod("setAdd_by", paramInteger);
                method.invoke(selected, aUserDetailId);
            }
            if (formstate.equals("edit")) {
//                Method method = selected.getClass().getMethod("setModifiedby", paramUser_detail);
//                method.invoke(selected, loginBean.getUser_detail());
                Method method = selected.getClass().getMethod("setLast_edit_date", paramTimestamp);
                method.invoke(selected, new Timestamp(new Date().getTime()));
                method = selected.getClass().getMethod("setLast_edit_by", paramInteger);
                method.invoke(selected, aUserDetailId);
            }
            Method method = selected.getClass().getMethod("get" + entityClass.getSimpleName() + "_id", noparams);
            int id = (int) method.invoke(selected);
            if (id > 0) {
                EIHDMSPersistentManager.instance().getSession().merge(selected);
            } else {
                Method methodsave = selected.getClass().getMethod("save", noparams);
                methodsave.invoke(selected);
            }
            transaction.commit();
            entity_id = (int) method.invoke(selected);
            clearCache(selected);
            formstate = "view";
            add();
            //initializelist();
            saveMessage();
        } catch (PersistentException | NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            GeneralUtilities.clearsession();
            Logger.getLogger(AbstractBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return entity_id;
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
            ts = null;
            initializelist();
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
