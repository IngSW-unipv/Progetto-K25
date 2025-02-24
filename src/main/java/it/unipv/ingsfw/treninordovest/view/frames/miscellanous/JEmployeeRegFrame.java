package it.unipv.ingsfw.treninordovest.view.frames.miscellanous;

import it.unipv.ingsfw.treninordovest.controller.CustomerRegController;
import it.unipv.ingsfw.treninordovest.controller.EmployeeRegController;
import it.unipv.ingsfw.treninordovest.view.panels.users.CustomerRegistrationPanel;
import it.unipv.ingsfw.treninordovest.view.panels.users.EmployeeRegistrationPanel;

import javax.swing.*;
import java.awt.*;

public class JEmployeeRegFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private Color coloreSfondo;
    private EmployeeRegistrationPanel employeeRegistrationPanel;
    private EmployeeRegController employeeRegController;


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
       employeeRegController = new EmployeeRegController(employeeRegistrationPanel,this);


    }


}
