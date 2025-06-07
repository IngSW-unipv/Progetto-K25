package it.unipv.ingsfw.treninordovest.controller.provvisorio.customer;

import it.unipv.ingsfw.treninordovest.facade.implementations.gestioneutenti.UserRegistrationFacade;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JMainMenuFrame;
import it.unipv.ingsfw.treninordovest.view.frames.customer.JCustomerRegFrame;
import it.unipv.ingsfw.treninordovest.view.panels.users.CustomerRegistrationPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Logger;
import java.util.logging.Level;
//
//public class CustomerRegController implements ActionListener {
//    private static final Logger LOGGER = Logger.getLogger(CustomerRegController.class.getName());
//
//    private final CustomerRegistrationPanel view;
//    private final JCustomerRegFrame customerRegFrame;
//    private final UserRegistrationFacade facade;
//
//    private final Runnable onRegister;
//    private final Runnable onBack;
//
//    /**
//     * Costruttore che inizializza il controller
//     */
//    public CustomerRegController(CustomerRegistrationPanel view, JCustomerRegFrame customerRegFrame, Runnable onRegister, Runnable onBack) {
//        this.view = view;
//        this.customerRegFrame = customerRegFrame;
//        this.facade = new UserRegistrationFacade();
//
//        view.addActionListener(this);
//
//        this.onRegister = onRegister;
//        this.onBack = onBack;
//
//
//    }
//
//    /**
//     * Registra un nuovo cliente utilizzando la facade
//     */
//    private void createCustomer() {
//        try {
//            LOGGER.info("Avvio registrazione cliente");
//            String id = facade.registraCliente(view, customerRegFrame);
//
//            if (id != null) {
//                LOGGER.info("Cliente registrato con successo: " + id);
//                JOptionPane.showMessageDialog(customerRegFrame, "Registrazione completata con successo", "Successo", JOptionPane.INFORMATION_MESSAGE
//                );
//                tornaAlMenuPrincipale();
//            } else {
//                LOGGER.warning("Registrazione fallita: ID nullo");
//                JOptionPane.showMessageDialog(customerRegFrame, "Registrazione fallita. Verifica i dati inseriti.", "Avviso", JOptionPane.WARNING_MESSAGE);
//            }
//        } catch (Exception e) {
//            LOGGER.log(Level.SEVERE, "Errore durante la registrazione del cliente", e);
//            JOptionPane.showMessageDialog(customerRegFrame, "Si è verificato un errore durante la registrazione: " + e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
//        }
//    }
//
//    /**
//     * Torna al menu principale
//     */
//    private void tornaAlMenuPrincipale() {
//        try {
//            JMainMenuFrame mainMenuFrame = new JMainMenuFrame();
//            mainMenuFrame.showFrame();
//            customerRegFrame.hideFrame();
//        } catch (Exception e) {
//            LOGGER.log(Level.SEVERE, "Errore durante la navigazione al menu principale", e);
//            JOptionPane.showMessageDialog(customerRegFrame, "Errore durante il ritorno al menu principale: " + e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
//        }
//    }
//
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        switch (e.getActionCommand()) {
//            case CustomerRegistrationPanel.CMD_Register:
//                this.createCustomer();
//                break;
//            case CustomerRegistrationPanel.CMD_Back:
//                this.tornaAlMenuPrincipale();
//                break;
//            default:
//                throw new IllegalArgumentException("Comando non supportato: " + e.getActionCommand());
//        }
//
//    }
//}