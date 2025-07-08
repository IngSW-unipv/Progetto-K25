package it.unipv.ingsfw.treninordovest.model.service.titoli;

import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.Abbonamento;
import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.Biglietto;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class TitoliViaggioModel {
    private List<Biglietto> listaBiglietti;
    private List<Abbonamento> listaAbbonamenti;
    private final PropertyChangeSupport support;

    //Classe per trasportare oggetti nella vista
    public TitoliViaggioModel() {
        this.support = new PropertyChangeSupport(this);
        this.listaAbbonamenti = new ArrayList<>();
        this.listaBiglietti = new ArrayList<>();
    }

    public void setListaBiglietti(List<Biglietto> nuoviBiglietti){
        List<Biglietto> vecchiBigletti = this.listaBiglietti;
        this.listaBiglietti = nuoviBiglietti;
        support.firePropertyChange("get_titoliBiglietti_acq",vecchiBigletti,nuoviBiglietti);
    }

    public void setListaAbbonamenti(List<Abbonamento> nuoviAbbonamenti){
        List<Abbonamento> vecchiAbbonamenti= this.listaAbbonamenti;
        this.listaAbbonamenti = nuoviAbbonamenti;
        support.firePropertyChange("get_titoliAbbonamenti_acq",vecchiAbbonamenti,nuoviAbbonamenti);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }


}
