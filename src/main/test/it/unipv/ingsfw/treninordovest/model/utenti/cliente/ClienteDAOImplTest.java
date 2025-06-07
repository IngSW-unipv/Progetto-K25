package it.unipv.ingsfw.treninordovest.model.utenti.cliente;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteDAOImplTest {

    @Test
    void get() {
        Cliente cliente = new Cliente();

        cliente.setId("CL15908");

        ClienteDAOImpl dao = new ClienteDAOImpl();

        cliente=dao.get(cliente);

        System.out.println(cliente);


    }

    @Test
    void getAll() {
    }

    @Test
    void delete() {
    }

    @Test
    void update() {
    }

    @Test
    void insert() {
    }
}