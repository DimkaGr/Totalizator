package by.gritsuk.dima.util;

import by.gritsuk.dima.util.exception.UtilException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

public class MailSender {
    private static final String TLS = "mail.smtp.starttls.enable";
    private static final String HOST = "mail.smtp.host";
    private static final String USER = "mail.smtp.user";
    private static final String PASSWORD = "mail.smtp.password";
    private static final String PORT = "mail.smtp.port";
    private static final String AUTH = "mail.smtp.auth";
    private static final String PROTOCOL = "smtp";

    private static MailSender instance=new MailSender();
    private Properties properties;
    private Session session;

    private MailSender(){
        try {
            properties = new Properties();
            properties.load(MailSender.class.getClassLoader().getResourceAsStream("mail.properties"));
        }catch (IOException e){
//            throw new UtilException("Couldn't find fail mail.properties",e);
            instance=null;
        }
    }

    public static MailSender getInstance(){
        return instance;
    }

    public void sendMail(String mail,String email)throws UtilException{
        try {
            Properties mailProperties=new Properties();
            mailProperties.put(TLS,properties.getProperty(TLS));
            mailProperties.put(PORT,properties.getProperty(PORT));
            mailProperties.put(AUTH,properties.getProperty(AUTH));
            mailProperties.put(HOST,properties.getProperty(HOST));
            mailProperties.put(USER,properties.getProperty(USER));
            mailProperties.put(PASSWORD,properties.getProperty(PASSWORD));
            session=Session.getDefaultInstance(mailProperties,null);
            MimeMessage message=new MimeMessage(session);
//            message.setFrom(new InternetAddress("bet.totalizator@gmail.com"));
            message.setFrom(new InternetAddress(mailProperties.getProperty(USER)));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(email));
            message.setSubject("New account on site\"Totalizator\"");
            message.setText(mail);

            Transport transport=session.getTransport(PROTOCOL);
            transport.connect(mailProperties.getProperty(HOST),mailProperties.getProperty(USER),mailProperties.getProperty(PASSWORD));
            transport.sendMessage(message,message.getAllRecipients());
            transport.close();
        } catch (MessagingException e) {
            throw new UtilException("Mail couldn't be send",e);
        }
    }
}
