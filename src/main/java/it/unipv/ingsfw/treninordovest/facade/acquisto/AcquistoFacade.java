package it.unipv.ingsfw.treninordovest.facade.acquisto;

import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.AbbonamentoDAOimpl;
import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.BigliettoDAOImpl;
import it.unipv.ingsfw.treninordovest.model.titoli.pagamento.PagamentoDAOImpl;

import it.unipv.ingsfw.treninordovest.model.titoli.tessera.Tessera;
import it.unipv.ingsfw.treninordovest.model.titoli.tessera.TesseraDAOImpl;
import it.unipv.ingsfw.treninordovest.model.utenti.cliente.Cliente;
import it.unipv.ingsfw.treninordovest.model.varie.GeneraID;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;

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
    }

    @Override
    public boolean acquistaBiglietto() {
        return false;
    }

    @Override
    public boolean acquistoAbbonamento() {



        return false;
    }

    @Override
    public boolean acquistaTessera(){
        if(SessionManager.getInstance().getCurrentUser() !=null){
            clienteLoggato = (Cliente) SessionManager.getInstance().getCurrentUser();
        }
        try {
            if (!tesseraDAO.exists(clienteLoggato.getId().toString()) && clienteLoggato != null) {
                    Tessera tessera = new Tessera( new GeneraID("TS").getID(), LocalDate.now(), LocalDate.now().plusYears(5));
                    if (tesseraDAO.createTessera(tessera,clienteLoggato.getId().toString()))
                        return true;

            }


        } catch (NullPointerException e) {
            e.printStackTrace();
            return false;
        }

        return false;


    }





}
