package it.unipv.ingsfw.treninordovest.model.facade.utente;

import it.unipv.ingsfw.treninordovest.model.service.UtenteService;

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
}
