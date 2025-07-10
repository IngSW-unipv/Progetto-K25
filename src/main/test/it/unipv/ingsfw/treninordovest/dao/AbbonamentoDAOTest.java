package it.unipv.ingsfw.treninordovest.dao;

import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.Abbonamento;
import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.AbbonamentoDAOimpl;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AbbonamentoDAOTest {

    @Test
    public void getAbbonamento() {

        AbbonamentoDAOimpl abbonamentoDAO = new AbbonamentoDAOimpl();

        try {
        List<Abbonamento> lis = abbonamentoDAO.getAllAbbonamentiByCliente("1926-24dc-4149-a605-c275b334a69507e");

        if(lis.isEmpty()){
            throw new Exception("Nessun abbonamento trovato");
        }

            for (Abbonamento abb : lis) {
                System.out.println(abb.getId());
            }


        }catch (Exception e){
            System.out.println("Eccezione: " + e.getMessage());
        }



    }



}
