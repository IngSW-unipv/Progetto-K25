package it.unipv.ingsfw.treninordovest.model.utils.metodipagamento;

import it.unipv.ingsfw.treninordovest.model.strategy.pagamento.IPagamentoStrategy;

import java.time.LocalDate;
import java.util.Random;

public class CartaCredito implements  IPagamentoStrategy {
    private String numeroCarta;
    private LocalDate dataScadenza;
    private String cvv;

    public CartaCredito() {
    }

    public CartaCredito(String numeroCarta, LocalDate dataScadenza, String cvv) {
        this.numeroCarta = numeroCarta;
        this.dataScadenza = dataScadenza;
        this.cvv = cvv;
    }


    @Override
    public boolean paga(double prezzo) {
        return true;
    }

    @Override
    public String getTipo() {
        return "Carta di credito";
    }

}
