package it.unipv.ingsfw.treninordovest.utils.metodipagamento;

public interface IMetodoPagamento {
    boolean valida();

    boolean processaPagamento(double importo);
}
