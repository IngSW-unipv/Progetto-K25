package it.unipv.ingsfw.treninordovest.facade.implementations.gestionetitoli;

import it.unipv.ingsfw.treninordovest.dao.implementations.titoli.AbbonamentoDAOimpl;
import it.unipv.ingsfw.treninordovest.dao.implementations.utenti.TesseraDAOImpl;
import it.unipv.ingsfw.treninordovest.facade.interfaces.ITitoloViaggioFacade;
import it.unipv.ingsfw.treninordovest.factory.implementations.AbbonamentoStrategyFactory;
import it.unipv.ingsfw.treninordovest.model.titoli.Abbonamento;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;
import it.unipv.ingsfw.treninordovest.strategy.abbonamento.IAbbonamentoStrategy;


import java.util.List;

public class AbbonamentoManagementFacade implements ITitoloViaggioFacade<Abbonamento> {

    private final TesseraDAOImpl tesseraDAO;
    private AbbonamentoDAOimpl abbonamentoDAO;
    private IAbbonamentoStrategy strategyFactoryAbbonamento;
    private String idUtenteLog = SessionManager.getInstance().getCurrentUser().getId();


    public AbbonamentoManagementFacade(String tipoAbbonamento) {
        this.tesseraDAO = new TesseraDAOImpl();
        this.abbonamentoDAO = new AbbonamentoDAOimpl();
        this.strategyFactoryAbbonamento = AbbonamentoStrategyFactory.getFactoryFromProperties(tipoAbbonamento);
    }

    @Override
    public Abbonamento acquistaTitoloViaggio() {
        Abbonamento abbonamento = null;
        String idTessera = cercaIdTessera();

       //abbonamento = strategyFactoryAbbonamento.createAbbonamento(idUtenteLog,,);


        return null;
    }

    @Override
    public Abbonamento rimuoviTitoloViaggio() {
        return null;
    }

    @Override
    public boolean titoloDisponibile() {
        return false;
    }

    @Override
    public void mostraTitolo() {



    }

    @Override
    public List<Abbonamento> getTitoloViaggio() {
        return List.of();
    }


    private String cercaIdTessera (){
        String idTessera = null;
        idTessera = tesseraDAO.getIdTesseraByCustomerID(idUtenteLog);
        return idTessera;
    }
}

