package it.unipv.ingsfw.treninordovest.model.facade.utente;

import it.unipv.ingsfw.treninordovest.model.service.utente.UtenteService;
import it.unipv.ingsfw.treninordovest.model.utenti.dipendente.Dipendente;

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
    public Dipendente aggiornaProfiloDipendente() {
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



}
