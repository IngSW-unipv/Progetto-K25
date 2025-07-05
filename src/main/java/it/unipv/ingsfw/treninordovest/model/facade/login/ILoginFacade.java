package it.unipv.ingsfw.treninordovest.model.facade.login;

import it.unipv.ingsfw.treninordovest.model.utenti.cliente.Cliente;
import it.unipv.ingsfw.treninordovest.model.utenti.dipendente.Dipendente;
import it.unipv.ingsfw.treninordovest.model.utenti.utente.Utente;

public interface ILoginFacade {

    boolean login(String id, String password , String tipoUtente);
    void logout();
    boolean registraCliente(Cliente cliente);
    boolean registraDipendente(Dipendente dipendente);

}
