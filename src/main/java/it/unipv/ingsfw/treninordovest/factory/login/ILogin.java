package it.unipv.ingsfw.treninordovest.factory.login;

import it.unipv.ingsfw.treninordovest.model.utenti.utente.Utente;

public interface ILogin<T> {
   T login(String username, String password);
}
