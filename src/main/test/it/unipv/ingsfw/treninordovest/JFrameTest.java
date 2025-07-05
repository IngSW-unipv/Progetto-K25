package it.unipv.ingsfw.treninordovest;

import it.unipv.ingsfw.treninordovest.model.facade.login.RegistrationFacade;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.JTreniNordOvestFrame;
import org.junit.jupiter.api.Test;

import javax.swing.*;

public class JFrameTest  extends JFrame {

    @Test
    public void Test() {

        JTreniNordOvestFrame frame = new JTreniNordOvestFrame();
        RegistrationFacade loginFacade = new RegistrationFacade();

        loginFacade.addPropertyChangeListener(frame);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }


}
