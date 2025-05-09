package it.unipv.ingsfw.treninordovest.dao.implementations;

import it.unipv.ingsfw.treninordovest.dao.database.Database;
import it.unipv.ingsfw.treninordovest.dao.implementations.titoli.RimborsoDAOImpl;
import it.unipv.ingsfw.treninordovest.model.titoli.Rimborso;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RimborsoDAOImplTest {

    private RimborsoDAOImpl dao = new RimborsoDAOImpl();
    private final String TEST_ID = "RIMB_TEST";

    @Test
    void get() {
        Rimborso rimborso = new Rimborso(TEST_ID, LocalDate.now(), 100.0, "BIG123", "USR123");
        dao.insert(rimborso);

        Rimborso result = dao.get(TEST_ID);
        assertNotNull(result);
        assertEquals(TEST_ID, result.getIdRimborso());


    }

    @Test
    void getAll() {
        // Supponendo che tu abbia una classe RimborsoDAOImpl con metodo getAll()
        List<Rimborso> rimborsi = dao.getAll();
        assertNotNull(rimborsi); // La lista non deve essere nulla
        // Puoi aggiungere altre asserzioni, ad esempio assertFalse(rimborsi.isEmpty());

    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }

    @Test
    void insert() {
    }
}