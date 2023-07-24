import java.util.Scanner;

/**
 * Die Hauptklasse der Anwendung, die das Versenden einer E-Mail ermöglicht.
 */
public class main {

    /**
     * Der Einstiegspunkt der Anwendung.
     * Hier wird die Methode sendMail() aufgerufen, um eine E-Mail zu versenden.
     * Eventuelle Fehlermeldungen werden abgefangen und auf der Konsole ausgegeben.
     *
     */
    public static void main(String[] args) {
        try {
            sendMail();
        } catch (Exception ex) {
            System.out.println("FATAL: " + ex.getMessage());
        }
    }

    /**
     * Die Methode sendMail() ermöglicht dem Benutzer, eine E-Mail zu versenden.
     * Sie fordert den Benutzer auf, den Empfänger, den Betreff und den Mailinhalt einzugeben.
     * Dabei wird die Eingabe validiert, um sicherzustellen, dass sie den Anforderungen entspricht.
     * Anschließend wird die eingegebene E-Mail mit Hilfe der Sender-Klasse versendet.
     */
    public static void sendMail() {

        // Eingabe des Empfängers mit Validierung
        Scanner eingabe = new Scanner(System.in);
        String recipient = null;
        boolean isValid = false;

        while(!isValid) {
            System.out.println("Bitte Empfänger eingeben: ");
            recipient = eingabe.nextLine();

            try {
                isValid = MailValidator.isValid(recipient);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        // Eingabe des Betreffs mit Validierung
        String subject = null;
        boolean isSubjectValid = false;

        while (!isSubjectValid) {
            System.out.println("Bitte Betreff eingeben: ");
            subject = eingabe.nextLine();

            try {
                isSubjectValid = MailValidator.isTextValid(subject);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        // Eingabe des Mailinhalts mit Validierung
        isValid = false;
        String message = null;

        while (!isValid) {
            System.out.println("Bitte Mailinhalt eingeben: ");
            message = eingabe.nextLine();

            try {
                isValid = MailValidator.isTextValid(message);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

        // Erstellen einer neuen Mail und Setzen der Daten
        Mail newMail = new Mail();
        newMail.setRecipient(recipient);
        newMail.setSubject(subject);
        newMail.setMessage(message);

        // Versenden der E-Mail
        try {
            Sender sender = new Sender();
            sender.send(newMail);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
