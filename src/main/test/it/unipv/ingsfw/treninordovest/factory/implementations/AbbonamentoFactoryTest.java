package it.unipv.ingsfw.treninordovest.factory.implementations;

import it.unipv.ingsfw.treninordovest.factory.interfaces.IAbbonamentoFactory;

class AbbonamentoFactoryTest {

    @org.junit.jupiter.api.Test
    void getAbbonamento() {

        String tipoAbbonamento = "Mensile";

        IAbbonamentoFactory factory = AbbonamentoStrategyFactory.getFactoryFromProperties(tipoAbbonamento);






    }

}