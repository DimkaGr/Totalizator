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
    private static MailSender instance=new MailSender();
    private Properties properties;
    private Session session;

    private MailSender(){
        try {
            properties = new Properties();
            properties.load(MailSender.class.getClassLoader().getResourceAsStream("mail.properties"));
            session=Session.getDefaultInstance(properties);
        }catch (IOException e){
//            throw new UtilException("Couldn't find fail mail.properties",e);
            instance=null;
        }
    }

    public static MailSender getInstance(){
        return instance;
    }

    public void sendMail(String mail,String email)throws UtilException{
        MimeMessage message=new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress("bet.totalizator@gmail.com"));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(email));
            message.setSubject("New account on site\"Totalizator\"");
            message.setText(mail);

            Transport transport=session.getTransport();
            transport.connect(null,"AAA54321");
            transport.sendMessage(message,message.getAllRecipients());
            transport.close();
        } catch (MessagingException e) {
            throw new UtilException("Mail couldn't be send",e);
        }
    }
}
