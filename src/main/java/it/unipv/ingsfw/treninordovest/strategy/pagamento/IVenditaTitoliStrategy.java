package it.unipv.ingsfw.treninordovest.strategy.pagamento;

import it.unipv.ingsfw.treninordovest.model.titoli.Pagamento;

public interface IVenditaTitoliStrategy {
    Pagamento generaPagamento(String idCliente);

}
