package it.unipv.ingsfw.treninordovest.controller;

import it.unipv.ingsfw.treninordovest.dao.implementations.utenti.ClienteDAOImpl;
import it.unipv.ingsfw.treninordovest.model.utenti.Cliente;
import it.unipv.ingsfw.treninordovest.model.varie.GeneraID;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JCustomerRegFrame;
import it.unipv.ingsfw.treninordovest.view.panels.users.CustomerRegistrationPanel;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.Date;
import java.time.LocalDate;

public class CustomerRegController {
    private CustomerRegistrationPanel view;
    private ClienteDAOImpl clienteDAO;
    private JCustomerRegFrame customerRegFrame;

    public CustomerRegController (CustomerRegistrationPanel view, JCustomerRegFrame customerRegFrame) {
        this.view = view;
        this.customerRegFrame = customerRegFrame;
        initController();
    }

    private void initController() {
        view.getBtnRegister().addActionListener(e -> createCustomer());
        //view
    }

    private void createCustomer() {
        GeneraID idGen = new GeneraID("CLX");

        String id = idGen.getID();
        String password = view.getTxtPassword().getText();
        String nome = view.getTxtNome().getText();
        String cognome = view.getTxtCognome().getText();
        String email = view.getTxtEmail().getText();
        String sesso = view.getComboSesso();
        String luogoNascita = view.getTxtLuogoNascita().getText();

        Date dataNascita = view.getDataNascita().getDate();
        LocalDate dataNascitaLocal =dataNascita.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        String cellulare = view.getTxtCellulare().getText();

        String indirizzo = view.getTxtIndirizzo().getText();
        double bilancio = 0;

        if (password.isEmpty() || nome.isEmpty() || cognome.isEmpty() || email.isEmpty() || sesso.isEmpty() || luogoNascita.isEmpty() || cellulare.isEmpty() || indirizzo.isEmpty() ) {
            JOptionPane.showMessageDialog(view, "Compilazione di tutti i campi obbligatoria", "Errore", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Cliente clienteinserito = new Cliente(id,password,nome,cognome,luogoNascita,sesso,dataNascitaLocal,cellulare,indirizzo,0,email);
       try {
           clienteDAO = new ClienteDAOImpl();
          clienteDAO.insert(clienteinserito);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}
