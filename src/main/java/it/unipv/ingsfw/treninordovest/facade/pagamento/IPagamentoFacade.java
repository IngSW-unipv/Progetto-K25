package it.unipv.ingsfw.treninordovest.facade.pagamento;

import it.unipv.ingsfw.treninordovest.model.titoli.pagamento.Pagamento;

public interface IPagamentoFacade {

    boolean generaPagamento(String tipoPagamento);
}
