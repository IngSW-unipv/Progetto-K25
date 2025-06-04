package it.unipv.ingsfw.treninordovest.strategy.biglietto;

import it.unipv.ingsfw.treninordovest.factory.implementations.BigliettoStrategyFactory;
import it.unipv.ingsfw.treninordovest.model.titoli.Biglietto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BigliettoConcreteTest {

    @Test
    void name() {

        IBigliettoStrategy strategy = BigliettoStrategyFactory.getFactoryFromProperties("Biglietto");

        System.out.println(strategy.ottieniPrezzoBiglietto());
        System.out.println(strategy.getValidazione());
        System.out.println(strategy.getDataEmissione());


    }
}