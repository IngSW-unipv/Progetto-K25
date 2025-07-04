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

        treniNordOvestFacade.getLoginFacade().addPropertyChangeListener(frame);

        new GestioneUtenzaController(frame);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }


    @Test
    void TestTreniNordOvestFacade() {


    }
}
