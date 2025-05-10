package it.unipv.ingsfw.treninordovest.view.frames.login;

import it.unipv.ingsfw.treninordovest.view.panels.miscellanous.LoginPanel;

import javax.swing.*;

/**
 * Frame per la schermata di login
 */
public class JLoginFrame extends JFrame {

   private LoginPanel loginPanel;

    public JLoginFrame() {
        setTitle("Treninordovest - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(820, 230);
        setLocationRelativeTo(null);
        inizializzaComponenti();
    }

    private void inizializzaComponenti() {
        loginPanel = new LoginPanel();
        add(loginPanel);
    }

    
    /**
     * Restituisce il pannello di login contenuto nel frame
     * @return il pannello di login
     */
    public LoginPanel getLoginPanel() {
        return loginPanel;
    }


    
    /**
     * Metodo per mostrare il frame
     */
    public void showFrame() {
        setVisible(true);
    }
}