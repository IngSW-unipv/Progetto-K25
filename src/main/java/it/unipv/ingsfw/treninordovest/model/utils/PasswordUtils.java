package it.unipv.ingsfw.treninordovest.model.utils;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordUtils {

    // 1. Crea un'istanza dell'encoder.
    // BCrypt è la scelta predefinita e raccomandata.
    private static final PasswordEncoder encoder = new BCryptPasswordEncoder();

    /**
     * Esegue l'hashing di una password usando l'algoritmo bcrypt.
     * L'hash generato include già il salt al suo interno.
     *
     * @param plainTextPassword la password in chiaro da cifrare.
     * @return una stringa contenente l'hash della password.
     */
    public static String hashPassword(String plainTextPassword) {
        return encoder.encode(plainTextPassword);
    }

    /**
     * Verifica se una password in chiaro corrisponde a un hash salvato.
     * Il metodo si occupa di estrarre il salt dall'hash e fare il confronto in modo sicuro.
     *
     * @param plainTextPassword la password in chiaro inserita dall'utente.
     * @param hashedPassword l'hash salvato nel database.
     * @return true se le password corrispondono, altrimenti false.
     */
    public static boolean verifyPassword(String plainTextPassword, String hashedPassword) {
        return encoder.matches(plainTextPassword, hashedPassword);
    }
}