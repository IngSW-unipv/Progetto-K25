package it.unipv.ingsfw.treninordovest.controller.users;

import it.unipv.ingsfw.treninordovest.dao.implementations.ferrovia.TrattaDAOImpl;
import it.unipv.ingsfw.treninordovest.dao.implementations.ferrovia.TrattaFermataDAOImpl;
import it.unipv.ingsfw.treninordovest.dao.implementations.ferrovia.ViaggioDAOimpl;
import it.unipv.ingsfw.treninordovest.dao.implementations.titoli.BigliettoDAOImpl;
import it.unipv.ingsfw.treninordovest.dao.implementations.titoli.PagamentoDAOImpl;
import it.unipv.ingsfw.treninordovest.dao.implementations.utenti.ClienteDAOImpl;
import it.unipv.ingsfw.treninordovest.dao.interfaces.BigliettoDAO;
import it.unipv.ingsfw.treninordovest.dao.interfaces.TrattaFermataDAO;
import it.unipv.ingsfw.treninordovest.model.ferrovia.Tratta;
import it.unipv.ingsfw.treninordovest.model.ferrovia.TrattaFermata;
import it.unipv.ingsfw.treninordovest.model.ferrovia.Viaggio;
import it.unipv.ingsfw.treninordovest.model.titoli.Biglietto;
import it.unipv.ingsfw.treninordovest.model.titoli.Pagamento;
import it.unipv.ingsfw.treninordovest.model.utenti.Cliente;
import it.unipv.ingsfw.treninordovest.model.varie.GeneraID;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JCustomerMainFrame;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JMainMenuFrame;
import it.unipv.ingsfw.treninordovest.view.panels.finance.TicketPurchasePanel;
import it.unipv.ingsfw.treninordovest.view.panels.miscellanous.TratteTablePanel;

import javax.persistence.Id;
import javax.swing.*;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
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

        ticketPurchasePanel.getButtonAcquista().addActionListener(e -> {
            try {
                acquistoBiglietto();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

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

    protected void acquistoBiglietto () throws SQLException {

        PagamentoDAOImpl pagamentoDAO = new PagamentoDAOImpl();
        BigliettoDAOImpl bigliettoDAO = new BigliettoDAOImpl();
        ViaggioDAOimpl viaggioDAO = new ViaggioDAOimpl();
        TrattaFermataDAOImpl trattaDAO = new TrattaFermataDAOImpl();

        Pagamento pagamento = creaPagamento(2);
        Biglietto biglietto = creaBiglietto(pagamento.getIdPagamento());


        String idTratta = ticketPurchasePanel.getTextFieldTratta().getText();
        TrattaFermata stazionePartenza ;
        TrattaFermata stazioneArrivo ;

        stazionePartenza=trattaDAO.getPartenza(idTratta);
        stazioneArrivo=trattaDAO.getArrivo(idTratta);

        String idPart= stazionePartenza.getIdFermata();
        String idArr = stazioneArrivo.getIdFermata();
        String idBiglietto = biglietto.getId();

        System.out.println("Debug:"+"IDBIGLIETTO :  "+idBiglietto+"  IDARR: "+idArr+" IDPART: "+idPart+"    IDTRATTA:"+idTratta);

        Viaggio viaggio = creaViaggio(idBiglietto,idPart,idArr,idTratta);

        double totaleScalato= clienteLoggato.getBilancio()-pagamento.getTotale();

        if (clienteLoggato.getBilancio()<=0){
            JOptionPane.showMessageDialog(ticketPurchasePanel,"Credito Insufficiente" ,"Errore",JOptionPane.ERROR_MESSAGE);
            return;
        }
        else  JOptionPane.showMessageDialog(ticketPurchasePanel,"Biglietto acquistato:   " +totaleScalato+ "    Codice Titolo:  "+ idBiglietto);



        ClienteDAOImpl clienteDAO = new ClienteDAOImpl();
        clienteDAO.updateBilancio(clienteLoggato.getId(),totaleScalato);
        clienteLoggato.setBilancio(totaleScalato);

        //Inserimento nel DB
        pagamentoDAO.insert(pagamento);
        bigliettoDAO.insert(biglietto);
        viaggioDAO.insert(viaggio);

    }

    private Biglietto creaBiglietto(String idPagamento){

        Biglietto bigliettoCreato;
        generaID = new GeneraID("BG");
        double prezzoBiglietto = 2;
        //Pagamento pagamento = creaPagamento(prezzoBiglietto);
        LocalDate dataEmissioneValidazione = LocalDate.now();
        LocalDate dataRitorno;
        Boolean validazione =true;
        Boolean checkRitorno = ticketPurchasePanel.getCheckBoxRitorno().isSelected();
        Boolean ritorno=false;

        if (checkRitorno){
            dataRitorno= ticketPurchasePanel.getDataRitorno().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }else {
            dataRitorno=null;
        }

        bigliettoCreato = new Biglietto(generaID.getID(),idPagamento,dataEmissioneValidazione,prezzoBiglietto,checkRitorno,validazione,dataRitorno,dataEmissioneValidazione);

    return bigliettoCreato;
    }

    private Viaggio creaViaggio (String idBiglietto,String idPartenza,String idArrivo,String idTratta) throws SQLException {
        generaID = new GeneraID("VG");
        LocalDate dataViaggio = LocalDate.now();
        Viaggio viaggioCreato;
        LocalTime oraPartenza;
        LocalTime oraArrivo;

        TrattaFermataDAOImpl trattaFermataDAO = new TrattaFermataDAOImpl();

        TrattaFermata trattaPartenzaViaggio = trattaFermataDAO.get(idTratta,idPartenza);
        TrattaFermata trattaArrivoViaggio = trattaFermataDAO.get(idTratta,idArrivo);

        oraArrivo = trattaArrivoViaggio.getOraArrivo();
        oraPartenza = trattaPartenzaViaggio.getOraPartenza();
        String idViaggio=generaID.getID();




        viaggioCreato = new Viaggio(idViaggio,idTratta,idPartenza,idArrivo,dataViaggio,oraPartenza,oraArrivo,idBiglietto);


        return viaggioCreato;
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

