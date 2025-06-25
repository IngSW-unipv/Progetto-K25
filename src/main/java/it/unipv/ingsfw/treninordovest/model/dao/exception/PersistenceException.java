package it.unipv.ingsfw.treninordovest.model.dao.exception;

public class PersistenceException extends Exception {
    public PersistenceException() {
        super("Errore durante le operazioni nel Database: ");
    }

}
