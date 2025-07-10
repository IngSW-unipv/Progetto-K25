package it.unipv.ingsfw.treninordovest;

import it.unipv.ingsfw.treninordovest.model.dto.TitoloDTO;
import it.unipv.ingsfw.treninordovest.model.service.AcquistoService;
import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.Biglietto;
import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.BigliettoDAOImpl;
import it.unipv.ingsfw.treninordovest.model.utils.PasswordUtils;
import org.junit.jupiter.api.Test;

public class MainTest {
    @Test
    void name() {

        Biglietto biglietto;
        BigliettoDAOImpl bigliettoDAO = new BigliettoDAOImpl();

        AcquistoService acquistoService = new AcquistoService();

        try {
            acquistoService.acquistoAbbonamento(new TitoloDTO("fwfwf","wddwdwq",3));

        }catch (Exception e){
            System.out.println("Eccezione: " + e.getMessage());
        }

    }
}
