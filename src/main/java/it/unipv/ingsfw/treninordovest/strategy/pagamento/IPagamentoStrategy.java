package it.unipv.ingsfw.treninordovest.strategy.pagamento;

public interface IPagamentoStrategy {

    boolean paga(double prezzo);
    String getTipo();



}
