package it.unipv.ingsfw.treninordovest.model.utenti.cliente;

import it.unipv.ingsfw.treninordovest.model.dao.interfaces.DAO;

public interface ClienteDAO extends DAO<Cliente> {



    Cliente autenticateByEmail(Cliente credentials) ;




    boolean updatePassword (Cliente cliente) ;


}
