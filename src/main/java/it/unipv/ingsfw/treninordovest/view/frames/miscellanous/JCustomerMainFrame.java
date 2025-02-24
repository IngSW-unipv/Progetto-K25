package it.unipv.ingsfw.treninordovest.view.frames.miscellanous;

import it.unipv.ingsfw.treninordovest.view.panels.finance.CardPurchasePanel;
import it.unipv.ingsfw.treninordovest.view.panels.finance.RefundPanel;
import it.unipv.ingsfw.treninordovest.view.panels.finance.SubscriptionPanel;
import it.unipv.ingsfw.treninordovest.view.panels.finance.TicketPurchasePanel;
import it.unipv.ingsfw.treninordovest.view.panels.miscellanous.TravelSearchPanel;

import javax.swing.*;
import java.awt.*;

public class JCustomerMainFrame extends JFrame {
    private final JTabbedPane tabbedPane = new JTabbedPane();;
    private final JPanel ticketPurchasePanel = new TicketPurchasePanel();
    private final JPanel subscriptionPanel = new SubscriptionPanel();
    private final JPanel cardPurchasePanel = new CardPurchasePanel();
    private final JPanel travelSearchPanel = new TravelSearchPanel();
    private final JPanel refundPanel = new RefundPanel();

    public JCustomerMainFrame() {
        setTitle("Treninordovest - Area Cliente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1120, 230);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {


        // Crea i pannelli per ogni funzionalità
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
