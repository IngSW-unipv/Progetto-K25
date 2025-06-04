package it.unipv.ingsfw.treninordovest.facade.implementations.gestionetitoli;

import it.unipv.ingsfw.treninordovest.model.utenti.Cliente;
import it.unipv.ingsfw.treninordovest.model.utenti.Utente;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AbbonamentoManagementFacadeTest {

    @Test
    void acquistaTitoloViaggio() {



        Cliente cliente = new Cliente();
        cliente.setNome("Ricardo");
        cliente.setCognome("Ricardo");
        cliente.setIndirizzo("Ricardo");
       cliente.setId("CL94116");
        SessionManager.getInstance().setCurrentUser(cliente);
        String tipotitolo ="mensile";
        String metodo = "euwallet";
        int numeroTitoli=1;

        AbbonamentoManagementFacade facade = new AbbonamentoManagementFacade();

        facade.acquistaTitoloViaggio(tipotitolo, metodo, numeroTitoli);

        System.out.println(cliente.getBilancio());


    }
}