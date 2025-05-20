package it.unipv.ingsfw.treninordovest.controller.customer;

import it.unipv.ingsfw.treninordovest.controller.misc.IController;
import it.unipv.ingsfw.treninordovest.facade.UserRegistrationFacade;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JMainMenuFrame;
import it.unipv.ingsfw.treninordovest.view.frames.registration.JCustomerRegFrame;
import it.unipv.ingsfw.treninordovest.view.panels.users.CustomerRegistrationPanel;

import javax.swing.*;
import java.util.logging.Logger;
import java.util.logging.Level;

public class CustomerRegController implements IController {
    private static final Logger LOGGER = Logger.getLogger(CustomerRegController.class.getName());
    
    private final CustomerRegistrationPanel view;
    private final JCustomerRegFrame customerRegFrame;
    private final UserRegistrationFacade facade;

    /**
     * Costruttore che inizializza il controller
     */
    public CustomerRegController(
            CustomerRegistrationPanel view, 
            JCustomerRegFrame customerRegFrame, 
            UserRegistrationFacade facade) {
        this.view = view;
        this.customerRegFrame = customerRegFrame;
        this.facade = facade;
        init();
    }

    /**
     * Inizializza i listener per i pulsanti
     */
    @Override
    public void init() {
      initView();
    }

    private void initView() {
        view.getBtnRegister().addActionListener(e -> createCustomer());
        view.getBtnMenuPrincipal().addActionListener(e -> tornaAlMenuPrincipale());
    }

    /**
     * Registra un nuovo cliente utilizzando la facade
     */
    private void createCustomer() {
        try {
            LOGGER.info("Avvio registrazione cliente");
            String id = facade.registraCliente(view, customerRegFrame);
            
            if (id != null) {
                LOGGER.info("Cliente registrato con successo: " + id);
                JOptionPane.showMessageDialog(customerRegFrame, "Registrazione completata con successo", "Successo", JOptionPane.INFORMATION_MESSAGE
                );
                tornaAlMenuPrincipale();
            } else {
                LOGGER.warning("Registrazione fallita: ID nullo");
                JOptionPane.showMessageDialog(customerRegFrame, "Registrazione fallita. Verifica i dati inseriti.", "Avviso", JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Errore durante la registrazione del cliente", e);
            JOptionPane.showMessageDialog(customerRegFrame, "Si è verificato un errore durante la registrazione: " + e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Torna al menu principale
     */
    private void tornaAlMenuPrincipale() {
        try {
            JMainMenuFrame mainMenuFrame = new JMainMenuFrame();
            mainMenuFrame.setVisible(true);
            customerRegFrame.setVisible(false);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Errore durante la navigazione al menu principale", e);
            JOptionPane.showMessageDialog(customerRegFrame, "Errore durante il ritorno al menu principale: " + e.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }
}