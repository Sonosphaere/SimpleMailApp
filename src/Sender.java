import javax.mail.*;
import javax.mail.internet.*;

public class Sender {



    // Instanzvariablen für SMTP-Verbindung und Session
    private SMTP smtp = null;
    private Session session = null;

    // Konstruktor
    public Sender() {
        // Erzeugung einer SMTP-Verbindung und Session bei Objekterstellung
        this.smtp = new SMTP();
        this.session = this.smtp.getSMTPConnection();
    }

    // Methode zum Senden einer E-Mail
    public boolean send(Mail mail) throws Exception {
        // Erstellen einer MimeMessage mit der vorhandenen Session
        Message message = new MimeMessage(session);

        // Setzen des Absenders, Empfängers und des Betreffs
        message.setFrom(new InternetAddress(this.smtp.getFrom()));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mail.getRecipient()));
        message.setSubject(mail.getSubject());

        // Erstellen und Hinzufügen des Inhalts der E-Mail
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(mail.getMessage(), "text/html; charset=utf-8");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        try {
            // Versenden der E-Mail über Transport.send()
            Transport.send(message);
        } catch (MessageRemovedException ex) {
            // Bei Fehlern während des Versendens wird eine Exception ausgelöst
            throw new Exception("ERROR: Die E-Mail konnte nicht gesendet werden!");
        }

        // Erfolgreiches Versenden der E-Mail wird durch 'true' zurückgegeben
        return true;
    }
}
