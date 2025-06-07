package it.unipv.ingsfw.treninordovest.view.frames.employee;

import it.unipv.ingsfw.treninordovest.controller.provvisorio.customer.TicketCheckController;
import it.unipv.ingsfw.treninordovest.controller.provvisorio.employee.EmployeeProfileController;
import it.unipv.ingsfw.treninordovest.view.panels.miscellanous.TravelDocCheckPanel;
import it.unipv.ingsfw.treninordovest.view.panels.users.EmployeeProfilePanel;

import javax.swing.*;
import java.awt.*;

public class JEmployeeMainFrame extends JFrame {

    private final JTabbedPane tabbedPane = new JTabbedPane();;
    private final TravelDocCheckPanel travelDocCheck = new TravelDocCheckPanel();
    private final EmployeeProfilePanel profilePanel = new EmployeeProfilePanel();

    private EmployeeProfileController employeeProfileController;
    private TicketCheckController ticketCheckController;

    public JEmployeeMainFrame() {
        setTitle("Treninordovest - Area Dipendenti");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 900);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        // Crea i pannelli per ogni funzionalità
        // Aggiungi le schede al tabbed pane
        tabbedPane.addTab("Controllo titoli", travelDocCheck);
        tabbedPane.addTab("Profilo", profilePanel);

        add(tabbedPane, BorderLayout.CENTER);
        employeeProfileController= new EmployeeProfileController(profilePanel,this);
        ticketCheckController = new TicketCheckController(this,travelDocCheck);


    }

}


