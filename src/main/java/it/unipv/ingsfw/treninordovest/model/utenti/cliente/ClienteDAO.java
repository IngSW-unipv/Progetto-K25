package it.unipv.ingsfw.treninordovest.model.utenti.cliente;

import it.unipv.ingsfw.treninordovest.dao.interfaces.DAO;

public interface ClienteDAO extends DAO<Cliente> {

    Cliente findById(String id);

    Cliente autenticate(Cliente cliente) ;

    boolean updateBilancio(Cliente cliente) ;

    boolean updatePassword (Cliente cliente) ;


}
