package it.unipv.ingsfw.treninordovest.view.frames.miscellanous;

import it.unipv.ingsfw.treninordovest.controller.MainMenuController;
import it.unipv.ingsfw.treninordovest.view.panels.miscellanous.LogoPanel;
import it.unipv.ingsfw.treninordovest.view.panels.miscellanous.MainMenuPanel;

import javax.swing.*;
import java.awt.*;

public class JMainMenuFrame extends JFrame {

    private MainMenuPanel mainMenuPanel = new MainMenuPanel();
    private MainMenuController mainMenuController;

    public JMainMenuFrame() {
        setTitle("Treninordovest - Benvenuti");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(820, 230);
        setLocationRelativeTo(null);
        inizializzaComponenti();
    }

    private void inizializzaComponenti() {

        add(mainMenuPanel, BorderLayout.CENTER);
        mainMenuController = new MainMenuController(mainMenuPanel,this);

    }




}
