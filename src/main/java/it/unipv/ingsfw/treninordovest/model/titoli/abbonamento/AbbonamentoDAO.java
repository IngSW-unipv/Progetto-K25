package it.unipv.ingsfw.treninordovest.model.titoli.abbonamento;

import it.unipv.ingsfw.treninordovest.model.dao.interfaces.DAO;

public interface AbbonamentoDAO extends DAO<Abbonamento> {

    boolean createAbbonamento(Abbonamento abbonamento, String idTessera,String idCliente,String idPagamento);

}
