package it.unipv.ingsfw.treninordovest.dao.interfaces;

import it.unipv.ingsfw.treninordovest.model.ferrovia.TrattaFermata;

import java.awt.font.TransformAttribute;
import java.sql.SQLException;

public interface TrattaFermataDAO extends DAO<TrattaFermata> {

    TrattaFermata get(String idTratta, String idFermata) throws SQLException;

    TrattaFermata getPartenza(String idTratta) throws SQLException;

    TrattaFermata getArrivo (String idTratta) throws SQLException;



}
