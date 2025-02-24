package it.unipv.ingsfw.treninordovest.view.frames.registration;

import it.unipv.ingsfw.treninordovest.view.panels.users.CustomerRegistrationPanel;

import javax.swing.*;
import java.awt.*;

public class JCustomerRegistrationFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private CustomerRegistrationPanel registrationPanel;

    public JCustomerRegistrationFrame() {
        setTitle("Treninordovest - Registrazione Clienti");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1220, 450);
        setLocationRelativeTo(null);
        //this.getContentPane().setBackground(Color.BLUE);

        inizializzaComponenti();

    }

    private void inizializzaComponenti() {
        registrationPanel = new CustomerRegistrationPanel();
        getContentPane().add(registrationPanel, BorderLayout.CENTER);
    }




}
