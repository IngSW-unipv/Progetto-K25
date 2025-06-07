package it.unipv.ingsfw.treninordovest.model.ferrovia.treno.tratta;

import it.unipv.ingsfw.treninordovest.dao.interfaces.DAO;

import java.sql.SQLException;

public interface TrenoTrattaDAO extends DAO<TrenoTratta> {

    TrenoTratta getTT(String idTreno, String idTratta) throws SQLException;
}
