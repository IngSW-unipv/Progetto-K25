package it.unipv.ingsfw.treninordovest.view.frames.registration;

import it.unipv.ingsfw.treninordovest.view.panels.users.CustomerRegistrationPanel;

import javax.swing.*;
import java.awt.*;

public class JCustomerRegistrationFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private CustomerRegistrationPanel registrationPanel;
    private Color coloreSfondo = new Color(131,168,195);

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
        registrationPanel.setBackground(coloreSfondo);
        getContentPane().add(registrationPanel, BorderLayout.CENTER);
    }




}
