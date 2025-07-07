package it.unipv.ingsfw.treninordovest.model.facade.utente;

import it.unipv.ingsfw.treninordovest.model.service.UtenteService;

import java.beans.PropertyChangeListener;

public class UtenteFacade implements IUtenteFacade{

    private final UtenteService service;

    public UtenteFacade() {
        service = new UtenteService();
    }


    @Override
    public boolean aggiornaProfiloCliente() {
        return service.aggiornaDatiCliente();
    }

    @Override
    public boolean aggiornaProfiloDipendente() {
        return service.aggiornaDatiDipendente();
    }

    @Override
    public boolean aggiornaPasswordCliente(String password) {
        return service.aggiornaPasswordCliente(password);
    }

    @Override
    public boolean aggiornaPasswordDipendente(String password) {
        return service.aggiornaPasswordDipendente(password);
    }


    public void addPropertyChangeListener(PropertyChangeListener listener){
        service.addPropertyChangeListener(listener);
    }
    public void removePropertyChangeListener(PropertyChangeListener listener){
        service.removePropertyChangeListener(listener);
    }
}
