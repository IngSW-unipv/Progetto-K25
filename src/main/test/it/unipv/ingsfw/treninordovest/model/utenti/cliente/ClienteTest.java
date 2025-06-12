package it.unipv.ingsfw.treninordovest.model.utenti.cliente;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.UUID;

public class ClienteTest {

    @Test
    void createUserFromInterface() {

        Cliente cliente ;

        ClienteDAOImpl dao = new ClienteDAOImpl();

        cliente = new Cliente();

        cliente.setId(UUID.randomUUID());
        cliente.setNome("Mario");
        cliente.setCognome("Pini");
        cliente.setUserPassword("sadadsadt");
        cliente.setIndirizzo("wqqw");
        cliente.setCellulare("d32423424");
        cliente.setDataNascita(LocalDate.now());
        cliente.setSesso("T");
        cliente.setLuogoNascita("xyz");
        cliente.setBilancio(200);
        cliente.setEmail("lfdm");

        dao.insert(cliente);



    }
}
