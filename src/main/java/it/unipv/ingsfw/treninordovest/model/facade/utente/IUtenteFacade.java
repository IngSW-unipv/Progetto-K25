package it.unipv.ingsfw.treninordovest.model.facade.utente;

import it.unipv.ingsfw.treninordovest.model.utenti.dipendente.Dipendente;

public interface IUtenteFacade {

    boolean aggiornaProfiloCliente();
    Dipendente aggiornaProfiloDipendente();
    boolean aggiornaPasswordCliente(String password);
    boolean aggiornaPasswordDipendente(String password);
}
