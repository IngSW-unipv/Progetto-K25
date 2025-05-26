package it.unipv.ingsfw.treninordovest.controller.customer;

import it.unipv.ingsfw.treninordovest.facade.implementations.gestioneutenti.CustomerManagementFacade;
import it.unipv.ingsfw.treninordovest.view.frames.customer.JCustomerMainFrame;
import it.unipv.ingsfw.treninordovest.view.panels.finance.CardPurchasePanel;

import javax.swing.*;

public class CardPurchaseController  {

    private CardPurchasePanel view;
    private JCustomerMainFrame customerRegFrame;
    private CustomerManagementFacade facade;

    public CardPurchaseController(CardPurchasePanel view, JCustomerMainFrame customerRegFrame) {
        this.view = view;
        this.customerRegFrame = customerRegFrame;
        init();
    }



    private void init() {
        view.getButtonAcquistaTessera().addActionListener(e -> {acquistaTessera();});
    }

    private void acquistaTessera()  {
        try
        {
            facade.acquistaTessera();
            JOptionPane.showMessageDialog(view,"Tessera acquistata con successo");



        }catch (Exception e){
            throw new RuntimeException("Errore durante l'acquisto",e);
        }



    }


}
