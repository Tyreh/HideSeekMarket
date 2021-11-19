package co.edu.unbosque.model;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class DMail {
    private String destinatario;
    private String remitente;

    public DMail() {

    }

    public void sendEmail(String asuntoCorreo, String mensajeCorreo) {
        remitente = "sg.epkjtk93x29jpt@gmail.com";

        final String usuario = "";
        final String clave = "";

        String host = "relay.jangosmtp.net";

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "25");

        Session session = Session.getInstance(properties, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(usuario, clave);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(remitente));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
            message.setSubject(asuntoCorreo);
            message.setText(mensajeCorreo);
            Transport.send(message);
            System.out.println("Correo enviado con éxito." + message);
            System.out.println("Asunto:" + asuntoCorreo);
            System.out.println("Mensaje:" + mensajeCorreo);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

/*    public void checkMail() {
        try {
            Properties properties = new Properties();

        } catch () {

        }
    }*/
}
