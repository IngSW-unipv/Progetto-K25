package it.unipv.ingsfw.treninordovest.facade.implementations;

import it.unipv.ingsfw.treninordovest.facade.interfaces.ITitoloViaggioFacade;
import it.unipv.ingsfw.treninordovest.model.titoli.Biglietto;

import java.util.List;

public class TicketManagementFacade implements ITitoloViaggioFacade<Biglietto> {

    /***
     * Impostazione statica della facade
     */
    private static TicketManagementFacade instance;
    public static TicketManagementFacade getInstance() {
        if (instance == null) {
            instance = new TicketManagementFacade();
        }
        return instance;
    }

    @Override
    public Biglietto acquistaTitoloViaggio() {
        return null;
    }

    @Override
    public Biglietto rimuoviTitoloViaggio() {
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
    public List<Biglietto> getTitoloViaggio() {
        return List.of();
    }
}
