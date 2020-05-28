import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
public class SendMail {
    public static void send(String to,String sub,String msg,final String admin,final String pass){
        Properties pros = new Properties();
        pros.put("mail.smtp.host", "smtp.gmail.com");
        pros.put("mail.smtp.port","587");
        pros.put("mail.smtp.auth","true");
        pros.put("mail.smtp.starttls.enable","true");
        Session session = Session.getInstance(pros, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication(){
               return new PasswordAuthentication(admin,pass);  
            }    
        }
        );
        try{
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(admin));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(sub);
            message.setText(msg);
            Transport.send(message);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
}
