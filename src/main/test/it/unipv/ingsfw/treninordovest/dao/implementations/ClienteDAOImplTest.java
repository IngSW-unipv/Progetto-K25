package it.unipv.ingsfw.treninordovest.dao.implementations;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import it.unipv.ingsfw.treninordovest.dao.implementations.utenti.ClienteDAOImpl;
import it.unipv.ingsfw.treninordovest.model.utenti.Cliente;

import java.time.LocalDate;
import java.util.Date;

class ClienteDAOImplTest {

    @Test
    void testInsertAndGet() {
        ClienteDAOImpl dao = new ClienteDAOImpl();
        Cliente cliente = new Cliente("CL9001", "QWERT", "Mario", "Rossi", "Milano", "M", LocalDate.now(), "3317139498", "Via Roma 84", 200, "mariorossi@gmail.com");

        dao.insert(cliente);

        Cliente risultato = dao.get("CL9001");
        assertNotNull(risultato);
        assertEquals("Mario", risultato.getNome());
        assertEquals("Rossi", risultato.getCognome());
        // ... altri assert su altri campi
    }

    @Test
    void testUpdate() {
        ClienteDAOImpl dao = new ClienteDAOImpl();
        Cliente cliente = dao.get("CL1001");
        cliente.setNome("Luigi");
        dao.update(cliente);

        Cliente aggiornato = dao.get("CL1001");
        assertEquals("Luigi", aggiornato.getNome());
    }

    @Test
    void testDelete() {
        ClienteDAOImpl dao = new ClienteDAOImpl();
        dao.delete("CL1001");

        Cliente eliminato = dao.get("CL1001");
        assertNull(eliminato);
    }

    // Aggiungi test per ogni metodo del DAO
}