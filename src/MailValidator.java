import java.util.NoSuchElementException;

public class MailValidator {

    /**
     * Überprüft den gegebenen Text, ob es sich um eine gültige E-Mail-Adresse handelt.
     *
     * @param email String - gültige E-Mail-Adresse
     * @return boolean, true, wenn die E-Mail-Adresse gültig ist, false sonst
     * @throws NullPointerException wird ausgelöst, wenn die E-Mail null oder leer ist oder nicht mindestens 10 Zeichen lang ist
     * @throws NoSuchElementException wird ausgelöst, wenn die E-Mail-Adresse das Zeichen '@' nicht enthält
     */
    public static boolean isValid(String email)
            throws NullPointerException, NoSuchElementException {
        if (isEmpty(email)) {
            throw new NullPointerException("ERROR: E-Mail-Text ist null oder leer!");
        }
        if (!hasCorrectLength(email)) {
            throw new NullPointerException("ERROR: E-Mail-Adresse ist zu kurz!");
        }
        if (!containsMailSign(email)) {
            throw new NoSuchElementException("ERROR: E-Mail-Adresse ist ungültig, sie enthält kein @!");
        }
        return true;
    }

    /**
     * Überprüft, ob der Text null oder leer ist, einschließlich Leerzeichen.
     *
     * @param text String - gültige E-Mail-Adresse
     * @return boolean - true, wenn die E-Mail-Adresse leer oder null ist, false sonst
     */
    private static boolean isEmpty(String text) {
        return text == null || text.isBlank();
    }

    /**
     * Überprüft, ob der gegebene Text eine gültige E-Mail-Adresse darstellt und ob er die Mindestlänge von 3 Zeichen hat.
     *
     * @param email String - der zu überprüfende Text als potenzielle E-Mail-Adresse
     * @return boolean - true, wenn die E-Mail-Adresse gültig ist und die Mindestlänge von 3 Zeichen hat, false sonst
     * @throws NullPointerException wenn die übergebene E-Mail-Adresse null oder leer ist
     * @throws NoSuchElementException wenn die übergebene E-Mail-Adresse weniger als 3 Zeichen hat
     */
    public static boolean isTextValid(String email)
            throws NullPointerException, NoSuchElementException {
        // Überprüfen, ob der Text null oder leer ist
        if (isEmpty(email)) {
            throw new NullPointerException("ERROR: Text ist null oder leer");
        }
        // Überprüfen, ob der Text die Mindestlänge von 3 Zeichen hat
        if (!hasCorrectTextLength(email)){
            throw new NoSuchElementException("ERROR: Text ist zu kurz!");
        }
        // Wenn der Text gültig ist, wird true zurückgegeben
        return true;
    }


    /**
     * Überprüft, ob der Text mindestens 10 Zeichen lang ist.
     *
     * @param text String - gültige E-Mail-Adresse
     * @return boolean - true, wenn die E-Mail-Adresse mindestens 10 Zeichen lang ist, false sonst
     */
    private static boolean hasCorrectLength(String text) {
        return text.length() >= 10;
    }

    /**
     * Überprüft, ob der gegebene Text die Mindestlänge von 3 Zeichen hat.
     *
     * @param text String - der zu überprüfende Text
     * @return boolean - true, wenn der Text die Mindestlänge von 3 Zeichen hat, false sonst
     */
    private static boolean hasCorrectTextLength(String text) {
        // Überprüfen, ob die Länge des Textes größer oder gleich 3 ist
        return  text.length() >= 3;
    }

    /**
     * Überprüft, ob der Text das Zeichen '@' enthält.
     *
     * @param mail String - gültige E-Mail-Adresse
     * @return boolean - true, wenn die E-Mail-Adresse das Zeichen '@' enthält, false sonst
     */
    private static boolean containsMailSign(String mail) {
        return mail.contains("@");
    }
}
