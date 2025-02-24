package it.unipv.ingsfw.treninordovest.controller;

import it.unipv.ingsfw.treninordovest.dao.implementations.utenti.ClienteDAOImpl;
import it.unipv.ingsfw.treninordovest.model.utenti.Cliente;
import it.unipv.ingsfw.treninordovest.model.varie.GeneraID;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JCustomerRegFrame;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JMainMenuFrame;
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
        view.getBtnMenuPrincipal().addActionListener(e -> tornaAlMenuPrincipale());
    }
/*Funzione che crea inserisce*/
    private void createCustomer() {
        GeneraID idGen = new GeneraID("CL");
        String id = idGen.getID();
        String password = view.getTxtPassword().getText();  /*Appunto : Mettere la crittazione della password */
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

        if (password.isEmpty() || nome.isEmpty() || cognome.isEmpty() || email.isEmpty() || sesso.isEmpty() || luogoNascita.isEmpty() || cellulare.isEmpty() || indirizzo.isEmpty() || dataNascita.equals(null) ) {
            JOptionPane.showMessageDialog(view, "Compilazione di tutti i campi obbligatoria", "Errore", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Cliente clienteinserito = new Cliente(id,password,nome,cognome,luogoNascita,sesso,dataNascitaLocal,cellulare,indirizzo,0,email);
        clienteDAO = new ClienteDAOImpl();
        try  {
            clienteDAO.insert(clienteinserito);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(view, "Errore riprovare...", "Errore", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

    private void tornaAlMenuPrincipale(){
        JMainMenuFrame mainMenuFrame = new JMainMenuFrame();
        customerRegFrame.setVisible(false);
        mainMenuFrame.setVisible(true);
    }



}
