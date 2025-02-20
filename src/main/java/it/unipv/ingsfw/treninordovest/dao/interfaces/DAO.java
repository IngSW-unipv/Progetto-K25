package it.unipv.ingsfw.treninordovest.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {

    /*Interfaccia generica per DAO degli utenti*/
    T get(String id) throws SQLException;
    List<T> getAll() throws SQLException;
    void delete(String id) throws SQLException;
    void update(T t) throws SQLException;
    void insert(T t) throws SQLException;

}
