package it.unipv.ingsfw.treninordovest.model.utenti.cliente;

import org.junit.jupiter.api.Test;

public class ClienteTest {

    @Test
    void createUserFromInterface() {

        Cliente cliente = new Cliente();

        cliente.setNome("Paolo");
        cliente.setCognome("Lini");
        cliente.setCellulare("3324234");
        cliente.setIndirizzo("Via XXX");

        System.out.println(cliente.getId());
        System.out.println(cliente.getNome());
        System.out.println(cliente.getCognome());
        System.out.println(cliente.getIndirizzo());

    }
}
