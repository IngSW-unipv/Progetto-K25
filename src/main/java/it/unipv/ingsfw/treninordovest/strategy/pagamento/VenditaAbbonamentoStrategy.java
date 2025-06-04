package it.unipv.ingsfw.treninordovest.strategy.pagamento;

import it.unipv.ingsfw.treninordovest.factory.implementations.AbbonamentoStrategyFactory;
import it.unipv.ingsfw.treninordovest.model.titoli.Pagamento;
import it.unipv.ingsfw.treninordovest.strategy.abbonamento.IAbbonamentoStrategy;

import java.util.List;

public class VenditaAbbonamentoStrategy implements IVenditaTitoliStrategy{
    @Override
    public Pagamento generaPagamento(String idCliente,double numeroTitoli) {
        return null;
    }

    @Override
    public double getTotalPagamento() {


        return 0;
    }
}
