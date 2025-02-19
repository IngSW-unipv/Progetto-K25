package it.unipv.ingsfw.treninordovest.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {

    /*Interfaccia generica per DAO degli utenti*/
    T get(String id) throws SQLException;
    List<T> getAll() throws SQLException;
    int save(T t) throws SQLException;
    int delete(int id) throws SQLException;
    int update(T t) throws SQLException;
    int insert(T t) throws SQLException;

}
