package it.unipv.ingsfw.treninordovest.factory.implementations;

import it.unipv.ingsfw.treninordovest.utils.metodipagamento.IMetodoPagamento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MetodoPagamentoFactoryTest {

    @Test
    void name() {

        String metodo ="euwallet";

        IMetodoPagamento metodoPagamento = MetodoPagamentoFactory.getFactoryFromProperties(metodo);
    }
}