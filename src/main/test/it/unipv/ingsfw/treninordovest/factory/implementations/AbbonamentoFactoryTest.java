package it.unipv.ingsfw.treninordovest.factory.implementations;

import it.unipv.ingsfw.treninordovest.factory.interfaces.IAbbonamentoFactory;
import it.unipv.ingsfw.treninordovest.model.titoli.Abbonamento;
import it.unipv.ingsfw.treninordovest.model.titoli.Pagamento;
import it.unipv.ingsfw.treninordovest.model.varie.GeneraID;
import it.unipv.ingsfw.treninordovest.strategy.abbonamento.IAbbonamentoStrategy;

import java.time.LocalDate;

class AbbonamentoFactoryTest {

    @org.junit.jupiter.api.Test
    void getAbbonamento() {

        String tipoPagamento = "carta di credito";
        //String tipoAbbonamento = "Annuale";
        String tipoAbbonamento = "Settimanale";
        //String tipoAbbonamento = "Annuale";
        String idCliente ="CL94116" ;
        String idTessera=null;

        GeneraID generaIDPagamento = new GeneraID("PG");
        GeneraID generaIDAbbonamento = new GeneraID("AB");

        Pagamento p;
        p = new Pagamento();

        p.setDataPagamento(LocalDate.now());
        p.setIdPagamento(generaIDPagamento.getID());
        p.setTipo(tipoPagamento);

        IAbbonamentoStrategy factory = AbbonamentoStrategyFactory.getFactoryFromProperties(tipoAbbonamento);

        Abbonamento abbonamento = factory.createAbbonamento(idCliente,p.getIdPagamento(),idTessera);

        System.out.println("Abbonamento: " + abbonamento.getTipoAbbonamento());
        System.out.println(": " + abbonamento.getId());
        System.out.println(": " + abbonamento.getIdTessera());
        System.out.println(": " + abbonamento.getIdPagamento());
        System.out.println(": " + abbonamento.getEmissione());
        System.out.println(": " + abbonamento.getScadenza());


    }

}