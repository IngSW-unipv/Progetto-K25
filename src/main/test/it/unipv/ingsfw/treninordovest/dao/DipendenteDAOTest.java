package it.unipv.ingsfw.treninordovest.dao;

import it.unipv.ingsfw.treninordovest.model.utenti.dipendente.Dipendente;
import it.unipv.ingsfw.treninordovest.model.utenti.dipendente.DipendenteDAOImpl;
import org.junit.jupiter.api.Test;

public class DipendenteDAOTest {

    @Test
    void get() {

        DipendenteDAOImpl dipendenteDAO = new DipendenteDAOImpl();

        Dipendente dipendente = dipendenteDAO.get(new Dipendente("0dbc4add-de82-43ba-9df8-a5ba85482bdc","password"));

        System.out.println(dipendente.getId().toString());
        System.out.println(dipendente.getNome());
        System.out.println(dipendente.getCognome());



    }
}
