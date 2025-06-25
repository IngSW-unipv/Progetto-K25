package it.unipv.ingsfw.treninordovest.model.ferrovia.fermata.tratta;

import it.unipv.ingsfw.treninordovest.model.dao.interfaces.DAO;
import it.unipv.ingsfw.treninordovest.model.ferrovia.fermata.Fermata;
import it.unipv.ingsfw.treninordovest.model.ferrovia.tratta.Tratta;

import java.sql.SQLException;

public interface TrattaFermataDAO extends DAO<TrattaFermata> {

    TrattaFermata get(Tratta tratta, Fermata fermata) throws SQLException;

    TrattaFermata getPartenza(Tratta tratta) throws SQLException;

    TrattaFermata getArrivo (Tratta tratta) throws SQLException;



}
