package it.unipv.ingsfw.treninordovest.view.frames.customer;

import it.unipv.ingsfw.treninordovest.view.panels.finance.*;
import it.unipv.ingsfw.treninordovest.view.panels.miscellanous.*;
import it.unipv.ingsfw.treninordovest.view.panels.users.*;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class JCustomerMainFrame extends JFrame implements Observer {
    private final JTabbedPane tabbedPane = new JTabbedPane();
    private final TicketPurchasePanel ticketPurchasePanel = new TicketPurchasePanel();
    private final SubscriptionPanel subscriptionPanel = new SubscriptionPanel();
    private final CardPurchasePanel cardPurchasePanel = new CardPurchasePanel();
    private final TravelSearchPanel travelSearchPanel = new TravelSearchPanel();
    private final RefundPanel refundPanel = new RefundPanel();
    private final CustomerProfilePanel profilePanel = new CustomerProfilePanel();
    private final TratteTablePanel tratteTablePanel = new TratteTablePanel();
    private Color coloreSfondo = new Color(131, 168, 195);

    public JCustomerMainFrame() {
        setTitle("Treninordovest - Area Cliente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1120, 500);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        // Impostazione dei colori
        ticketPurchasePanel.setBackground(coloreSfondo);
        subscriptionPanel.setBackground(coloreSfondo);
        cardPurchasePanel.setBackground(coloreSfondo);
        travelSearchPanel.setBackground(coloreSfondo);
        refundPanel.setBackground(coloreSfondo);

        tratteTablePanel.aggiornaTratta();
        tabbedPane.addTab("Acquisto Biglietto", ticketPurchasePanel);
        tabbedPane.addTab("Abbonamento", subscriptionPanel);
        tabbedPane.addTab("Acquisto Tessera", cardPurchasePanel);
        tabbedPane.addTab("Rimborso", refundPanel);
        tabbedPane.addTab("Profilo", profilePanel);

        ticketPurchasePanel.add(tratteTablePanel);

        // Aggiunta di tutte le schede nel frame
        add(tabbedPane, BorderLayout.CENTER);
    }

    // Getter per accedere ai pannelli
    public CardPurchasePanel getCardPurchasePanel() {
        return cardPurchasePanel;
    }

    public SubscriptionPanel getSubscriptionPanel() {
        return subscriptionPanel;
    }

    public TicketPurchasePanel getTicketPurchasePanel() {
        return ticketPurchasePanel;
    }

    public RefundPanel getRefundPanel() {
        return refundPanel;
    }

    public CustomerProfilePanel getProfilePanel() {
        return profilePanel;
    }

    public TratteTablePanel getTratteTablePanel() {
        return tratteTablePanel;
    }

    @Override
    public void update(Observable o, Object arg) {


    }
}