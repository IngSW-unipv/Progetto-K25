package it.unipv.ingsfw.treninordovest.model.facade.titoliviaggio;

import it.unipv.ingsfw.treninordovest.model.service.titoli.GestioneTitoliService;
import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.Abbonamento;
import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.Biglietto;

import java.beans.PropertyChangeListener;
import java.util.List;

public class TitoloViaggioFacade implements ITitoloViaggioFacade{

    private GestioneTitoliService gestioneTitoliService;

    public TitoloViaggioFacade() {
        this.gestioneTitoliService=new GestioneTitoliService();
    }

    @Override
    public List<Biglietto> mostraBigliettiAcquistati() {
       return gestioneTitoliService.getTitoliBiglietto();
    }

    @Override
    public List<Abbonamento> mostraAbbonamentiAcquistati() {
       return gestioneTitoliService.getTitoliAbbonamento();
    }



}
