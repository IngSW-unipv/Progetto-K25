package it.unipv.ingsfw.treninordovest.facade.implementations.gestionetitoli;

import it.unipv.ingsfw.treninordovest.dao.implementations.utenti.ClienteDAOImpl;
import it.unipv.ingsfw.treninordovest.dao.implementations.utenti.TesseraDAOImpl;
import it.unipv.ingsfw.treninordovest.facade.interfaces.ITitoloViaggioFacade;
import it.unipv.ingsfw.treninordovest.model.titoli.Abbonamenti.Abbonamento;
import it.unipv.ingsfw.treninordovest.model.utenti.Cliente;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;


import java.util.List;

public class AbbonamentoManagementFacade implements ITitoloViaggioFacade<Abbonamento> {

    private static AbbonamentoManagementFacade instance;

    public static AbbonamentoManagementFacade getInstance() {
        if (instance == null) {
            instance = new AbbonamentoManagementFacade();
        }
        return instance;
    }


    @Override
    public Abbonamento acquistaTitoloViaggio() {

        String idUtenteLog = SessionManager.getInstance().getCurrentUser().getId();
        TesseraDAOImpl tDAO = new TesseraDAOImpl();

        String idTessera = tDAO.getIdTesseraByCustomerID(idUtenteLog);

        if (idTessera != null){






        }






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
}
