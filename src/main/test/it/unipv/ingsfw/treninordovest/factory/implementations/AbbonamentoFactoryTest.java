package it.unipv.ingsfw.treninordovest.factory.implementations;

import it.unipv.ingsfw.treninordovest.factory.abstracts.IAbbonamentoAbstractFactory;

import static org.junit.jupiter.api.Assertions.*;

class AbbonamentoFactoryTest {

    @org.junit.jupiter.api.Test
    void getAbbonamento() {

        String tipoAbbonamento = "Mensile";

        IAbbonamentoAbstractFactory factory = AbbonamentoFactory.getFactoryFromProperties(tipoAbbonamento);



    }

}