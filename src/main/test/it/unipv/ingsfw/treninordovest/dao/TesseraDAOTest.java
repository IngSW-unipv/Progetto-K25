package it.unipv.ingsfw.treninordovest.dao;

import it.unipv.ingsfw.treninordovest.model.titoli.tessera.TesseraDAO;
import it.unipv.ingsfw.treninordovest.model.titoli.tessera.TesseraDAOImpl;
import org.junit.jupiter.api.Test;

public class TesseraDAOTest {

    @Test
    void getIdTesseraByCustomerIDTest() {
        TesseraDAOImpl dao = new TesseraDAOImpl();



        System.out.println(dao.getIdTesseraByCustomerID("41a37ceb-7fb7-4a0c-98b8-11f4c62dcbe3"));




    }
}
