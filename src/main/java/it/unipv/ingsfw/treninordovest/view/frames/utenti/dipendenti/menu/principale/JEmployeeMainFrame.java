package it.unipv.ingsfw.treninordovest.view.frames.utenti.dipendenti.menu.principale;


import it.unipv.ingsfw.treninordovest.view.frames.utenti.dipendenti.menu.principale.panels.TravelDocCheckPanel;
import it.unipv.ingsfw.treninordovest.view.frames.utenti.dipendenti.menu.principale.panels.EmployeeProfilePanel;

import javax.swing.*;
import java.awt.*;

public class JEmployeeMainFrame extends JFrame {

    private final JTabbedPane tabbedPane = new JTabbedPane();;
    private final TravelDocCheckPanel travelDocCheck = new TravelDocCheckPanel();
    private final EmployeeProfilePanel profilePanel = new EmployeeProfilePanel();



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



    }

}


