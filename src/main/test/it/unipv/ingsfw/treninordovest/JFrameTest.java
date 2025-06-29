package it.unipv.ingsfw.treninordovest;

import org.junit.jupiter.api.Test;

import javax.swing.*;

public class JFrameTest  extends JFrame {
    public JFrameTest() {
        CustomerProfilePanel cp = new CustomerProfilePanel();
        this.add(cp);
    }

    @Test
    void MostraPanel() {
        this.setVisible(true);
    }
}
