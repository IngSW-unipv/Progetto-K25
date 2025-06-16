package it.unipv.ingsfw.treninordovest.factory.login;

import it.unipv.ingsfw.treninordovest.model.utenti.cliente.Cliente;
import it.unipv.ingsfw.treninordovest.model.utenti.cliente.ClienteDAOImpl;
import it.unipv.ingsfw.treninordovest.model.utenti.utente.Utente;

public class ClienteLogin implements ILogin<Cliente> {
    @Override
    public Cliente login(String username, String password) {
        ClienteDAOImpl dao = new ClienteDAOImpl();
        return dao.autenticateByEmail(new Cliente(username, password));
    }
}
