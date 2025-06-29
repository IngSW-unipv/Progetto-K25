package it.unipv.ingsfw.treninordovest.view.frames.utenti.clienti.menu.principale;

import it.unipv.ingsfw.treninordovest.controller.AcquistoController;
import it.unipv.ingsfw.treninordovest.view.frames.utenti.clienti.menu.principale.panels.*;
import it.unipv.ingsfw.treninordovest.view.frames.utenti.clienti.menu.principale.panels.titolitable.TitoliViaggioTablePanel;
import it.unipv.ingsfw.treninordovest.view.frames.utenti.clienti.menu.principale.panels.viaggitable.ViaggiTablePanel;

import javax.swing.*;
import java.awt.*;

public class JCustomerMainFrame extends JFrame {
    private final JTabbedPane tabbedPane = new JTabbedPane();
    private final TicketPurchasePanel ticketPurchasePanel = new TicketPurchasePanel();
    private final SubscriptionPanel subscriptionPanel = new SubscriptionPanel();
    private final CardPurchasePanel cardPurchasePanel = new CardPurchasePanel();
    private final RefundPanel refundPanel = new RefundPanel();
    private final CustomerProfilePanel profilePanel = new CustomerProfilePanel();
    private final ViaggiTablePanel tratteTablePanel = new ViaggiTablePanel();
    private final Color coloreSfondo = new Color(131, 168, 195);

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
        refundPanel.setBackground(coloreSfondo);

        tratteTablePanel.aggiornaTratta();
        tabbedPane.addTab("Acquisto Biglietto", ticketPurchasePanel);
        tabbedPane.addTab("Abbonamento", subscriptionPanel);
        tabbedPane.addTab("Acquisto Tessera", cardPurchasePanel);
        tabbedPane.addTab("Rimborso", refundPanel);
        tabbedPane.addTab("Profilo", profilePanel);

        ticketPurchasePanel.add(tratteTablePanel);

        //Test

        AcquistoBigliettoPanel acquistoBigliettoPanel = new AcquistoBigliettoPanel();
        acquistoBigliettoPanel.setBackground(coloreSfondo);
        tabbedPane.addTab("Acquisto", acquistoBigliettoPanel);

        TitoliViaggioTablePanel titoliViaggioTablePanel = new TitoliViaggioTablePanel();
        titoliViaggioTablePanel.setBackground(coloreSfondo);
        tabbedPane.addTab("Titoli", titoliViaggioTablePanel);


        // Aggiunta di tutte le schede nel frame
        add(tabbedPane, BorderLayout.CENTER);

        new AcquistoController(cardPurchasePanel,this);
        new AcquistoController(subscriptionPanel,this);
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

    public ViaggiTablePanel getTratteTablePanel() {
        return tratteTablePanel;
    }

    public void hideFrame() {
        setVisible(false);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            JCustomerMainFrame frame = new JCustomerMainFrame();
            frame.setVisible(true);
        });


    }

}