package it.unipv.ingsfw.treninordovest.model.titoli.abbonamento;

import it.unipv.ingsfw.treninordovest.model.dao.exception.PersistenceException;
import it.unipv.ingsfw.treninordovest.model.dao.interfaces.DAO;

import java.util.List;

public interface AbbonamentoDAO extends DAO<Abbonamento> {
        List<Abbonamento> getAllAbbonamentiByCliente(String idCliente) throws PersistenceException;


}


