package co.edu.unbosque.model;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Correo {

/*
    public static void main (String[] args) {
        //Declare recipient's & sender's e-mail id.
        String destmailid = "odmoreno@unbosque.edu.co";
        String sendrmailid = "sg.epkjtk93x29jpt@gmail.com";
        //Mention user name and password as per your configuration
        final String uname = "sg.epkjtk93x29jpt@gmail.com";
        final String pwd = "c204epk29";
        //We are using relay.jangosmtp.net for sending emails
        String smtphost = "smtp.gmail.com";
        //Set properties and their values
        Properties propvls = new Properties();
        propvls.put("mail.smtp.auth", "true");
        propvls.put("mail.smtp.starttls.enable", "true");
        propvls.put("mail.smtp.host", smtphost);
        propvls.put("mail.smtp.port", "25");
        //Create a Session object & authenticate uid and pwd
        Session sessionobj = Session.getInstance(propvls,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(uname, pwd);
                    }
                });

        try {
            //Create MimeMessage object & set values
            Message messageobj = new MimeMessage(sessionobj);
            messageobj.setFrom(new InternetAddress(sendrmailid));
            messageobj.setRecipients(Message.RecipientType.TO,InternetAddress.parse(destmailid));
            messageobj.setSubject("This is test Subject");
            messageobj.setText("Checking sending emails by using JavaMail APIs");
            //Now send the message
            Transport.send(messageobj);
            System.out.println("Your email sent successfully....");
        } catch (MessagingException exp) {
            throw new RuntimeException(exp);
        }
    }
*/

/*    public static void main(String[] args) {
        try {
            Properties p = new Properties();

            p.put("mail.smtp.host", "smtp.gmail.com");
            p.put("mail.smtp.starttls.enable", "true");
            p.put("mail.smtp.port", "587");
            p.put("mail.smtp.user", "sg.epkjtk93x29jpt@gmail.com");
            p.put("mail.smtp.auth", "true");

            Session s = Session.getDefaultInstance(p, null);
            BodyPart texto = new MimeBodyPart();
            texto.setText("EJEMPLO");
            BodyPart adjunto = new MimeBodyPart();
            MimeMessage mensaje = new MimeMessage(s);
            mensaje.setFrom(new InternetAddress("sg.epkjtk93x29jpt@gmail.com"));
            mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress("odmoreno@unbosque.edu.co"));
            mensaje.setSubject("test");
            Transport t = s.getTransport("smtp");
            t.connect("sg.epkjtk93x29jpt@gmail.com", "c204epk29");
            t.sendMessage(mensaje, mensaje.getAllRecipients());
            t.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    public static void main(String[] args) throws MessagingException {
        String correo = "sg.epkjtk93x29jpt@gmail.com";
        String clave = "rstxgvnepkzgjndp";
        String destino = "odmoreno@unbosque.edu.co";

        Properties p = new Properties();
        p.put("mail.smtp.host", "smtp.gmail.com");
        p.setProperty("mail.smtp.starttls.enable", "true");
        p.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        p.setProperty("mail.smtp.ssl.trust", "587");
        p.setProperty("mail.smtp.user", correo);
        p.setProperty("mail.smtp.auth", "true");

        Session s = Session.getDefaultInstance(p);
        MimeMessage mensaje = new MimeMessage(s);
        mensaje.setFrom(new InternetAddress(correo));
        mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destino));
        mensaje.setSubject("Test");
        mensaje.setText("Test cuerpo");

        Transport t = s.getTransport("smtp");
        t.connect(correo, clave);
        t.sendMessage(mensaje, mensaje.getAllRecipients());
        t.close();
    }
}

