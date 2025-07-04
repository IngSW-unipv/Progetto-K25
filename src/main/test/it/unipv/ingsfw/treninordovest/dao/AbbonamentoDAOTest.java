package it.unipv.ingsfw.treninordovest.dao;

import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.Abbonamento;
import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.AbbonamentoDAOimpl;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

public class AbbonamentoDAOTest {

    @Test
    public void getAbbonamento() {

        AbbonamentoDAOimpl abbonamentoDAO = new AbbonamentoDAOimpl();

        String idCliente = "cd9714b9-d9a2-4b8f-b062-9a8056c25f0e";
        List<Abbonamento> abbonamentoList = abbonamentoDAO.getAllAbbonamentiByCliente(idCliente);

        for (Abbonamento a : abbonamentoList) {
            System.out.println(a.getId());
        }


    }



}
