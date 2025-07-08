package it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente;

// Imports have been simplified
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.panels.*;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.panels.pagamenti.CreditCardPanel;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.panels.titolitable.TitoliViaggioTablePanel;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.panels.viaggitable.ViaggiTablePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

// 1. Changed to extend JPanel
public class CustomerMainPanel extends JPanel {
    private final JTabbedPane tabbedPane = new JTabbedPane();
    private final TicketPurchasePanel ticketPurchasePanel;
    private final SubscriptionPanel subscriptionPanel = new SubscriptionPanel();
    private final CardPurchasePanel cardPurchasePanel = new CardPurchasePanel();
    private final RefundPanel refundPanel = new RefundPanel();
    private final CustomerProfilePanel profilePanel = new CustomerProfilePanel();
    private final ViaggiTablePanel tratteTablePanel = new ViaggiTablePanel();
    private final Color coloreSfondo = new Color(131, 168, 195);
    private final TitoliViaggioTablePanel titoliViaggioTablePanel=new TitoliViaggioTablePanel();

    public CustomerMainPanel() {
        // 2. All window-specific calls are removed from the constructor.
        // The panel's layout is now set directly.
        this.setLayout(new BorderLayout());

        // We pass 'this' to the child panels so they can call back to the parent
        // to switch tabs.
        this.ticketPurchasePanel = new TicketPurchasePanel();

        initComponents();
    }

    private void initComponents() {
        ticketPurchasePanel.setBackground(coloreSfondo);
        subscriptionPanel.setBackground(coloreSfondo);
        cardPurchasePanel.setBackground(coloreSfondo);
        refundPanel.setBackground(coloreSfondo);

        tratteTablePanel.aggiornaTratta();
        tabbedPane.addTab("Acquisto Biglietto", ticketPurchasePanel);
        tabbedPane.addTab("Abbonamento", subscriptionPanel);
        tabbedPane.addTab("Acquisto Tessera", cardPurchasePanel);
        tabbedPane.addTab("Rimborso", refundPanel);
        tabbedPane.addTab("Profilo", profilePanel);

        ticketPurchasePanel.add(tratteTablePanel);

        // Test panels
//        AcquistoBigliettoPanel acquistoBigliettoPanel = new AcquistoBigliettoPanel();
//        acquistoBigliettoPanel.setBackground(coloreSfondo);
//        tabbedPane.addTab("Acquisto", acquistoBigliettoPanel);
        titoliViaggioTablePanel.setBackground(coloreSfondo);
        tabbedPane.addTab("Titoli", titoliViaggioTablePanel);

        // Add the tabbed pane to this panel
        add(tabbedPane, BorderLayout.CENTER);

        // 3. The view DOES NOT create its own controllers. This is done externally.
    }

    /**
     * Switches the visible tab to the payment panel.
     * This method can be called by child panels.
     */

    // Getter methods remain the same, so controllers can access the panels
    public TicketPurchasePanel getTicketPurchasePanel() { return ticketPurchasePanel; }
    public SubscriptionPanel getSubscriptionPanel() { return subscriptionPanel; }
    public CardPurchasePanel getCardPurchasePanel() { return cardPurchasePanel; }
    public RefundPanel getRefundPanel() {
        return refundPanel;
    }

    public TitoliViaggioTablePanel getTitoliViaggioTablePanel() {
        return titoliViaggioTablePanel;
    }

    public CustomerProfilePanel getProfilePanel() {
        return profilePanel;
    }

    public void addActionListener(ActionListener actionListener) {
        subscriptionPanel.getButtonAbbonati().addActionListener(actionListener);
        ticketPurchasePanel.getButtonAcquista().addActionListener(actionListener);
        profilePanel.getBtnEsci().addActionListener(actionListener);
    }


    public ViaggiTablePanel getViaggiTabelPanel() {
        return tratteTablePanel;
    }
}