package it.unipv.ingsfw.treninordovest.controller.customer;

import it.unipv.ingsfw.treninordovest.controller.misc.IController;
import it.unipv.ingsfw.treninordovest.dao.implementations.utenti.TesseraDAOImpl;
import it.unipv.ingsfw.treninordovest.model.utenti.Cliente;
import it.unipv.ingsfw.treninordovest.model.utenti.Tessera;
import it.unipv.ingsfw.treninordovest.model.varie.GeneraID;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JCustomerMainFrame;
import it.unipv.ingsfw.treninordovest.view.panels.finance.CardPurchasePanel;

import javax.swing.*;
import java.time.LocalDate;

public class CardPurchaseController implements IController {

    private CardPurchasePanel view;
    private JCustomerMainFrame customerRegFrame;
    private TesseraDAOImpl tDAO;
    private Tessera tessera;
    private LocalDate dataEmissione;
    private LocalDate dataScadenza;

    public CardPurchaseController(CardPurchasePanel view, JCustomerMainFrame customerRegFrame) {
        this.view = view;
        this.customerRegFrame = customerRegFrame;
        init();
    }

    @Override
    public void init() {
        initComponents();
    }

    private void initComponents() {
        view.getButtonAcquistaTessera().addActionListener(e -> {acquistaTessera();});
    }

    private void acquistaTessera()  {
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

            if (tDAO.exists(clienteLoggato.getId())){
                JOptionPane.showMessageDialog(view, "Hai già una tessera", "Errore", JOptionPane.ERROR_MESSAGE);
            } else if (!tDAO.exists(idTessera)){
                if (clienteLoggato != null && clienteLoggato.getId().equals(idCliente)) {
                    tDAO.insert(tessera);
                    JOptionPane.showMessageDialog(view, "Tessera acquistata", "Conferma",JOptionPane.INFORMATION_MESSAGE);
                    view.setTextIDCliente("");
                } else {
                    JOptionPane.showMessageDialog(view, "ID non valido riprovare", "Errore", JOptionPane.ERROR_MESSAGE);
                    view.setTextIDCliente("");
                }

            }

            System.out.println(clienteLoggato);



        }catch (Exception e){
            e.printStackTrace();
        }



    }


}
