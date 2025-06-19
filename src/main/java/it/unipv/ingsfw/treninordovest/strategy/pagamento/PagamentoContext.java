package it.unipv.ingsfw.treninordovest.strategy.pagamento;

public class PagamentoContext {
    private IPagamentoStrategy pagamentoStrategy;


    public void setStrategy(IPagamentoStrategy strategy) {
        this.pagamentoStrategy = strategy;
    }

    public boolean paga(double amount) {
        if (pagamentoStrategy == null) throw new IllegalStateException("Strategia non impostata");
        return pagamentoStrategy.paga(amount);
    }

    public String getStrategyType() {
        return pagamentoStrategy.getTipo();
    }



}
