package it.unipv.ingsfw.treninordovest.facade.implementations;

import it.unipv.ingsfw.treninordovest.facade.interfaces.ITitoloViaggioFacade;
import it.unipv.ingsfw.treninordovest.model.titoli.Abbonamenti.Abbonamento;

import java.util.List;

public class AbbonamentoManagementFacade implements ITitoloViaggioFacade<Abbonamento> {
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
