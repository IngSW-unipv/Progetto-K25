package it.unipv.ingsfw.treninordovest;

import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.JTreniNordOvestFrame;
import org.junit.jupiter.api.Test;

import javax.swing.*;

public class JFrameTest  extends JFrame {
    public JFrameTest() {

    }

    @Test
    void MostraPanel() {JTreniNordOvestFrame  frame = new JTreniNordOvestFrame();
        frame.setVisible(true);
    }
}
