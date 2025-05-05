package it.unipv.ingsfw.treninordovest.dao.implementations.utenti;

import it.unipv.ingsfw.treninordovest.model.utenti.Dipendente;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DipendenteDAOImplTest {

    @Test
    void get() {

        DipendenteDAOImpl dao = new DipendenteDAOImpl();

        Dipendente dip = new Dipendente();

        Dipendente dipendente = dao.get("D4999");
        assertNotNull(dipendente);
        assertEquals("Test", dipendente.getNome());
        assertEquals("Inserimento", dipendente.getCognome());

    } //OK

    @Test
    void getAll() {
        DipendenteDAOImpl dao = new DipendenteDAOImpl();
        List<Dipendente> dipendenti = dao.getAll();
        assertNotNull(dipendenti);
        assertFalse(dipendenti.isEmpty());

    } //OK

    @Test
    void delete() {
        DipendenteDAOImpl dao = new DipendenteDAOImpl();
        dao.delete("DP9999");
        Dipendente eliminato = dao.get("DP9999");
        assertNull(eliminato);

    } //OK

    @Test
    void update() {
        DipendenteDAOImpl dao = new DipendenteDAOImpl();
        Dipendente daAggiornare = dao.get("D4999");
        assertNotNull(daAggiornare);
        daAggiornare.setStipendio(2100.0);
        daAggiornare.setRuolo("Controllore");

        dao.update(daAggiornare);

        Dipendente aggiornato = dao.get("D4999");
        assertEquals(2100.0, aggiornato.getStipendio());
        assertEquals("Controllore", aggiornato.getRuolo());

    } //OK

    @Test
    void insert() {
        DipendenteDAOImpl dao = new DipendenteDAOImpl();
        Dipendente nuovo = new Dipendente(
                "D4999", "password", "Test", "Inserimento", "Roma", "M", LocalDate.of(1990, 5, 21),
                "3334445555", "Via Test, 1", "T001", 1200.0, "Capotreno"
        );
        dao.insert(nuovo);

        Dipendente inserito = dao.get("D4999");
        assertNotNull(inserito);
        assertEquals("Test", inserito.getNome());
        assertEquals("Capotreno", inserito.getRuolo());

    } //OK

    @Test
    void autenticate() {
        DipendenteDAOImpl dao = new DipendenteDAOImpl();
        Dipendente autenticato = dao.autenticate("D4999", "nuovaPasswordSicura");
        assertNotNull(autenticato);
        assertEquals("D4999", autenticato.getId());

      //  Dipendente fallito = dao.autenticate("D4999", "nuovaPasswordSicura");
       // assertNull(fallito);

    } //OK

    @Test
    void updatePassword() {
        DipendenteDAOImpl dao = new DipendenteDAOImpl();
        boolean aggiornato = dao.updatePassword("D4999", "nuovaPasswordSicura");
        assertTrue(aggiornato);

        // Ora l'autenticazione deve funzionare solo con la nuova password
        Dipendente autenticato = dao.autenticate("D4999", "nuovaPasswordSicura");
        assertNotNull(autenticato);

    } //OK
}