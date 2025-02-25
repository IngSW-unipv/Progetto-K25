package it.unipv.ingsfw.treninordovest.controller;

import it.unipv.ingsfw.treninordovest.dao.implementations.utenti.ClienteDAOImpl;
import it.unipv.ingsfw.treninordovest.dao.implementations.utenti.DipendenteDAOImpl;
import it.unipv.ingsfw.treninordovest.dao.interfaces.ClienteDAO;
import it.unipv.ingsfw.treninordovest.dao.interfaces.DipendenteDAO;
import it.unipv.ingsfw.treninordovest.factory.UtenteDAOFactory;
import it.unipv.ingsfw.treninordovest.model.utenti.Utente;
import it.unipv.ingsfw.treninordovest.model.varie.Ruolo;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;
import it.unipv.ingsfw.treninordovest.view.panels.miscellanous.LoginPanel;


import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;

public class LoginController {
    private LoginPanel view;
    private Connection connection;
    private Ruolo ruolo; // CLIENTE o DIPENDENTE

    public LoginController(LoginPanel view, Connection connection /*, Ruolo ruolo*/) {
        this.view = view;
        this.connection = connection;
        //this.ruolo = ruolo;
        initController();
    }

    private void initController() {
        view.getBottoneAccesso().addActionListener(e -> doLogin());
    }

    private void doLogin() {
        String username = view.getCampoUtente().getText();
        String password = view.getCampoPassword().getText();
        String ruolo = view.getComboRuolo();
        UtenteDAOFactory utenteDAOFactory= new UtenteDAOFactory();

        try {
            utenteDAOFactory.getUtenteDao(ruolo);




        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(view, "Errore nel DB: " + ex.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }
}

