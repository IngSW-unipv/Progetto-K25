package it.unipv.ingsfw.treninordovest.dao.interfaces;

import it.unipv.ingsfw.treninordovest.model.utenti.Tessera;

public interface TesseraDAO extends DAO<Tessera> {

    boolean exists(String idCliente) ;

    String getIdTesseraByCustomerID(String idCliente) ;

}
