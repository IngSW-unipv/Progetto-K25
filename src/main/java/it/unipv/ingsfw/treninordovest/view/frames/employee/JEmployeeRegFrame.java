package it.unipv.ingsfw.treninordovest.view.frames.employee;

//import it.unipv.ingsfw.treninordovest.controller.provvisorio.employee.EmployeeRegController;
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


        this.employeeRegistrationPanel = new EmployeeRegistrationPanel();
        add(employeeRegistrationPanel, BorderLayout.CENTER);

        new EmployeeRegController(employeeRegistrationPanel,this,this::showSuccessMessage,this::hideFrame);
    }

    /**
     * Vista dei frame
     */
    public void showFrame() {
        setVisible(true);
    }
    public void hideFrame() {
        setVisible(false);
    }

    public void showSuccessMessage () {
        JOptionPane.showMessageDialog(this, "Registrazione Dipendente avvenuta con successo!");

    }



}