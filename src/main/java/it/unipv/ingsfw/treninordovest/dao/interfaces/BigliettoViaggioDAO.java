package it.unipv.ingsfw.treninordovest.dao.interfaces;

import it.unipv.ingsfw.treninordovest.model.varie.BigliettoViaggio;

import java.sql.SQLException;

public interface BigliettoViaggioDAO extends DAO<BigliettoViaggio>{

    BigliettoViaggio get(String idBiglietto, String idViaggio) throws SQLException;

}
