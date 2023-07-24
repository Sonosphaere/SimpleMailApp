import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

public class SMTP {



    // Statische Variablen für die Konfiguration
    private static final String FROM = "XXXX";
    private static final String USERNAME = "XXXXX";
    private static final String PASSWORD = "XXXX";
    private static final String HOST = "XXXXX";
    private static final String PORT = "XXX";
    private Properties prop = null;

    // Konstruktor
    public SMTP(){
        // Initialisierung der Properties
        Properties prop = new Properties();
        this.prop = new Properties();

        // Setzen der SMTP-Konfiguration
        this.prop.put("mail.smtp.auth", true);
        this.prop.put("mail.smtp.starttls.enable", "true");  //Neuestes Protokoll (SSL wurde schon gehackt)
        this.prop.put("mail.smtp.host", HOST);
        this.prop.put("mail.smtp.port", PORT);
        this.prop.put("mail.smtp.ssl.trust", HOST);
        this.prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    }

    // Methode zum Abrufen der SMTP-Verbindung
    public Session getSMTPConnection() throws NullPointerException {
        Session session = null;
        if (this.prop != null) {
            // Erstellung der Verbindungssession mit Benutzerauthentifizierung
            session = Session.getInstance(this.prop, new Authenticator() {
                @Override
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(USERNAME, PASSWORD);
                }
            });
        } else {
            throw new NullPointerException("Fehler: prop ist null");
        }

        return session;
    }

    // Methode zum Abrufen des Absenders (FROM)
    public String getFrom() {
        return FROM;
    }
}
