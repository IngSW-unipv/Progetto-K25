package it.unipv.ingsfw.treninordovest.dao;

import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.Abbonamento;
import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.AbbonamentoDAOimpl;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class AbbonamentoDAOTest {

    @Test
    public void getAbbonamento() {

        AbbonamentoDAOimpl abbonamentoDAO = new AbbonamentoDAOimpl();

        Abbonamento abbonamento = new Abbonamento("0def94e6-c950-4abc-b4b6-0443cbe93694");

//        Abbonamento abbonamento1 =  abbonamentoDAO.get(abbonamento);
//
//        System.out.println(abbonamento1.getTipoAbbonamento());
//        System.out.println(abbonamento1.getId());
//        System.out.println(abbonamento1.getScadenza());

        System.out.println(UUID.randomUUID().toString());

    }

}
