package it.unipv.ingsfw.treninordovest.facade.login;

import it.unipv.ingsfw.treninordovest.model.utenti.utente.Utente;

public interface ILoginFacade {

    boolean login(Utente utente, String tipoUtente);

}
