package it.unipv.ingsfw.treninordovest.factory.implementations;

import it.unipv.ingsfw.treninordovest.factory.interfaces.IAbbonamentoFactory;
import it.unipv.ingsfw.treninordovest.strategy.abbonamento.IAbbonamentoStrategy;

class AbbonamentoFactoryTest {

    @org.junit.jupiter.api.Test
    void getAbbonamento() {

        String tipoAbbonamento = "Mensile";

        IAbbonamentoStrategy factory = AbbonamentoStrategyFactory.getFactoryFromProperties(tipoAbbonamento);

        System.out.println(factory.getTipoAbbonamento());
        System.out.println(factory.getEmissioneAbbonamento());
        System.out.println(factory.getDataScadenza());
        System.out.println(factory.ottieniPrezzoAbbonamento());






    }

}