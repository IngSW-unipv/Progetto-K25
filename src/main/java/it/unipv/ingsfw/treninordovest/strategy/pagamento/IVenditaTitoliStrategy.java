package it.unipv.ingsfw.treninordovest.strategy.pagamento;

import it.unipv.ingsfw.treninordovest.model.titoli.pagamento.Pagamento;

public interface IVenditaTitoliStrategy {
    Pagamento generaPagamento(String idCliente, int numeroTitoli, double prezzoUnitario,String tipoPagamento);



}
