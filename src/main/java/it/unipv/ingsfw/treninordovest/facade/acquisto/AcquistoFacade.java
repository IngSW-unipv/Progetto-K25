package it.unipv.ingsfw.treninordovest.facade.acquisto;

import it.unipv.ingsfw.treninordovest.factory.implementations.AbbonamentoStrategyFactory;
import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.Abbonamento;
import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.AbbonamentoDAOimpl;
import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.BigliettoDAOImpl;
import it.unipv.ingsfw.treninordovest.model.titoli.pagamento.Pagamento;
import it.unipv.ingsfw.treninordovest.model.titoli.pagamento.PagamentoDAOImpl;

import it.unipv.ingsfw.treninordovest.model.titoli.tessera.Tessera;
import it.unipv.ingsfw.treninordovest.model.titoli.tessera.TesseraDAOImpl;
import it.unipv.ingsfw.treninordovest.model.utenti.cliente.Cliente;
import it.unipv.ingsfw.treninordovest.model.varie.GeneraID;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;
import it.unipv.ingsfw.treninordovest.strategy.abbonamento.IAbbonamentoStrategy;
import it.unipv.ingsfw.treninordovest.strategy.pagamento.IPagamentoTitoliStrategy;

import java.time.LocalDate;


public class AcquistoFacade implements IAcquistoFacade {


    private Cliente clienteLoggato;
    private TesseraDAOImpl tesseraDAO;
    private PagamentoDAOImpl pagamentoDAO;
    private AbbonamentoDAOimpl abbonamentoDAO;
    private BigliettoDAOImpl bigliettoDAO;

    public AcquistoFacade() {
        this.abbonamentoDAO=new AbbonamentoDAOimpl();
        this.bigliettoDAO=new BigliettoDAOImpl();
        this.pagamentoDAO=new PagamentoDAOImpl();
        this.tesseraDAO=new TesseraDAOImpl();
        clienteLoggato = (Cliente) SessionManager.getInstance().getCurrentUser();
    }

    @Override
    public boolean acquistaBiglietto() {
        return false;
    }

    @Override
    public boolean acquistoAbbonamento(String tipoAbbonamento,String tipoPagamento) {

        if(clienteLoggato!=null){

            try {
                IAbbonamentoStrategy abbonamentoStrategy = AbbonamentoStrategyFactory.getFactoryFromProperties(tipoAbbonamento);

                if( abbonamentoDAO.createAbbonamento((Abbonamento) abbonamentoStrategy, tesseraDAO.getIdTesseraByCustomerID(clienteLoggato.getId().toString()), clienteLoggato.getId().toString()))
                        return true;

            }catch (Exception e) {
                e.printStackTrace();
            }



        }




        return false;
    }

    @Override
    public boolean acquistaTessera(){
        if(clienteLoggato !=null) {
            try {
                if (!tesseraDAO.exists(clienteLoggato.getId().toString()) && clienteLoggato != null) {
                    Tessera tessera = new Tessera(new GeneraID("TS").getID(), LocalDate.now(), LocalDate.now().plusYears(5));
                    if (tesseraDAO.createTessera(tessera, clienteLoggato.getId().toString()))
                        return true;

                }


            } catch (NullPointerException e) {
                e.printStackTrace();

            }

        }


        return false;


    }






}
