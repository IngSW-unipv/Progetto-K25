package it.unipv.ingsfw.treninordovest.facade.interfaces;

import it.unipv.ingsfw.treninordovest.view.panels.users.CustomerRegistrationPanel;
import it.unipv.ingsfw.treninordovest.view.panels.users.EmployeeRegistrationPanel;

import javax.swing.*;

/**
 * Interfaccia per la facade di registrazione utenti
 */
public interface IUserRegistrationFacade {
    /**
     * Registra un nuovo cliente
     * 
     * @param view Panel di registrazione cliente
     * @param componenteParent Componente genitore per mostrare messaggi
     * @return L'ID generato per il cliente registrato
     */
    String registraCliente(CustomerRegistrationPanel view, JFrame componenteParent);
    
    /**
     * Registra un nuovo dipendente
     * 
     * @param view Panel di registrazione dipendente
     * @param componenteParent Componente genitore per mostrare messaggi
     * @return L'ID generato per il dipendente registrato
     */
    String registraDipendente(EmployeeRegistrationPanel view, JFrame componenteParent);
}