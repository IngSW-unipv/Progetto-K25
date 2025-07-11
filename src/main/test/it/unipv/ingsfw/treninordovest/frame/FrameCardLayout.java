package it.unipv.ingsfw.treninordovest.frame;


import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.panels.*;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.panels.pagamenti.CreditCardPanel;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.panels.titolitable.TitoliViaggioTablePanel;


import javax.smartcardio.Card;
import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FrameCardLayout extends JFrame {

    private final JTabbedPane tabbedPane = new JTabbedPane();
//    private final TicketPurchasePanel ticketPurchasePanel = new TicketPurchasePanel();
//    private final SubscriptionPanel subscriptionPanel = new SubscriptionPanel();
//    private final CardPurchasePanel cardPurchasePanel = new CardPurchasePanel();
//    private final RefundPanel refundPanel = new RefundPanel();
//    private final CustomerProfilePanel profilePanel = new CustomerProfilePanel();
    private final TitoliViaggioTablePanel  tratteTablePanel = new TitoliViaggioTablePanel();
    private final Color coloreSfondo = new Color(131, 168, 195);

    private final CreditCardPanel creditCardPanel = new CreditCardPanel();


    public FrameCardLayout() {
        setTitle("Treninordovest - Area Cliente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1120, 500);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        // Impostazione dei colori
//        ticketPurchasePanel.setBackground(coloreSfondo);
//        subscriptionPanel.setBackground(coloreSfondo);
//        cardPurchasePanel.setBackground(coloreSfondo);
//        refundPanel.setBackground(coloreSfondo);
//
//        tratteTablePanel.aggiornaTratta();
       // tabbedPane.addTab("Acquisto Biglietto", ticketPurchasePanel);
        //tabbedPane.addTab("Abbonamento", subscriptionPanel);
       // tabbedPane.addTab("Acquisto Tessera", cardPurchasePanel);
       // tabbedPane.addTab("Rimborso", refundPanel);
       // tabbedPane.addTab("Profilo", profilePanel);

//        ticketPurchasePanel.add(tratteTablePanel);

        //Test

        AcquistoBigliettoPanel acquistoBigliettoPanel = new AcquistoBigliettoPanel();
        acquistoBigliettoPanel.setBackground(coloreSfondo);
        //tabbedPane.addTab("Acquisto", acquistoBigliettoPanel);

        TitoliViaggioTablePanel titoliViaggioTablePanel = new TitoliViaggioTablePanel();
        titoliViaggioTablePanel.setBackground(coloreSfondo);
        tabbedPane.addTab("Titoli", titoliViaggioTablePanel);

//        tabbedPane.addTab("Pagamento Carta", creditCardPanel);


        // Aggiunta di tutte le schede nel frame
        add(tabbedPane, BorderLayout.CENTER);


        TabListenerTest();

    }


    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            FrameCardLayout frameCardLayout = new FrameCardLayout();
           // GestioneUtenzaController gestioneUtenzaController = new GestioneUtenzaController();
            frameCardLayout.setVisible(true);
            frameCardLayout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        });


    }

    public void showPaymentTab() {
        tabbedPane.setSelectedComponent(creditCardPanel);
    }

    private void TabListenerTest() {

        tratteTablePanel.getBtnShowAbbonamenti().addActionListener( e ->{

            if (tratteTablePanel.getBtnShowAbbonamenti().getActionCommand().equalsIgnoreCase("biglietti") ) {
                System.out.println("abbonamenti");
              tratteTablePanel.showAbbonamentiCard();
            }

        });


        tratteTablePanel.getBtnShowBiglietti().addActionListener( e ->{

            if (tratteTablePanel.getBtnShowBiglietti().getActionCommand().equalsIgnoreCase("abbonamenti") ) {

                tratteTablePanel.showBigliettiCard();
            }

        });



    }

}
