package it.unipv.ingsfw.treninordovest.view.frames.registration;

import it.unipv.ingsfw.treninordovest.view.panels.users.CustomerRegistrationPanel;
import it.unipv.ingsfw.treninordovest.view.panels.users.EmployeeRegistrationPanel;

import javax.swing.*;
import java.awt.*;

public class JEmployeeRegistrationFrame extends JFrame {

    private EmployeeRegistrationPanel registrationPanel;
    private Color coloreSfondo = new Color(131,168,195);


    public JEmployeeRegistrationFrame() {
        setTitle("Treninordovest - Registrazione Dipendenti");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1220, 450);
        setLocationRelativeTo(null);
        //this.getContentPane().setBackground(Color.BLUE);

        inizializzaComponenti();
    }

    private void inizializzaComponenti() {
        registrationPanel = new EmployeeRegistrationPanel();
        registrationPanel.setBackground(coloreSfondo);
        getContentPane().add(registrationPanel, BorderLayout.CENTER);
    }


}
