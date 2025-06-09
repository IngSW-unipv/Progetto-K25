package it.unipv.ingsfw.treninordovest.model.utenti.cliente;

import it.unipv.ingsfw.treninordovest.model.titoli.pagamento.Pagamento;
import it.unipv.ingsfw.treninordovest.model.titoli.pagamento.PagamentoDAOImpl;
import it.unipv.ingsfw.treninordovest.model.varie.GeneraID;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AbbonamentoTest {

    @Test
    void Test(){

        Pagamento pagamento = new Pagamento();
        pagamento.setDataPagamento(LocalDate.now());
        pagamento.setIdPagamento(new GeneraID("PG").getID());
        pagamento.setTipo("Test");
        pagamento.setTotale(0);

        Cliente cliente = new Cliente();
        cliente.setId("CL67713");

        PagamentoDAOImpl pagamentoDAO = new PagamentoDAOImpl();



        pagamentoDAO.insertPagamento(pagamento,cliente.getId());




    }

}