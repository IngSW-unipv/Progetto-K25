package it.unipv.ingsfw.treninordovest.service;

import it.unipv.ingsfw.treninordovest.model.factory.implementations.AbbonamentoStrategyFactory;
import it.unipv.ingsfw.treninordovest.model.factory.implementations.PagamentoStrategyFactory;
import it.unipv.ingsfw.treninordovest.model.strategy.abbonamento.IAbbonamentoStrategy;
import it.unipv.ingsfw.treninordovest.model.strategy.pagamento.IPagamentoStrategy;
import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.Abbonamento;
import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.AbbonamentoDAOimpl;
import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.BigliettoDAOImpl;
import it.unipv.ingsfw.treninordovest.model.titoli.pagamento.PagamentoDAOImpl;
import it.unipv.ingsfw.treninordovest.model.titoli.tessera.Tessera;
import it.unipv.ingsfw.treninordovest.model.titoli.tessera.TesseraDAOImpl;
import it.unipv.ingsfw.treninordovest.model.utenti.cliente.Cliente;
import it.unipv.ingsfw.treninordovest.model.utenti.utente.Utente;
import it.unipv.ingsfw.treninordovest.model.varie.GeneraID;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;

import java.time.LocalDate;
import java.util.UUID;

public class AcquistoService {
    private AbbonamentoDAOimpl abbonamentoDAO;
    private BigliettoDAOImpl bigliettoDAO;
    private PagamentoDAOImpl pagamentoDAO;
    private TesseraDAOImpl tesseraDAO;
    private Utente clienteLoggato;

    public AcquistoService() {
        this.abbonamentoDAO=new AbbonamentoDAOimpl();
        this.bigliettoDAO=new BigliettoDAOImpl();
        this.pagamentoDAO=new PagamentoDAOImpl();
        this.tesseraDAO=new TesseraDAOImpl();
    }

    public boolean acquistoAbbonamento(String tipoAbbonamento,String tipoPagamento) {

        clienteLoggato = (Cliente) SessionManager.getInstance().getCurrentUser();
        IPagamentoStrategy pagamentoStrategy = PagamentoStrategyFactory.getFactoryFromProperties(tipoPagamento);
        String idTesseraLoggato = tesseraDAO.getIdTesseraByCustomerID(clienteLoggato.getId().toString());

        //Test
        String idPagamento="PG0001";

        try {

            if (clienteLoggato!=null) {
                IAbbonamentoStrategy abbonamentoStrategy = AbbonamentoStrategyFactory.getFactoryFromProperties(tipoAbbonamento);
                Abbonamento abbonamento = abbonamentoStrategy.createAbbonamento(clienteLoggato.getId().toString(),idPagamento,idTesseraLoggato);

                if( abbonamentoDAO.createAbbonamento(abbonamento, idTesseraLoggato, clienteLoggato.getId().toString(),idPagamento))
                    return true;
            }


        }catch (Exception e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean acquistoBiglietto() {
        clienteLoggato = (Cliente) SessionManager.getInstance().getCurrentUser();
        return false;
    }


    public boolean acquistoTessera() {

        clienteLoggato = (Cliente) SessionManager.getInstance().getCurrentUser();

        try {
            if (!(tesseraDAO.exists(clienteLoggato.getId().toString())) && clienteLoggato != null) {
                Tessera tessera = new Tessera(UUID.randomUUID());
                if (tesseraDAO.createTessera(tessera, clienteLoggato.getId().toString()))
                    return true;

            }


        } catch (NullPointerException e) {
            e.printStackTrace();

        }


        return false;
    }



}
