package it.unipv.ingsfw.treninordovest.view.frames.login;

import it.unipv.ingsfw.treninordovest.controller.LoginController;
import it.unipv.ingsfw.treninordovest.view.panels.miscellanous.LoginPanel;

import javax.swing.*;

public class JLoginFrame extends JFrame {

   private LoginPanel loginPanel;
   private LoginController loginController;

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
        loginController = new LoginController(loginPanel,this);

    }

    // Metodi getter per i componenti







}
