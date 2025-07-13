package it.unipv.ingsfw.treninordovest.model.facade.login;

import it.unipv.ingsfw.treninordovest.model.dto.LoginDTO;
import it.unipv.ingsfw.treninordovest.model.utenti.cliente.Cliente;
import it.unipv.ingsfw.treninordovest.model.utenti.dipendente.Dipendente;

public interface IRegistrationFacade {

    boolean login(LoginDTO loginDTO);
    void logout();
    boolean registraCliente(Cliente cliente);
    boolean registraDipendente(Dipendente dipendente);

}
