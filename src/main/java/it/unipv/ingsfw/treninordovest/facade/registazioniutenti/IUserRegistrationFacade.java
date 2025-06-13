package it.unipv.ingsfw.treninordovest.facade.registazioniutenti;

import it.unipv.ingsfw.treninordovest.model.utenti.cliente.Cliente;
import it.unipv.ingsfw.treninordovest.model.utenti.dipendente.Dipendente;

/**
 * Interfaccia per la facade di registrazione utenti
 */
public interface IUserRegistrationFacade {
    /*
     * Registra un nuovo cliente
     * 
     * @param view Panel di registrazione cliente
     * @param componenteParent Componente genitore per mostrare messaggi
     * @return L'ID generato per il cliente registrato
     */
     boolean registraCliente(Cliente cliente);
    
    /*
     * Registra un nuovo dipendente
     * 
     * @param view Panel di registrazione dipendente
     * @param componenteParent Componente genitore per mostrare messaggi
     * @return L'ID generato per il dipendente registrato
     */
    boolean registraDipendente(Dipendente dipendente);
}