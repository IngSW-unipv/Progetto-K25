package it.unipv.ingsfw.treninordovest;

import it.unipv.ingsfw.treninordovest.model.dto.TitoloDTO;
import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.Biglietto;
import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.BigliettoDAOImpl;
import it.unipv.ingsfw.treninordovest.model.utils.PasswordUtils;
import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    void name() {

        Biglietto biglietto;
        BigliettoDAOImpl bigliettoDAO = new BigliettoDAOImpl();

        biglietto = bigliettoDAO.get(new Biglietto("2fcea19f-5df3-4df2-a8b5-b5f74cecdee5"));

        System.out.println(biglietto.isValido());

    }
}
