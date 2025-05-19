package it.unipv.ingsfw.treninordovest.facade;

import it.unipv.ingsfw.treninordovest.model.utenti.Cliente;

public interface IUserManagementFacade {

 Cliente mostraDati();
 boolean aggiornaPassword(String password);


}
