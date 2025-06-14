package it.unipv.ingsfw.treninordovest.factory.interfaces;

import it.unipv.ingsfw.treninordovest.model.utenti.utente.Utente;

public interface ILoginAbstractFactory<T>  {
    T login(T t);
    void showUserInterface();

}
