package it.unipv.ingsfw.treninordovest.view.frames.registration;

import it.unipv.ingsfw.treninordovest.controller.users.CustomerRegController;
import it.unipv.ingsfw.treninordovest.view.panels.users.CustomerRegistrationPanel;

import javax.swing.*;
import java.awt.*;

public class JCustomerRegFrame extends JFrame {
    private static final long serialVersionUID = 1L;
   // private Color coloreSfondo;
    private CustomerRegistrationPanel customerRegistrationPanel;
    private CustomerRegController customerRegController;


    public JCustomerRegFrame() {
        setTitle("Treninordovest - Registrazione cliente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1220, 450);
        setLocationRelativeTo(null);
        //coloreSfondo = new Color(131,168,195);
        //setBackground(coloreSfondo);
        inizializzaComponenti();
    }

    private void inizializzaComponenti() {
        customerRegistrationPanel = new CustomerRegistrationPanel();
        add(customerRegistrationPanel, BorderLayout.CENTER);
        customerRegController = new CustomerRegController(customerRegistrationPanel,this);

    }

}
