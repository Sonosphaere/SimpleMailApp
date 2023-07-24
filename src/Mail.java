/**
 * POJO ist eine Java-Klasse, die einfach, unabhängig von Frameworks, und frei von speziellen Abhängigkeiten ist.
 * Es handelt sich um eine herkömmliche Java-Klasse, die keine speziellen Einschränkungen oder Besonderheiten hat,
 * sondern lediglich die üblichen Konventionen und Strukturen einer Java-Klasse verwendet. POJOs sind
 * vielseitig einsetzbar und werden oft als Datenobjekte oder Model-Klassen in Java-Anwendungen verwendet,
 * um Daten zu repräsentieren und zwischen verschiedenen Komponenten zu übertragen.
 * <p>
 * Merkmale:
 * =>Einfache Klassenstruktur - Feldern (Instanzvariablen), Methoden, Konstruktoren und Getter-/Setter-Methoden
 * erbt nicht von speziellen Klassen oder implementiert spezielle Schnittstellen
 *
 * =>Standard Java-Klassen - POJOs verwenden Standard-Bibliotheken und Klassen aus der Java Standard Edition (JSE)
 * und sind unabhängig von Framework-spezifischen Klassen oder APIs.
 *
 * =>Keine speziellen Annotationen - nur die in Java integrierten Annotations, verzichten in vielen Fällen
 * ganz auf Annotations.
 *
 * =>Unabhängig von Frameworks - sollte nicht von spezifischen Frameworks abhängen.
 * Dadurch wird die Wiederverwendbarkeit und Portabilität der Klasse verbessert.
 */


public class Mail {

    // Attribute für die E-Mail
    private String sender;
    private String recipient;
    private String subject;
    private String message;

    // Standardkonstruktor
    public Mail() {

    }

    // Methode zum Abrufen des Absenders
    public String getSender() {
        return this.sender;
    }

    // Methode zum Setzen des Absenders
    public void setSender(String sender) {
        this.sender = sender;
    }

    // Methode zum Abrufen des Empfängers
    public String getRecipient() {
        return recipient;
    }

    // Methode zum Setzen des Empfängers
    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    // Methode zum Abrufen des Betreffs
    public String getSubject() {
        return subject;
    }

    // Methode zum Setzen des Betreffs
    public void setSubject(String subject) {
        this.subject = subject;
    }

    // Methode zum Abrufen der Nachricht
    public String getMessage() {
        return message;
    }

    // Methode zum Setzen der Nachricht
    public void setMessage(String message) {
        this.message = message;
    }
}


