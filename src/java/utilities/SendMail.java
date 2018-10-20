package utilities;

import java.io.FileNotFoundException;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail {

    private String from;
    private String to;
    private String subject;
    private String body;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public SendMail(String to, String subject, String body) {
        this.to = to;
        this.subject = subject;
        this.body = body;
    }

    public void send() throws FileNotFoundException {
        GlobalSettingsBean.readConnectionConfigurations();
        final String username = GlobalSettingsBean.getEMAIL_USERNAME();
        final String password = GlobalSettingsBean.getEMAIL_PASSWORD();
        Properties props = new Properties();
        props.put("mail.smtp.host", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", GlobalSettingsBean.getEMAIL_HOST());
        props.put("mail.smtp.port", GlobalSettingsBean.getEMAIL_PORT());
        props.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(GlobalSettingsBean.getEMAIL_USERNAME()));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);
//            BodyPart messageBodyPart = new MimeBodyPart();

//            Multipart multipart = new MimeMultipart();
//            if (task_documentList != null) {
//                for (Task_document task_document : task_documentList) {
//                    // Part two is attachment
//                    messageBodyPart = new MimeBodyPart();
//                    String filename = GlobalSettingsBean.getDOCROOT() + "\\" + task_document.getDocument_url();
//                    DataSource source = new FileDataSource(filename);
//                    messageBodyPart.setDataHandler(new DataHandler(source));
//                    messageBodyPart.setFileName(filename);
//                    multipart.addBodyPart(messageBodyPart);
//                }
//            }
//
//            // Put parts in message
//            message.setContent(multipart);
            Transport.send(message);

            System.out.println("Mail sent");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public void send_with_attachement(String filename) throws FileNotFoundException {
        GlobalSettingsBean.readConnectionConfigurations();
        final String username = GlobalSettingsBean.getEMAIL_USERNAME();
        final String password = GlobalSettingsBean.getEMAIL_PASSWORD();
        Properties props = new Properties();
        props.put("mail.smtp.host", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", GlobalSettingsBean.getEMAIL_HOST());
        props.put("mail.smtp.port", GlobalSettingsBean.getEMAIL_PORT());
        props.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(GlobalSettingsBean.getEMAIL_USERNAME()));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));
            message.setSubject(subject);
            message.setText(body);
            if (!filename.isEmpty()) {
                BodyPart messageBodyPart = new MimeBodyPart();

                Multipart multipart = new MimeMultipart();
                // Part two is attachment
                messageBodyPart = new MimeBodyPart();
                //String filename = GlobalSettingsBean.getDOCROOT() + "\\" + task_document.getDocument_url();
                DataSource source = new FileDataSource(filename);
                messageBodyPart.setDataHandler(new DataHandler(source));
                messageBodyPart.setFileName(filename);
                multipart.addBodyPart(messageBodyPart);

                // Put parts in message
                message.setContent(multipart);
            }
            Transport.send(message);

            System.out.println("Mail sent");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
