package it.unipv.ingsfw.treninordovest.dao;

import it.unipv.ingsfw.treninordovest.model.utenti.cliente.Cliente;
import it.unipv.ingsfw.treninordovest.model.utenti.cliente.ClienteDAO;
import it.unipv.ingsfw.treninordovest.model.utenti.cliente.ClienteDAOImpl;
import org.junit.jupiter.api.Test;

public class ClienteDAOTest {
    @Test
    void autenticateTest() {

        ClienteDAOImpl clienteDAO = new ClienteDAOImpl();

        Cliente cliente = new Cliente("csacas","ddwdqd");

        clienteDAO.autenticateByEmail(cliente);

    }
}
