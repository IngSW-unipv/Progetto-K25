package it.unipv.ingsfw.treninordovest.controller.users;

import it.unipv.ingsfw.treninordovest.facade.UserRegistrationFacade;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JMainMenuFrame;
import it.unipv.ingsfw.treninordovest.view.frames.registration.JEmployeeRegFrame;
import it.unipv.ingsfw.treninordovest.view.panels.users.EmployeeRegistrationPanel;

import javax.swing.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmployeeRegController {
    private static final Logger LOGGER = Logger.getLogger(EmployeeRegController.class.getName());
    
    private final EmployeeRegistrationPanel view;
    private final JEmployeeRegFrame employeeRegFrame;
    private final UserRegistrationFacade facade;

    /**
     * Costruttore che inizializza il controller
     */
    public EmployeeRegController(
            EmployeeRegistrationPanel view,
            JEmployeeRegFrame employeeRegFrame,
            UserRegistrationFacade facade) {
        this.view = view;
        this.employeeRegFrame = employeeRegFrame;
        this.facade = facade;
        initController();
    }

    /**
     * Inizializza i listener per i pulsanti
     */
    private void initController() {
        view.getBtnRegister().addActionListener(e -> createEmployee());
        view.getBtnMenuPrincipal().addActionListener(e -> tornaAlMenuPrincipale());
    }

    /**
     * Registra un nuovo dipendente utilizzando la facade
     */
    private void createEmployee() {
        try {
            LOGGER.info("Avvio registrazione dipendente");
            String id = facade.registraDipendente(view, employeeRegFrame);
            
            if (id != null) {
                LOGGER.info("Dipendente registrato con successo: " + id);
                JOptionPane.showMessageDialog(
                    employeeRegFrame,
                    "Registrazione completata con successo",
                    "Successo",
                    JOptionPane.INFORMATION_MESSAGE
                );
                tornaAlMenuPrincipale();
            } else {
                LOGGER.warning("Registrazione fallita: ID nullo");
                JOptionPane.showMessageDialog(
                    employeeRegFrame,
                    "Registrazione fallita. Verifica i dati inseriti.",
                    "Avviso",
                    JOptionPane.WARNING_MESSAGE
                );
            }
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Errore durante la registrazione del dipendente", e);
            JOptionPane.showMessageDialog(
                employeeRegFrame,
                "Si è verificato un errore durante la registrazione: " + e.getMessage(),
                "Errore",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    /**
     * Torna al menu principale
     */
    private void tornaAlMenuPrincipale() {
        try {
            JMainMenuFrame mainMenuFrame = new JMainMenuFrame();
            mainMenuFrame.setVisible(true);
            employeeRegFrame.setVisible(false);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Errore durante la navigazione al menu principale", e);
            JOptionPane.showMessageDialog(
                employeeRegFrame,
                "Errore durante il ritorno al menu principale: " + e.getMessage(),
                "Errore",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
}