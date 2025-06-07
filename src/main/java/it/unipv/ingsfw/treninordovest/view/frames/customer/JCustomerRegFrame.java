package it.unipv.ingsfw.treninordovest.view.frames.customer;

import it.unipv.ingsfw.treninordovest.controller.provvisorio.customer.CustomerRegController;
import it.unipv.ingsfw.treninordovest.view.panels.users.CustomerRegistrationPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Frame per la registrazione dei clienti
 */
public class JCustomerRegFrame extends JFrame  {


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
        new CustomerRegController(customerRegistrationPanel,this,this::showSuccessMessage,this::hideFrame);
    }
    
    /**
     * Mostra il frame
     */
    public void showFrame() {
        setVisible(true);
    }
    public void hideFrame() {setVisible(false);}

    public void showSuccessMessage () {
        JOptionPane.showMessageDialog(this, "Registrazione Dipendente avvenuta con successo!");

    }




}