package it.unipv.ingsfw.treninordovest.model.utenti;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
