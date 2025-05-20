package it.unipv.ingsfw.treninordovest.view.frames.miscellanous;

import it.unipv.ingsfw.treninordovest.view.panels.miscellanous.LoginPanel;

import javax.swing.*;
import java.util.Observable;
import java.util.Observer;

/**
 * Frame per la schermata di login
 */
public class JLoginFrame extends JFrame implements Observer {


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

    @Override
    public void update(Observable o, Object arg) {
        if (arg.equals("login")) {
            dispose();
        } else if (arg.equals("registrazione")) {
            dispose();
        } else if (arg.equals("errore")) {
            JOptionPane.showMessageDialog(this, "Errore di login", "Errore", JOptionPane.ERROR_MESSAGE);
        } else if (arg.equals("erroreRegistrazione")) {
            JOptionPane.showMessageDialog(this, "Errore nella registrazione", "Errore", JOptionPane.ERROR_MESSAGE);
        } else if (arg.equals("erroreConferma")) {}

    }
}