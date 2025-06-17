package it.unipv.ingsfw.treninordovest.model.titoli.tessera;

import it.unipv.ingsfw.treninordovest.dao.interfaces.DAO;

public interface TesseraDAO extends DAO<Tessera> {

    boolean exists(String idCliente) ;

    String getIdCustomer(String idCliente) ;

    boolean createTessera(Tessera tessera, String idCliente) ;

}
