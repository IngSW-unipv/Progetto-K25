package it.unipv.ingsfw.treninordovest.dao;

import it.unipv.ingsfw.treninordovest.model.titoli.tessera.TesseraDAO;
import it.unipv.ingsfw.treninordovest.model.titoli.tessera.TesseraDAOImpl;
import org.junit.jupiter.api.Test;

public class TesseraDAOTest {

    @Test
    void getIdTesseraByCustomerIDTest() {
        TesseraDAOImpl dao = new TesseraDAOImpl();
        String idCliente ="9984e689-8418-4394-b9ca-1e7950a0feb9";
        String tesseraAttesa = "c86b9cf8-d5b5-4cf0-b25a-55555ce33581";

        String idCTesseraEstratta = dao.getIdTesseraByCustomerID(idCliente);


        System.out.println("Tessera estratta:" + tesseraAttesa);
        System.out.println("Tessera estratta :" + idCTesseraEstratta);










    }
}
