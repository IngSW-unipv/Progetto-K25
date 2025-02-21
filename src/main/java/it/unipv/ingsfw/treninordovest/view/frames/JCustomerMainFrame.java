package it.unipv.ingsfw.treninordovest.view.frames;

import it.unipv.ingsfw.treninordovest.view.panels.*;

import javax.swing.*;
import java.awt.*;

public class JCustomerMainFrame extends JFrame {
    private JTabbedPane tabbedPane;

    public JCustomerMainFrame() {
        setTitle("Treninordovest - Area Cliente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        tabbedPane = new JTabbedPane();

        // Crea i pannelli per ogni funzionalità
        JPanel ticketPurchasePanel = new TicketPurchasePanel();
        JPanel subscriptionPanel = new SubscriptionPanel();
        JPanel cardPurchasePanel = new CardPurchasePanel();
        JPanel travelSearchPanel = new TravelSearchPanel();
        JPanel refundPanel = new RefundPanel();

        // Aggiungi le schede al tabbed pane
        tabbedPane.addTab("Acquisto Biglietto", ticketPurchasePanel);
        tabbedPane.addTab("Abbonamento", subscriptionPanel);
        tabbedPane.addTab("Acquisto Tessera", cardPurchasePanel);
        tabbedPane.addTab("Ricerca Viaggio", travelSearchPanel);
        tabbedPane.addTab("Rimborso", refundPanel);

        add(tabbedPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JCustomerMainFrame frame = new JCustomerMainFrame();
            frame.setVisible(true);
        });
    }

}
