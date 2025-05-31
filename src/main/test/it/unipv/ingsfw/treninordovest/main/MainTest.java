package it.unipv.ingsfw.treninordovest.main;

import it.unipv.ingsfw.treninordovest.factory.interfaces.IAbbonamentoFactory;
import it.unipv.ingsfw.treninordovest.factory.implementations.AbbonamentoStrategyFactory;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void main() {

        IAbbonamentoFactory abbonamentoFactory = AbbonamentoStrategyFactory.getFactoryFromProperties("Mensile");


    }
}