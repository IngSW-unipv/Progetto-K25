package it.unipv.ingsfw.treninordovest.application;

import it.unipv.ingsfw.treninordovest.controller.misc.MainMenuController;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JMainMenuFrame;
import it.unipv.ingsfw.treninordovest.view.panels.miscellanous.MainMenuPanel;

import javax.swing.*;

public class MainMenuApplication {

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                MainMenuPanel panel = new MainMenuPanel();
                MainMenuController controller = new MainMenuController(panel);
                JMainMenuFrame frame = new JMainMenuFrame();
                controller.addPropertyChangeListener(frame);
                frame.setVisible(true);
            });
        }

}
