package it.unipv.ingsfw.treninordovest.dao;

import it.unipv.ingsfw.treninordovest.model.ferrovia.viaggio.Viaggio;
import it.unipv.ingsfw.treninordovest.model.ferrovia.viaggio.ViaggioDAO;
import it.unipv.ingsfw.treninordovest.model.ferrovia.viaggio.ViaggioDAOImpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ViaggioDAOTest {

    @Test
    void ViaggioTestDAO() {

        ViaggioDAOImpl dao = new ViaggioDAOImpl();

        List<Viaggio> viaggi = new ArrayList<Viaggio>();

        viaggi = dao.getAll();

        for (Viaggio v : viaggi) {
            System.out.println(v);
        }


    }
}
