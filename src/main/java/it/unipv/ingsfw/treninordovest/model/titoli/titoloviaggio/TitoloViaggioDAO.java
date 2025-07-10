package it.unipv.ingsfw.treninordovest.model.titoli.titoloviaggio;

import it.unipv.ingsfw.treninordovest.model.dao.interfaces.DAO;

public interface TitoloViaggioDAO extends DAO<TitoloViaggio> {

    TitoloViaggio findByID(String idTitolo) ;

}
