package it.unipv.ingsfw.treninordovest.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {

    /*Interfaccia generica per DAO degli utenti*/
    T get(T oggetto) ;
    List<T> getAll();
    void delete(T t) ;
    void update(T t);
    void insert(T t);

}
