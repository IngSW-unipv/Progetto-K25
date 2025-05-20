package it.unipv.ingsfw.treninordovest.view.frames.miscellanous;

import it.unipv.ingsfw.treninordovest.controller.misc.MainMenuController;
import it.unipv.ingsfw.treninordovest.view.panels.miscellanous.MainMenuPanel;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class JMainMenuFrame extends JFrame implements Observer {


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

    @Override
    public void update(Observable o, Object arg) {
       SwingUtilities.updateComponentTreeUI(this);
       this.pack();
       this.setVisible(true);
       this.setLocationRelativeTo(null);
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.setResizable(false);
       this.setTitle("Treninordovest - Benvenuti");
       this.getContentPane().setBackground(new Color(131, 168, 195));
       this.getContentPane().setLayout(new BorderLayout());
       this.getContentPane().add(mainMenuPanel, BorderLayout.CENTER);

    }



}
