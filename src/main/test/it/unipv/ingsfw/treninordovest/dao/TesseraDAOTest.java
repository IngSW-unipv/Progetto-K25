package it.unipv.ingsfw.treninordovest.dao;

import it.unipv.ingsfw.treninordovest.model.titoli.tessera.TesseraDAO;
import it.unipv.ingsfw.treninordovest.model.titoli.tessera.TesseraDAOImpl;
import org.junit.jupiter.api.Test;

public class TesseraDAOTest {

    @Test
    void getIdTesseraByCustomerIDTest() {
        TesseraDAOImpl dao = new TesseraDAOImpl();
        String idCliente ="41a37ceb-7fb7-4a0c-98b8-11f4c62dcbe3";
        String idCliente2="abc";



        System.out.println(dao.getIdTesseraByCustomerID(idCliente));
        System.out.println(dao.exists(idCliente));
        System.out.println(dao.exists(idCliente2));






    }
}
