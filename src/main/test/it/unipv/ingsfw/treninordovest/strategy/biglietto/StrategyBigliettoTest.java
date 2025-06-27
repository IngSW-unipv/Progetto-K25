package it.unipv.ingsfw.treninordovest.strategy.biglietto;

import it.unipv.ingsfw.treninordovest.model.factory.implementations.BigliettoStrategyFactory;
import it.unipv.ingsfw.treninordovest.model.strategy.biglietto.IBigliettoStrategy;
import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.Biglietto;
import org.junit.jupiter.api.Test;

public class StrategyBigliettoTest {

    @Test
    void TestBigliettoStrategy() {

        String tipo = "andataritorno";

        IBigliettoStrategy bigliettoStrategy = BigliettoStrategyFactory.getFactoryFromProperties(tipo);

        Biglietto biglietto = bigliettoStrategy.createBiglietto();

        System.out.println(biglietto.getId());
        System.out.println(biglietto.getEmissione());
        System.out.println(biglietto.getPrezzo());
        System.out.println(biglietto.getPagamento());



    }
}
