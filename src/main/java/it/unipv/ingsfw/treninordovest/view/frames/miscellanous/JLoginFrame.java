package it.unipv.ingsfw.treninordovest.view.frames.miscellanous;

import it.unipv.ingsfw.treninordovest.view.panels.miscellanous.LoginPanel;
import it.unipv.ingsfw.treninordovest.view.panels.miscellanous.LogoPanel;

import javax.swing.*;
import java.awt.*;

public class JLoginFrame extends JFrame {

   private JPanel loginPanel;

    public JLoginFrame() {
        setTitle("Treninordovest - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(820, 230);
        setLocationRelativeTo(null);
        //coloreSfondo = new Color(131,168,195);
        inizializzaComponenti();
    }

    private void inizializzaComponenti() {
        loginPanel = new LoginPanel();
        add(loginPanel);

    }

    // Metodi getter per i componenti







}
