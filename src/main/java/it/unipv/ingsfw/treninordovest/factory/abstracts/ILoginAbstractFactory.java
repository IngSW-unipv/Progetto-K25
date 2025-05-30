package it.unipv.ingsfw.treninordovest.factory.abstracts;

import it.unipv.ingsfw.treninordovest.model.utenti.Utente;

public interface ILoginAbstractFactory {
    Utente login(String username, String password);
    void showUserInterface(Utente utente);

}
