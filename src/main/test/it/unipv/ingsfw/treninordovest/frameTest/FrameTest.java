package it.unipv.ingsfw.treninordovest.frameTest;

import it.unipv.ingsfw.treninordovest.view.frames.customer.JCustomerMainFrame;
import it.unipv.ingsfw.treninordovest.view.frames.customer.JCustomerRegFrame;
import it.unipv.ingsfw.treninordovest.view.frames.employee.JEmployeeMainFrame;
import it.unipv.ingsfw.treninordovest.view.frames.employee.JEmployeeRegFrame;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JLoginFrame;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JMainMenuFrame;
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
        JEmployeeMainFrame frame = new JEmployeeMainFrame();
        frame.setVisible(true);
    }
    @Test
    void JEmployeeRegFrame() {
        JEmployeeRegFrame frame = new JEmployeeRegFrame();
        frame.setVisible(true);
    }


    @Test
    void JMainFrameTest() {
        JMainMenuFrame frame = new JMainMenuFrame();
        frame.setVisible(true);
    }
}
