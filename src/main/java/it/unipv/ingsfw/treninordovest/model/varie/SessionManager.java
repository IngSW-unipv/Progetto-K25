package it.unipv.ingsfw.treninordovest.model.varie;
import it.unipv.ingsfw.treninordovest.model.utenti.utente.Utente;


/*Classe gestisce la sessione di login*/
public class SessionManager {
    private static SessionManager instance;
    private Utente currentUser;

    private SessionManager() { }

    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    public Utente getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(Utente currentUser) {
        this.currentUser = currentUser;
    }

    public void logout() {
        currentUser = null;
    }
}

