package it.unipv.ingsfw.treninordovest.controller.users;

import it.unipv.ingsfw.treninordovest.dao.implementations.ferrovia.TrattaDAOImpl;
import it.unipv.ingsfw.treninordovest.dao.implementations.titoli.BigliettoDAOImpl;
import it.unipv.ingsfw.treninordovest.dao.implementations.utenti.ClienteDAOImpl;
import it.unipv.ingsfw.treninordovest.dao.interfaces.BigliettoDAO;
import it.unipv.ingsfw.treninordovest.model.ferrovia.Tratta;
import it.unipv.ingsfw.treninordovest.model.ferrovia.Viaggio;
import it.unipv.ingsfw.treninordovest.model.titoli.Biglietto;
import it.unipv.ingsfw.treninordovest.model.titoli.Pagamento;
import it.unipv.ingsfw.treninordovest.model.utenti.Cliente;
import it.unipv.ingsfw.treninordovest.model.varie.GeneraID;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JCustomerMainFrame;
import it.unipv.ingsfw.treninordovest.view.panels.finance.TicketPurchasePanel;
import it.unipv.ingsfw.treninordovest.view.panels.miscellanous.TratteTablePanel;

import javax.persistence.Id;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

public class CustomerTicketController {

    private TratteTablePanel tratteTablePanel;
    private JCustomerMainFrame customerMainFrame;
    private TicketPurchasePanel ticketPurchasePanel;
    private TrattaDAOImpl trattaDAO;
    private BigliettoDAOImpl bigliettoDAO;
    private GeneraID generaID;
    private Cliente clienteLoggato;

    public CustomerTicketController(JCustomerMainFrame frame, TratteTablePanel tratteTablePanel,TicketPurchasePanel ticketPurchasePanel) {
        this.customerMainFrame = frame;
        this.tratteTablePanel = tratteTablePanel;
        this.ticketPurchasePanel = ticketPurchasePanel;
        initController();

    }

    private void initController() {

        ticketPurchasePanel.getButtonAcquista().addActionListener(e -> acquistoBiglietto());

    }

    public List<Tratta> getTratte() throws SQLException {
        trattaDAO = new TrattaDAOImpl();
        List<Tratta> tratte;
        try {
           tratte = trattaDAO.getAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return tratte;
    }

    private void acquistoBiglietto (){
        bigliettoDAO = new BigliettoDAOImpl();


    }

    private Biglietto creaBiglietto(String idPagamento){

        Biglietto bigliettoCreato;
        generaID = new GeneraID("BG");
        double prezzoBiglietto = 2;
        Pagamento pagamento = creaPagamento(prezzoBiglietto);
        LocalDate dataEmissioneValidazione = LocalDate.now();
        LocalDate dataRitorno = ticketPurchasePanel.getDataRitorno().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Boolean validazione =true;
        Boolean checkRitorno = ticketPurchasePanel.getCheckBoxRitorno().isSelected();


        bigliettoCreato = new Biglietto(generaID.getID(),idPagamento,dataEmissioneValidazione,prezzoBiglietto,checkRitorno,validazione,dataRitorno,dataEmissioneValidazione)


    return bigliettoCreato;
    }

    private Viaggio creaViaggio (){

        return null;
    }

    protected Pagamento creaPagamento(double totale) {
        //Dichiarazione classi
        Pagamento pagamento;
        String tipoPagamento;
        LocalDate dataPagamento;
        //Generazione dell'ID del Pagamento
        GeneraID idGen = new GeneraID("PG");
        String IDPagamento = idGen.getID();

        //Acquisizione del tipo di pagamento
        tipoPagamento = "Digitale";
        dataPagamento = LocalDate.now();

        //Acquisizione del utente loggato
        clienteLoggato = (Cliente) SessionManager.getInstance().getCurrentUser();
        String idCliente = clienteLoggato.getId();

        pagamento = new Pagamento(IDPagamento,idCliente,totale,tipoPagamento,dataPagamento);

        return pagamento;

    }


}
