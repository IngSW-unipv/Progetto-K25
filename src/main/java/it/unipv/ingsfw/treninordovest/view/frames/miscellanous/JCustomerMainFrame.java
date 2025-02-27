package it.unipv.ingsfw.treninordovest.view.frames.miscellanous;

import it.unipv.ingsfw.treninordovest.controller.titoli.CardPurchasController;
import it.unipv.ingsfw.treninordovest.controller.titoli.TicketRefundController;
import it.unipv.ingsfw.treninordovest.controller.users.CustomerProfileController;
import it.unipv.ingsfw.treninordovest.controller.users.CustomerTicketController;
import it.unipv.ingsfw.treninordovest.controller.titoli.SubscriptionController;
import it.unipv.ingsfw.treninordovest.view.panels.finance.CardPurchasePanel;
import it.unipv.ingsfw.treninordovest.view.panels.finance.RefundPanel;
import it.unipv.ingsfw.treninordovest.view.panels.finance.SubscriptionPanel;
import it.unipv.ingsfw.treninordovest.view.panels.finance.TicketPurchasePanel;
import it.unipv.ingsfw.treninordovest.view.panels.miscellanous.TratteTablePanel;
import it.unipv.ingsfw.treninordovest.view.panels.users.CustomerProfilePanel;
import it.unipv.ingsfw.treninordovest.view.panels.miscellanous.TravelSearchPanel;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class JCustomerMainFrame extends JFrame {
    private final JTabbedPane tabbedPane = new JTabbedPane();;
    private final TicketPurchasePanel ticketPurchasePanel = new TicketPurchasePanel();
    private final SubscriptionPanel subscriptionPanel = new SubscriptionPanel();
    private final CardPurchasePanel cardPurchasePanel = new CardPurchasePanel();
    private final TravelSearchPanel travelSearchPanel = new TravelSearchPanel();
    private final RefundPanel refundPanel = new RefundPanel();
    private final CustomerProfilePanel profilePanel = new CustomerProfilePanel();
    private Color coloreSfondo = new Color(131,168,195);
    private TratteTablePanel tratteTablePanel = new TratteTablePanel();;
    private CustomerTicketController customerTicketController;
    private TicketRefundController ticketRefundController;

    private CardPurchasController cardPurchasController;
    private SubscriptionController subscriptionController;
    private CustomerProfileController customerProfileController;


    public JCustomerMainFrame() throws SQLException {
        setTitle("Treninordovest - Area Cliente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1120, 500);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() throws SQLException {


        // Crea i pannelli per ogni funzionalità
        // Aggiungi le schede al tabbed pane

        //Impostazione dei colori
        ticketPurchasePanel.setBackground(coloreSfondo);
        subscriptionPanel.setBackground(coloreSfondo);
        cardPurchasePanel.setBackground(coloreSfondo);
        travelSearchPanel.setBackground(coloreSfondo);
        refundPanel.setBackground(coloreSfondo);

        tratteTablePanel.aggiornaTratta();
        tabbedPane.addTab("Acquisto Biglietto", ticketPurchasePanel);
        tabbedPane.addTab("Abbonamento", subscriptionPanel);
        tabbedPane.addTab("Acquisto Tessera", cardPurchasePanel);
        //tabbedPane.addTab("Lista Tratte", tratteTablePanel);
        tabbedPane.addTab("Rimborso", refundPanel);
        tabbedPane.addTab("Profilo", profilePanel);

        ticketPurchasePanel.add(tratteTablePanel);

        //Aggiunta di tutte le schede nel frame
        add(tabbedPane, BorderLayout.CENTER);


        /*Aggiunta dei controller*/
        cardPurchasController = new CardPurchasController(cardPurchasePanel,this);
        subscriptionController = new SubscriptionController(subscriptionPanel,this);
        customerProfileController = new CustomerProfileController(profilePanel,this);
        customerTicketController = new CustomerTicketController(this,tratteTablePanel,ticketPurchasePanel);

        try {
            tratteTablePanel.setData(customerTicketController.getTratte());
        } catch (SQLException e) {
          System.out.println(e.getMessage());
          e.printStackTrace();
        }

        ticketRefundController = new TicketRefundController(this,refundPanel);



    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JCustomerMainFrame frame = null;
            try {
                frame = new JCustomerMainFrame();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            frame.setVisible(true);
        });
    }

}
