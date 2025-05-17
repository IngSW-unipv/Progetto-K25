package it.unipv.ingsfw.treninordovest.view.frames.registration;

import it.unipv.ingsfw.treninordovest.view.panels.users.CustomerRegistrationPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Frame per la registrazione dei clienti
 */
public class JCustomerRegFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private final CustomerRegistrationPanel customerRegistrationPanel;

    /**
     * Costruttore predefinito che crea un nuovo pannello di registrazione
     */
    public JCustomerRegFrame() {
        this.customerRegistrationPanel = new CustomerRegistrationPanel();
        configuraFrame();
    }

    /**
     * Costruttore che accetta un pannello di registrazione esistente
     * 
     * @param customerRegistrationPanel Pannello di registrazione cliente esistente
     */
    public JCustomerRegFrame(CustomerRegistrationPanel customerRegistrationPanel) {
        this.customerRegistrationPanel = customerRegistrationPanel;
        configuraFrame();
    }
    
    /**
     * Configura le proprietà del frame
     */
    private void configuraFrame() {
        setTitle("Treninordovest - Registrazione cliente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1220, 450);
        setLocationRelativeTo(null);
        inizializzaComponenti();
    }

    /**
     * Inizializza i componenti del frame
     */
    private void inizializzaComponenti() {
        add(customerRegistrationPanel, BorderLayout.CENTER);
    }
    
    /**
     * Mostra il frame
     */
    public void showFrame() {
        setVisible(true);
    }
    
    /**
     * Ottiene il pannello di registrazione
     * 
     * @return Il pannello di registrazione cliente
     */
    public CustomerRegistrationPanel getCustomerRegistrationPanel() {
        return customerRegistrationPanel;
    }
}