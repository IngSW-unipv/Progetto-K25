package it.unipv.ingsfw.treninordovest.model.utenti.dipendente;

import it.unipv.ingsfw.treninordovest.model.dao.interfaces.DAO;

import java.sql.SQLException;

public interface DipendenteDAO extends DAO<Dipendente> {
    Dipendente autenticate(Dipendente dipendente) throws SQLException;

    boolean updatePassword (Dipendente dipendente);
}
