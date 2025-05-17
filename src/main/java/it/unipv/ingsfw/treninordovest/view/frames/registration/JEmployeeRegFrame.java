package it.unipv.ingsfw.treninordovest.view.frames.registration;

import it.unipv.ingsfw.treninordovest.view.panels.users.EmployeeRegistrationPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Frame per la registrazione dei dipendenti
 */
public class JEmployeeRegFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private Color coloreSfondo;
    private EmployeeRegistrationPanel employeeRegistrationPanel;

    /**
     * Costruttore predefinito che crea un nuovo pannello di registrazione
     */
    public JEmployeeRegFrame() {
        setTitle("Treninordovest - Registrazione dipendente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1220, 450);
        setLocationRelativeTo(null);
        coloreSfondo = new Color(131,168,195);
        setBackground(coloreSfondo);
        inizializzaComponenti();
    }

    private void inizializzaComponenti() {
        employeeRegistrationPanel = new EmployeeRegistrationPanel();
        add(employeeRegistrationPanel, BorderLayout.CENTER);
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
     * @return Il pannello di registrazione dipendente
     */
    public EmployeeRegistrationPanel getEmployeeRegistrationPanel() {
        return employeeRegistrationPanel;
    }
}