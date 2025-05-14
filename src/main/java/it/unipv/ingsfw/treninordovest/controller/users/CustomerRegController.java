package it.unipv.ingsfw.treninordovest.controller.users;

import it.unipv.ingsfw.treninordovest.facade.UserRegistrationFacade;
import it.unipv.ingsfw.treninordovest.view.frames.registration.JCustomerRegFrame;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JMainMenuFrame;
import it.unipv.ingsfw.treninordovest.view.panels.users.CustomerRegistrationPanel;

import javax.swing.*;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Controller per la registrazione dei clienti
 */
public class CustomerRegController {
    private static final Logger LOGGER = Logger.getLogger(CustomerRegController.class.getName());
    
    private final CustomerRegistrationPanel view;
    private final JCustomerRegFrame customerRegFrame;
    private final UserRegistrationFacade facade;

    /**
     * Costruttore che inizializza il controller
     * 
     * @param view Pannello di registrazione cliente
     * @param customerRegFrame Frame contenitore
     * @param facade Facade per la registrazione
     */
    public CustomerRegController(CustomerRegistrationPanel view, JCustomerRegFrame customerRegFrame, UserRegistrationFacade facade) {
        this.view = view;
        this.customerRegFrame = customerRegFrame;
        this.facade = facade;
        initController();
    }

    /**
     * Inizializza i listener per i pulsanti
     */
    private void initController() {
        view.getBtnRegister().addActionListener(e -> createCustomer());
        view.getBtnMenuPrincipal().addActionListener(e -> tornaAlMenuPrincipale());
    }

    /**
     * Registra un nuovo cliente utilizzando la facade
     */
    private void createCustomer() {
        
            // La facade gestisce tutti gli aspetti della registrazione,
            // inclusa la validazione e la visualizzazione di messaggi
            String id = facade.registraCliente(view, view);
            // Se la registrazione è avvenuta con successo (id non null),
            // possiamo fare ulteriori operazioni
            if (id != null) {
                LOGGER.info("Cliente registrato con successo: " + id);
                // Opzionalmente, potremmo resettare i campi del form o fare altre operazioni
            }
    }

    /**
     * Torna al menu principale
     */
    private void tornaAlMenuPrincipale() {
        try {
            JMainMenuFrame mainMenuFrame = new JMainMenuFrame();
            customerRegFrame.setVisible(false);
            mainMenuFrame.setVisible(true);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Errore durante il ritorno al menu principale", e);
        }
    }
}