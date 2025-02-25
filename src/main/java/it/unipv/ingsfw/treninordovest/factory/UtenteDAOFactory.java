package it.unipv.ingsfw.treninordovest.factory;

import it.unipv.ingsfw.treninordovest.dao.implementations.utenti.ClienteDAOImpl;
import it.unipv.ingsfw.treninordovest.dao.implementations.utenti.DipendenteDAOImpl;
import it.unipv.ingsfw.treninordovest.dao.interfaces.DAO;

public class UtenteDAOFactory {

   // private Database connection;

    public void UtenteDaoFactory() {}

    public DAO<?> getUtenteDao(String tipoAccesso) {
        if ("Cliente".equalsIgnoreCase(tipoAccesso)) {
            return new ClienteDAOImpl();
        } else if ("Dipendente".equalsIgnoreCase(tipoAccesso)) {
            return new DipendenteDAOImpl();
        } else {
            throw new IllegalArgumentException("Tipo di accesso non supportato: " + tipoAccesso);
        }
    }
}


