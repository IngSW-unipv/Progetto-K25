package it.unipv.ingsfw.treninordovest.model.facade.titoliviaggio;

import it.unipv.ingsfw.treninordovest.model.service.GestioneTitoliService;

import java.beans.PropertyChangeListener;

public class TitoloViaggioFacade implements ITitoloViaggioFacade{

    private GestioneTitoliService gestioneTitoliService;

    public TitoloViaggioFacade() {
        this.gestioneTitoliService=new GestioneTitoliService();
    }

    @Override
    public void mostraBigliettiAcquistati() {
        gestioneTitoliService.getTitoliBiglietto();
    }

    @Override
    public void mostraAbbonamentiAcquistati() {
        gestioneTitoliService.getTitoliAbbonamento();
    }

    public void addPropertyChangeListener(PropertyChangeListener listener){
        gestioneTitoliService.addPropertyChangeListener(listener);
    }
    public void removePropertyChangeListener(PropertyChangeListener listener){
        gestioneTitoliService.removePropertyChangeListener(listener);
    }

}
