package it.unipv.ingsfw.treninordovest.strategy.pagamento;

public class PagamentoBigliettoStrategy implements IPagamentoStrategy {

    @Override
    public boolean paga(double prezzo) {

        return false;
    }

    @Override
    public String getTipo() {
        return "";
    }
}
