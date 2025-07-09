package it.unipv.ingsfw.treninordovest.model.service.utente;

import it.unipv.ingsfw.treninordovest.model.utenti.dipendente.Dipendente;
import it.unipv.ingsfw.treninordovest.model.utenti.utente.Utente;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ProfiloUtenteModel {

    private Utente utente;
    private PropertyChangeSupport support;

    public ProfiloUtenteModel() {
        support = new PropertyChangeSupport(this);
    }

    public void setDipendente(Utente nuovoUtente) {
        Utente vecchioUtente = this.utente;
        this.utente = nuovoUtente;
        support.firePropertyChange("dipendente_aggiornato", vecchioUtente, nuovoUtente);
    }

    public void setCliente(Utente nuovoUtente) {
        Utente vecchioUtente = this.utente;
        this.utente = nuovoUtente;
        support.firePropertyChange("cliente_aggiornato", vecchioUtente, nuovoUtente);
    }




    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }

    public Utente getUtente() {
        return utente;
    }



}
