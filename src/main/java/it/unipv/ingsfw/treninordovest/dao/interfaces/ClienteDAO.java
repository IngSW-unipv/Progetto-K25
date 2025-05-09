package it.unipv.ingsfw.treninordovest.dao.interfaces;

import it.unipv.ingsfw.treninordovest.model.utenti.Cliente;

import java.sql.SQLException;

public interface ClienteDAO extends DAO<Cliente> {

    Cliente autenticate(String id, String password) ;

    boolean updateBilancio(String IdCliente, double prezzo);

    boolean updatePassword (String id, String password);


}
