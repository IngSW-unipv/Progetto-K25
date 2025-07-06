package it.unipv.ingsfw.treninordovest;

import it.unipv.ingsfw.treninordovest.controller.AcquistoController;
import it.unipv.ingsfw.treninordovest.controller.GestioneUtenzaController;
import it.unipv.ingsfw.treninordovest.model.facade.TreniNordOvestFacade;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.JTreniNordOvestFrame;
import org.junit.jupiter.api.Test;

import javax.swing.*;

public class TreniNordOvestMainTest {

    public static void main(String[] args) {

        TreniNordOvestFacade treniNordOvestFacade = TreniNordOvestFacade.getInstance();

        JTreniNordOvestFrame frame = new JTreniNordOvestFrame();

        treniNordOvestFacade.getRegistrationFacade().addPropertyChangeListener(frame);
        treniNordOvestFacade.getAcquistoFacade().addPropertyChangeListener(frame);

        new GestioneUtenzaController(frame);
        new AcquistoController(frame);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }


    @Test
    void TestTreniNordOvestFacade() {


    }
}
