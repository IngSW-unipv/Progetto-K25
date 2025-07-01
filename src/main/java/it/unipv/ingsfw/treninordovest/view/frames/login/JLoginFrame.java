package it.unipv.ingsfw.treninordovest.view.frames.login;

//import it.unipv.ingsfw.treninordovest.controller.provvisorio.misc.LoginController;

import it.unipv.ingsfw.treninordovest.controller.GestioneUtenzaController;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.login.LoginPanel;

import javax.swing.*;

/**
 * Frame per la schermata di login
 */
public class JLoginFrame extends JFrame  {


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

       // new LoginController(loginPanel, this);
    }


    /**
     * Metodo per mostrare il frame
     */
    public void showFrame() {
        setVisible(true);
    }

    public void hideFrame() {
        setVisible(false);
    }

    public LoginPanel getLoginPanel() {
        return loginPanel;
    }


//
//    @Override
//    public void propertyChange(PropertyChangeEvent evt) {
//        if (!"command".equals(evt.getPropertyName())) return;
//        String cmd =(String) evt.getNewValue();
//
//        if ("login".equals(cmd)) {
//        }
//
//    }
}