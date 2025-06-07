package it.unipv.ingsfw.treninordovest.model.utenti.cliente;

import it.unipv.ingsfw.treninordovest.dao.interfaces.DAO;

public interface ClienteDAO extends DAO<Cliente> {

    Cliente autenticate(String id, String password) ;

    boolean updateBilancio(String IdCliente, double prezzo);

    boolean updatePassword (String id, String password);


}
