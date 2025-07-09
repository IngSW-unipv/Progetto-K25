package it.unipv.ingsfw.treninordovest.model.factory.login;

import it.unipv.ingsfw.treninordovest.model.dto.LoginDTO;
import it.unipv.ingsfw.treninordovest.model.utenti.cliente.Cliente;
import it.unipv.ingsfw.treninordovest.model.utenti.cliente.ClienteDAOImpl;

public class ClienteLogin implements ILogin<Cliente> {
    @Override
    public Cliente login(LoginDTO loginDTO) {
        ClienteDAOImpl dao = new ClienteDAOImpl();
        return dao.autenticateByEmail(new Cliente(loginDTO));
    }
}
