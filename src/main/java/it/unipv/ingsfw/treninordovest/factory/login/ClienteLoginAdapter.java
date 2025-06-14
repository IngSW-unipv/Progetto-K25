package it.unipv.ingsfw.treninordovest.factory.login;

import it.unipv.ingsfw.treninordovest.model.utenti.cliente.Cliente;
import it.unipv.ingsfw.treninordovest.model.utenti.cliente.ClienteDAOImpl;

public class ClienteLoginAdapter implements IClienteLogin {
    @Override
    public Cliente login(Cliente cliente) {
        ClienteDAOImpl dao = new ClienteDAOImpl();
        return dao.autenticateByEmail(cliente);
    }
}
