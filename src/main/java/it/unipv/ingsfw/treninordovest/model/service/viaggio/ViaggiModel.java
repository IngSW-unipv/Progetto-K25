package it.unipv.ingsfw.treninordovest.model.service.viaggio;


import it.unipv.ingsfw.treninordovest.model.ferrovia.viaggio.Viaggio;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class ViaggiModel {

    private List<Viaggio> viaggi;
    private final PropertyChangeSupport support;

    public ViaggiModel() {
        this.viaggi = new ArrayList<>();
        this.support = new PropertyChangeSupport(this);
    }

    public void setViaggi(List<Viaggio> nuoviViaggi) {
        List<Viaggio> vecchiViaggi = this.viaggi;
        this.viaggi = nuoviViaggi;
        support.firePropertyChange("ottieni_viaggi_disponibili", vecchiViaggi, nuoviViaggi);
    }

    public List<Viaggio> getViaggi() {
        return viaggi;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
}
