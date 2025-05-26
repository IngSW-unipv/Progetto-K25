package it.unipv.ingsfw.treninordovest.facade.implementations.gestionetitoli;

import it.unipv.ingsfw.treninordovest.facade.interfaces.ITitoloViaggioFacade;
import it.unipv.ingsfw.treninordovest.model.titoli.Abbonamenti.Abbonamento;


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
