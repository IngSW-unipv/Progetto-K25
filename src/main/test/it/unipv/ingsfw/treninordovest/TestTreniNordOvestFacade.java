package it.unipv.ingsfw.treninordovest;

import it.unipv.ingsfw.treninordovest.facade.TreniNordOvestFacade;
import it.unipv.ingsfw.treninordovest.facade.acquisto.AcquistoFacade;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.JTreniNordOvestFrame;
import org.junit.jupiter.api.Test;

import javax.swing.*;

public class TestTreniNordOvestFacade {

    public static void main(String[] args) {

        TreniNordOvestFacade treniNordOvestFacade = TreniNordOvestFacade.getInstance();

        JTreniNordOvestFrame frame = new JTreniNordOvestFrame();

        treniNordOvestFacade.getLoginFacade().addPropertyChangeListener(frame);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }


    @Test
    void TestTreniNordOvestFacade() {


    }
}
