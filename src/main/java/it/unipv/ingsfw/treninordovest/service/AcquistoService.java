package it.unipv.ingsfw.treninordovest.service;

import it.unipv.ingsfw.treninordovest.model.factory.implementations.AbbonamentoStrategyFactory;
import it.unipv.ingsfw.treninordovest.model.factory.implementations.BigliettoStrategyFactory;
import it.unipv.ingsfw.treninordovest.model.strategy.abbonamento.IAbbonamentoStrategy;
import it.unipv.ingsfw.treninordovest.model.strategy.biglietto.IBigliettoStrategy;
import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.Abbonamento;
import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.AbbonamentoDAOimpl;
import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.Biglietto;
import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.BigliettoDAOImpl;
import it.unipv.ingsfw.treninordovest.model.titoli.pagamento.Pagamento;
import it.unipv.ingsfw.treninordovest.model.titoli.pagamento.PagamentoDAOImpl;
import it.unipv.ingsfw.treninordovest.model.titoli.tessera.Tessera;
import it.unipv.ingsfw.treninordovest.model.titoli.tessera.TesseraDAOImpl;
import it.unipv.ingsfw.treninordovest.model.utenti.cliente.Cliente;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;

import java.time.LocalDate;
import java.util.UUID;

public class AcquistoService {
    private AbbonamentoDAOimpl abbonamentoDAO;
    private BigliettoDAOImpl bigliettoDAO;
    private PagamentoDAOImpl pagamentoDAO;
    private TesseraDAOImpl tesseraDAO;
    private Cliente clienteLoggato;
    private PagamentoService pagamentoService;

    public AcquistoService() {
        this.abbonamentoDAO=new AbbonamentoDAOimpl();
        this.bigliettoDAO=new BigliettoDAOImpl();
        this.pagamentoDAO=new PagamentoDAOImpl();
        this.tesseraDAO=new TesseraDAOImpl();
        this.pagamentoService=new PagamentoService();
    }

    public boolean acquistoAbbonamento(String tipoAbbonamento,String tipoPagamento,int quantita) {

        IAbbonamentoStrategy abbonamentoStrategy = AbbonamentoStrategyFactory.getFactoryFromProperties(tipoAbbonamento);
        Abbonamento abbonamento;
        clienteLoggato = (Cliente) SessionManager.getInstance().getCurrentUser();
        Pagamento pag;

        try {
            if (clienteLoggato!=null && clienteLoggato.getTessera().getIdTessera()!=null) {
                abbonamento = abbonamentoStrategy.createAbbonamento(clienteLoggato.getTessera());
                pag =  pagamentoService.effettuaPagamento(tipoPagamento,quantita,abbonamentoStrategy.ottieniPrezzoAbbonamento());
                abbonamento.setPagamento(pag);

                for(int it =0; it<quantita; it++) {
                    abbonamentoDAO.insert(abbonamento);
                    abbonamento.setId(UUID.randomUUID().toString());
                }

               return true;
            } else if(clienteLoggato.getTessera()==null) {
                System.out.println("Non disponi di una tessera");

            }


        }catch (Exception e) {
            System.out.println("Non disponi di una tessera");
            e.getMessage();
            e.printStackTrace();
            return false;
        }

        return false;

    }

    public boolean acquistoBiglietto(String tipoBiglietto, String tipoPagamento, int quantita, String idTratta, boolean ritorno, LocalDate dataRitorno) {
        clienteLoggato = (Cliente) SessionManager.getInstance().getCurrentUser();
        Pagamento pag;
        Biglietto biglietto;
        IBigliettoStrategy bigliettoStrategy = BigliettoStrategyFactory.getFactoryFromProperties(tipoBiglietto);

        try {

            if(clienteLoggato!=null) {
                biglietto = bigliettoStrategy.createBiglietto(clienteLoggato.getId().toString(),clienteLoggato.getTessera().getIdTessera(),ritorno,dataRitorno);
               pag = pagamentoService.effettuaPagamento(tipoPagamento,quantita,bigliettoStrategy.ottieniPrezzoBiglietto());
               biglietto.setPagamento(pag);
               for(int it =0; it<quantita; it++) {
                   bigliettoDAO.insert(biglietto);
                   biglietto.setId(UUID.randomUUID().toString());
               }


            }


        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }


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


        } catch (Exception e) {
            e.printStackTrace();

        }


        return false;
    }



}
