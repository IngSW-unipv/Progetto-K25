package it.unipv.ingsfw.treninordovest.model.utils.metodipagamento;

import it.unipv.ingsfw.treninordovest.model.strategy.pagamento.IPagamentoStrategy;

import java.util.Random;

public class PayPal implements IPagamentoStrategy {
    Random r = new Random();

    public PayPal() {
        String nomeAccount = "AccountPayPal";
    }

    @Override
    public boolean paga(double prezzo) {
        // Adattamento: mappa l'importo e chiama l'API

       //return r.nextBoolean();
        return true;
    }

    @Override
    public String getTipo() {
        return "PayPal";
    }
}

