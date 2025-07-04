package it.unipv.ingsfw.treninordovest.model.utils;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordUtils {

    private static final int SALT_LENGTH = 16;
    private static final String ALGORITHM = "SHA-256";
    private static final String SEPARATOR = ":";

    public static String hashPassword(String password) {
        try {
            // Genera un salt casuale
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[SALT_LENGTH];
            random.nextBytes(salt);
            
            // Crea il digest con il salt
            MessageDigest md = MessageDigest.getInstance(ALGORITHM);
            md.update(salt);
            byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
            
            // Converte salt e password hashata in stringhe base64
            String saltString = Base64.getEncoder().encodeToString(salt);
            String hashedPasswordString = Base64.getEncoder().encodeToString(hashedPassword);
            
            // Combina salt e hash con un separatore
            return saltString + SEPARATOR + hashedPasswordString;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Errore durante l'hashing della password", e);
        }
    }

    public static boolean verifyPassword(String password, String storedHash) {
        try {
            // Estrae salt e hash dalla stringa memorizzata
            String[] parts = storedHash.split(SEPARATOR);
            if (parts.length != 2) {
                return false;
            }
            
            String saltString = parts[0];
            String hashedPasswordString = parts[1];
            
            // Decodifica il salt
            byte[] salt = Base64.getDecoder().decode(saltString);
            
            // Ricrea l'hash con la password da verificare e lo stesso salt
            MessageDigest md = MessageDigest.getInstance(ALGORITHM);
            md.update(salt);
            byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));
            String hashedPasswordToVerify = Base64.getEncoder().encodeToString(hashedPassword);
            
            // Confronta gli hash
            return hashedPasswordString.equals(hashedPasswordToVerify);
        } catch (NoSuchAlgorithmException | IllegalArgumentException e) {
            return false;
        }
    }
}