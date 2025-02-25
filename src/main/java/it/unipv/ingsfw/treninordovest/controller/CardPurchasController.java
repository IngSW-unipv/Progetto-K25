package it.unipv.ingsfw.treninordovest.controller;

import it.unipv.ingsfw.treninordovest.dao.implementations.utenti.TesseraDAOImpl;
import it.unipv.ingsfw.treninordovest.model.utenti.Cliente;
import it.unipv.ingsfw.treninordovest.model.utenti.Tessera;
import it.unipv.ingsfw.treninordovest.model.varie.GeneraID;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JCustomerMainFrame;
import it.unipv.ingsfw.treninordovest.view.panels.finance.CardPurchasePanel;

import javax.swing.*;
import java.sql.SQLException;
import java.time.LocalDate;

public class CardPurchasController {

    private CardPurchasePanel view;
    private JCustomerMainFrame customerRegFrame;
    private TesseraDAOImpl tDAO;
    private Tessera tessera;
    private LocalDate dataEmissione;
    private LocalDate dataScadenza;

    public CardPurchasController(CardPurchasePanel view, JCustomerMainFrame customerRegFrame) {
        this.view = view;
        this.customerRegFrame = customerRegFrame;
        initComponents();
    }

    private void initComponents() {
        view.getButtonAcquistaTessera().addActionListener(e -> {
            try {
                acquistaTessera();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

    }

    private void acquistaTessera() throws SQLException {
        try
        {
            String idCliente = view.getTextIDCliente().getText();
            Cliente clienteLoggato = (Cliente) SessionManager.getInstance().getCurrentUser();
            //Impostazioni delle date
            dataEmissione = LocalDate.now();
            dataScadenza = LocalDate.now().plusYears(5);
            //Generazione dell'ID
            GeneraID idGen = new GeneraID("TS");
            String idTessera = idGen.getID();

            tDAO = new TesseraDAOImpl();
            tessera = new Tessera(idTessera,dataEmissione,dataScadenza,idCliente);

            if (clienteLoggato != null) {
                tDAO.insert(tessera);
                JOptionPane.showMessageDialog(view, "Tessera acquistata", "Conferma",JOptionPane.INFORMATION_MESSAGE);
                view.setTextIDCliente("");

            }

            System.out.println(clienteLoggato);



        }catch (Exception e){
            e.printStackTrace();
        }









    }


}
