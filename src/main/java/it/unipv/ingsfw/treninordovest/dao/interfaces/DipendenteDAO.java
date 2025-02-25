package it.unipv.ingsfw.treninordovest.dao.interfaces;

import it.unipv.ingsfw.treninordovest.model.utenti.Cliente;
import it.unipv.ingsfw.treninordovest.model.utenti.Dipendente;

import java.sql.SQLException;

public interface DipendenteDAO extends DAO<Dipendente> {
    Dipendente autenticate(String id, String password) throws SQLException;
}
