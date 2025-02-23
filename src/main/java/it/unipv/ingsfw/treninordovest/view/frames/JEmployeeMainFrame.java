package it.unipv.ingsfw.treninordovest.view.frames;

import it.unipv.ingsfw.treninordovest.view.panels.*;

import javax.swing.*;
import java.awt.*;

public class JEmployeeMainFrame extends JFrame {

    private final JTabbedPane tabbedPane = new JTabbedPane();;
    private final JPanel travelDocCheck = new TravelDocCheckPanel();
    private final JPanel refundPanel = new RefundPanel();
    private final JPanel profilePanel = new ProfilePanel();

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
        tabbedPane.addTab("Rimborso", refundPanel);
        tabbedPane.addTab("Profilo", profilePanel);

        add(tabbedPane, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JEmployeeMainFrame frame = new JEmployeeMainFrame();
            frame.setVisible(true);
        });
    }

}


