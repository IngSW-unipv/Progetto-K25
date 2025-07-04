package it.unipv.ingsfw.treninordovest;

import it.unipv.ingsfw.treninordovest.model.facade.login.LoginFacade;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.JTreniNordOvestFrame;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.UUID;

public class JFrameTest  extends JFrame {

    @Test
    public void Test() {

        JTreniNordOvestFrame frame = new JTreniNordOvestFrame();
        LoginFacade loginFacade = new LoginFacade();

        loginFacade.addPropertyChangeListener(frame);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }


}
