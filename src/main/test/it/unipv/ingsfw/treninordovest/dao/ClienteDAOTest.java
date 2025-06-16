package it.unipv.ingsfw.treninordovest.dao;

import it.unipv.ingsfw.treninordovest.model.utenti.cliente.Cliente;
import it.unipv.ingsfw.treninordovest.model.utenti.cliente.ClienteDAO;
import it.unipv.ingsfw.treninordovest.model.utenti.cliente.ClienteDAOImpl;
import org.junit.jupiter.api.Test;

public class ClienteDAOTest {
    @Test
    void autenticateTest() {

        ClienteDAOImpl clienteDAO = new ClienteDAOImpl();

        Cliente cliente = new Cliente("mario@gmail.com","1234");

        Cliente cliente1 = clienteDAO.get(cliente);

        System.out.println(cliente1.getId());
        System.out.println(cliente1.getNome());
        System.out.println(cliente1.getCognome());


    }
    @Test
    void autenticateByEmail() {

        Cliente cliente = new Cliente("mario@gmail.com","1234");

        Cliente clienteLoggato;

        ClienteDAOImpl clienteDAO = new ClienteDAOImpl();
        clienteLoggato= clienteDAO.autenticateByEmail(cliente);

        System.out.println(clienteLoggato.getId());
        System.out.println(clienteLoggato.getNome());
        System.out.println(clienteLoggato.getCognome());



    }

}
