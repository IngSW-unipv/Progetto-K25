package it.unipv.ingsfw.treninordovest.controller.customer;


import it.unipv.ingsfw.treninordovest.dao.implementations.utenti.TesseraDAOImpl;
import it.unipv.ingsfw.treninordovest.facade.implementations.CustomerManagementFacade;
import it.unipv.ingsfw.treninordovest.model.utenti.Tessera;
import it.unipv.ingsfw.treninordovest.view.frames.customer.JCustomerMainFrame;
import it.unipv.ingsfw.treninordovest.view.panels.finance.CardPurchasePanel;

import javax.swing.*;
import java.time.LocalDate;

public class CardPurchaseController  {

    private CardPurchasePanel view;
    private JCustomerMainFrame customerRegFrame;
    private TesseraDAOImpl tDAO;
    private Tessera tessera;
    private LocalDate dataEmissione;
    private LocalDate dataScadenza;
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
