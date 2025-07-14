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

    public CartaCredito(String numeroCarta, String cvv, LocalDate dataScadenza) {
        this.numeroCarta = numeroCarta;
        this.cvv = cvv;
        this.dataScadenza = dataScadenza;
    }

    @Override
    public boolean paga(double prezzo) {

        Random r = new Random();

        return r.nextBoolean();

        //return true;

    }

    @Override
    public String getTipo() {
        return "Carta di credito";
    }

}
