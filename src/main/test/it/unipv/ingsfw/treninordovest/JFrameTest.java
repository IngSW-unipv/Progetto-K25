package it.unipv.ingsfw.treninordovest;

import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.JTreniNordOvestFrame;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.UUID;

public class JFrameTest  extends JFrame {
    public JFrameTest() {

        System.out.println(UUID.randomUUID().toString());

    }

    @Test
    void MostraPanel() {JTreniNordOvestFrame  frame = new JTreniNordOvestFrame();
        frame.setVisible(true);
    }
}
