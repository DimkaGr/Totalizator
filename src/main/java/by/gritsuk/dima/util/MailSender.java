package by.gritsuk.dima.util;

import by.gritsuk.dima.util.exception.UtilException;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Properties;

public class MailSender {
    private final String USERNAME = "bet.totalizator@gmail.com";
    private final String PASSWORD = "AAA54321";

    private static MailSender instance=new MailSender();

    private MailSender(){
    }

    public static MailSender getInstance(){
        return instance;
    }

    public void sendMail(String mail,String email)throws UtilException{
        try {
            Properties props = new Properties();
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.starttls.enable", "true");
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.port", "587");
            Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(USERNAME, PASSWORD);
                }
            });

            MimeMessage message=new MimeMessage(session);

            message.setFrom(new InternetAddress("bet.totalizator@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("New account on site\"Totalizator\"");
            message.setText(mail);

            Transport.send(message);
        } catch (MessagingException e) {
            throw new UtilException("Mail couldn't be send",e);
        }
    }
}
