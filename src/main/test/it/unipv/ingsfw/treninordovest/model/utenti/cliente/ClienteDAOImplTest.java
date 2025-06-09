package it.unipv.ingsfw.treninordovest.model.utenti.cliente;

import it.unipv.ingsfw.treninordovest.model.varie.GeneraID;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class ClienteDAOImplTest {

    @Test
    void get() {



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
        ClienteDAOImpl dao = new ClienteDAOImpl();

        Cliente cliente = new Cliente();
        cliente.setId(new GeneraID("CL").getID());
        cliente.setNome("Test");
        cliente.setCognome("Test");
        cliente.setSesso("T");
        cliente.setUserPassword("Test");
        cliente.setLuogoNascita("Test");
        cliente.setEmail("Test");
        cliente.setIndirizzo("Test");
        cliente.setDataNascita(LocalDate.now());
        cliente.setCellulare("Test");
        cliente.setBilancio(2);
        dao.insert(cliente);
    }
}