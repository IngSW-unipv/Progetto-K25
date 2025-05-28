package it.unipv.ingsfw.treninordovest.controller.misc;

import it.unipv.ingsfw.treninordovest.facade.implementations.gestioneutenti.LoginFacade;
import it.unipv.ingsfw.treninordovest.factory.abstracts.LoginAbstractFactory;
import it.unipv.ingsfw.treninordovest.factory.implementations.LoginFactoryProducer;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JLoginFrame;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JMainMenuFrame;
import it.unipv.ingsfw.treninordovest.view.panels.miscellanous.LoginPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Controller che gestisce le interazioni dell'utente con la schermata di login
 */
public class LoginController  implements ActionListener {

    private final LoginPanel view;
    private final JLoginFrame frame;
    private final LoginFacade loginFacade;

    /**
     * Costruttore che accetta un pannello di login e il frame che lo contiene
     * @param view il pannello di login
     * @param loginFrame il frame contenitore
     */
    public LoginController(LoginPanel view, JLoginFrame loginFrame) {

        this.view = view;
        this.frame = loginFrame;
        this.loginFacade = LoginFacade.getInstance();

        view.addActionListener(this);

    }


    private void doLogin() {
        // Recupera username, password e ruolo dall'interfaccia
        String username = view.getCampoUtente().getText();
        char[] passwordChars = view.getCampoPassword().getPassword();
        String password = new String(passwordChars);
        String ruolo = view.getComboRuolo();

        try {
            LoginAbstractFactory factory = LoginFactoryProducer.getFactoryFromProperties(ruolo);
            loginFacade.effettuaLogin(username, password, ruolo);

            factory.showUserInterface(SessionManager.getInstance().getCurrentUser());
            frame.hideFrame();
        }catch (Exception e) {
            throw new RuntimeException("Errore durante il login: " + e.getMessage(), e);
        }


        

    }

    private void tornaAlMenu() {
        this.frame.hideFrame();
        JMainMenuFrame frame = new JMainMenuFrame();
        frame.showFrame();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case LoginPanel.CMD_Login:
                doLogin();
                break;
            case LoginPanel.CMD_Back:
                tornaAlMenu();
                break;
            default:
                throw new IllegalArgumentException("Comando non supportato: " + e.getActionCommand());
        }


    }





}