package it.unipv.ingsfw.treninordovest.strategy.pagamento;

import it.unipv.ingsfw.treninordovest.model.titoli.Pagamento;

import java.util.List;

public interface IVenditaTitoliStrategy {
    Pagamento generaPagamento(String idCliente,double numeroTitoli);
    double getTotalPagamento();


}
