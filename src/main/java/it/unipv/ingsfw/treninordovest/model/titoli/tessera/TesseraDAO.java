package it.unipv.ingsfw.treninordovest.model.titoli.tessera;

import it.unipv.ingsfw.treninordovest.dao.interfaces.DAO;

public interface TesseraDAO extends DAO<Tessera> {

    boolean exists(String idCliente) ;

    String getIdTesseraByCustomerID(String idCliente) ;

}
