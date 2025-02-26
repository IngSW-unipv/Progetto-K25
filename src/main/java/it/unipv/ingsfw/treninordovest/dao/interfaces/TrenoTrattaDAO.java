package it.unipv.ingsfw.treninordovest.dao.interfaces;

import it.unipv.ingsfw.treninordovest.model.ferrovia.TrenoTratta;

import java.sql.SQLException;

public interface TrenoTrattaDAO extends DAO<TrenoTratta> {

    TrenoTratta getTT(String idTreno, String idTratta) throws SQLException;
}
