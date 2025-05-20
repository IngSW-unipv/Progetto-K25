package it.unipv.ingsfw.treninordovest.facade;

import it.unipv.ingsfw.treninordovest.model.utenti.Cliente;
import it.unipv.ingsfw.treninordovest.model.utenti.Utente;

public interface IUserManagementFacade<T> {

 T mostraDati();
 boolean aggiornaPassword(String password);


}
