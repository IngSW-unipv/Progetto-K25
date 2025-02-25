package it.unipv.ingsfw.treninordovest.controller;

import it.unipv.ingsfw.treninordovest.dao.implementations.titoli.AbbonamentoDAOimpl;
import it.unipv.ingsfw.treninordovest.dao.implementations.titoli.PagamentoDAOImpl;
import it.unipv.ingsfw.treninordovest.dao.implementations.utenti.ClienteDAOImpl;
import it.unipv.ingsfw.treninordovest.dao.implementations.utenti.TesseraDAOImpl;
import it.unipv.ingsfw.treninordovest.dao.interfaces.ClienteDAO;
import it.unipv.ingsfw.treninordovest.model.titoli.Abbonamento;
import it.unipv.ingsfw.treninordovest.model.titoli.Pagamento;
import it.unipv.ingsfw.treninordovest.model.utenti.Cliente;
import it.unipv.ingsfw.treninordovest.model.varie.GeneraID;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JCustomerMainFrame;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JMainMenuFrame;
import it.unipv.ingsfw.treninordovest.view.panels.finance.SubscriptionPanel;
import it.unipv.ingsfw.treninordovest.view.panels.miscellanous.MainMenuPanel;

import javax.swing.*;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;

public class SubscriptionController {

    private SubscriptionPanel view;
    private JCustomerMainFrame frame;
    private String IdClienteLoggato;
    private Cliente clienteLoggato;
    private PagamentoDAOImpl pagamentoDAO;
    private AbbonamentoDAOimpl abbonamentoDAO;
    private TesseraDAOImpl tesseraDAO;

    public SubscriptionController(SubscriptionPanel view, JCustomerMainFrame frame) {
        this.view = view;
        this.frame = frame;
        initComponents();
    }

    private void initComponents() {
        view.getButtonAbbonati().addActionListener(e -> {
            try {
                acquistoAbbonamento();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    protected Pagamento creaPagamento(double totale) {
        //Dichiarazione classi
        PagamentoDAOImpl inserimentoPagamento = new PagamentoDAOImpl();
        Pagamento pagamento;

        //Generazione dell'ID del Pagamento
        GeneraID idGen = new GeneraID("PG");
        String IDPagamento = idGen.getID();

        //Acquisizione del tipo di pagamento
        String tipoPagamento = (String) view.getComboTipo().getSelectedItem();
        LocalDate dataPagamento = LocalDate.now();

        //Acquisizione del utente loggato
        clienteLoggato = (Cliente) SessionManager.getInstance().getCurrentUser();
        String idCliente = clienteLoggato.getId();

        pagamento = new Pagamento(IDPagamento,idCliente,totale,tipoPagamento,dataPagamento);

        return pagamento;

    }

    private void acquistoAbbonamento() throws SQLException {
        /*Dichiarazioni varianili*/

        try {

            String tipoAbbonamento = (String) view.getComboTipo().getSelectedItem();
            ClienteDAO clienteDAO = new ClienteDAOImpl();
            double prezzoAbbonamento;
            LocalDate scadenza;
            Pagamento pagamento;
            Abbonamento abbonamento;
            pagamentoDAO = new PagamentoDAOImpl();
            abbonamentoDAO = new AbbonamentoDAOimpl();
            clienteDAO = new ClienteDAOImpl();
            clienteLoggato = (Cliente) SessionManager.getInstance().getCurrentUser();
            LocalDate dataInizio = view.getTextDataInizio().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

            /*---------------------------------------------------------------------------*/
            //Verifica del tipo di abbonamento con relativi prezzi e date di scadenza

            /*APP*/

            if (tipoAbbonamento.equals("Settimanale")) {
                //Definizione prezzo e scadenza
                prezzoAbbonamento = 10;
                scadenza = dataInizio.plusWeeks(1);

                if(clienteLoggato.getBilancio()<=0) {
                    JOptionPane.showMessageDialog(view,"Credito Insufficiente" +clienteLoggato.getBilancio());
                    return;
                }

                clienteDAO.updateBilancio(clienteLoggato.getId(), clienteLoggato.getBilancio()-prezzoAbbonamento);

                //Creazione pagamento e abbonamento
                pagamento= creaPagamento(prezzoAbbonamento);
                abbonamento = creaAbbonamento(scadenza,pagamento.getIdPagamento(),prezzoAbbonamento,tipoAbbonamento);

                abbonamentoDAO.insert(abbonamento);
                pagamentoDAO.insert(pagamento);


            } else if (tipoAbbonamento.equals("Mensile")) {
                prezzoAbbonamento = 30;
                scadenza=dataInizio.plusMonths(1);

                //Verifica sufficienza di credito
                if(clienteLoggato.getBilancio()<=0) {
                    JOptionPane.showMessageDialog(view,"Credito Insufficiente" +clienteLoggato.getBilancio());
                    return;
                }

                pagamento= creaPagamento(prezzoAbbonamento);
                abbonamento = creaAbbonamento(scadenza,pagamento.getIdPagamento(),prezzoAbbonamento,tipoAbbonamento);

                pagamentoDAO.insert(pagamento);
                abbonamentoDAO.insert(abbonamento);



            } else if (tipoAbbonamento.equals("Annuale")) {
                prezzoAbbonamento = 300;
                scadenza=dataInizio.plusYears(1);

                //Verifica sufficienza di credito
                if(clienteLoggato.getBilancio()<=0) {
                    JOptionPane.showMessageDialog(view,"Credito Insufficiente" +clienteLoggato.getBilancio());
                    return;
                }

                pagamento= creaPagamento(prezzoAbbonamento);
                abbonamento = creaAbbonamento(scadenza,pagamento.getIdPagamento(),prezzoAbbonamento,tipoAbbonamento);

                pagamentoDAO.insert(pagamento);
                abbonamentoDAO.insert(abbonamento);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }


    }

    protected Abbonamento creaAbbonamento (LocalDate scadenza,String idPagamento,double prezzoAbbonamento,String tipoAbbonamento) throws SQLException {

        IdClienteLoggato = (String) SessionManager.getInstance().getCurrentUser().getId();

        Abbonamento abbonamento;

        GeneraID idGen = new GeneraID("AB");
        String idAbbonamento = idGen.getID();

        LocalDate dataEmissione = LocalDate.now();

        LocalDate dataInizio = view.getTextDataInizio().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        tesseraDAO = new TesseraDAOImpl();
        String idTessera = tesseraDAO.getIdTessera(IdClienteLoggato);

        System.out.println("Debug:  "+idTessera+" "+idAbbonamento +" "+dataEmissione +" "+dataInizio);

        abbonamento = new Abbonamento(idAbbonamento,idPagamento,dataEmissione,prezzoAbbonamento,tipoAbbonamento,scadenza,idTessera);

        return abbonamento;
    }




}
