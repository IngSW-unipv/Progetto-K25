package it.unipv.ingsfw.treninordovest.frameTest;

import it.unipv.ingsfw.treninordovest.view.frames.utenti.clienti.menu.principale.JCustomerMainFrame;
import it.unipv.ingsfw.treninordovest.view.frames.utenti.clienti.menu.registrazione.JCustomerRegFrame;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.dipendente.panels.EmployeeMainPanel;
import it.unipv.ingsfw.treninordovest.view.frames.utenti.dipendenti.menu.registrazione.JEmployeeRegFrame;
import it.unipv.ingsfw.treninordovest.view.frames.login.JLoginFrame;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.JTreniNordOvestFrame;
import org.junit.jupiter.api.Test;

public class FrameTest {

    @Test
    void JCustomerMainFrameTest() {
        JCustomerMainFrame frame = new JCustomerMainFrame();
        frame.setVisible(true);
    }

    @Test
    void JCustomerRegFrame() {
        JCustomerRegFrame frame = new JCustomerRegFrame();
        frame.setVisible(true);
    }

    @Test
    void JLoginFrameTest() {
        JLoginFrame frame = new JLoginFrame();
        frame.setVisible(true);
    }

    @Test
    void JEmployeeMainFrameTest() {
        EmployeeMainPanel frame = new EmployeeMainPanel();
        frame.setVisible(true);
    }
    @Test
    void JEmployeeRegFrame() {
        JEmployeeRegFrame frame = new JEmployeeRegFrame();
        frame.setVisible(true);
    }


    @Test
    void JMainFrameTest() {
        JTreniNordOvestFrame frame = new JTreniNordOvestFrame();
        frame.setVisible(true);
    }
}
