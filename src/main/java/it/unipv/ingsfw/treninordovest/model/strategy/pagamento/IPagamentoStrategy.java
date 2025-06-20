package it.unipv.ingsfw.treninordovest.model.strategy.pagamento;

public interface IPagamentoStrategy {

    boolean paga(double prezzo);
    String getTipo();



}
