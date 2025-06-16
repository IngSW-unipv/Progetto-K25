package it.unipv.ingsfw.treninordovest.model.varie;

import it.unipv.ingsfw.treninordovest.model.utenti.utente.Utente;

public class SessionManager {
    private Utente currentUser;
    private SessionManager(){}

    private static class Holder {
        static final SessionManager INSTANCE = new SessionManager();
    }

    public static SessionManager getInstance() {
        return Holder.INSTANCE;
    }

    public Utente getCurrentUser() { return currentUser; }

    public void setCurrentUser(Utente u) {
        System.out.println("Utente impostato: " + u.getId() + " " + u.getNome());
        this.currentUser = u;
    }

    public void logout() {
        System.out.println("Logout: " + (currentUser!=null? currentUser.getId() : "nessuno"));
        currentUser = null;
    }
}
