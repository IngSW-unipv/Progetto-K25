package it.unipv.ingsfw.treninordovest.strategy.pagamento;

import it.unipv.ingsfw.treninordovest.factory.implementations.AbbonamentoStrategyFactory;
import it.unipv.ingsfw.treninordovest.model.titoli.Abbonamento;
import it.unipv.ingsfw.treninordovest.model.titoli.Biglietto;
import it.unipv.ingsfw.treninordovest.model.titoli.Pagamento;
import it.unipv.ingsfw.treninordovest.model.titoli.TitoloViaggio;
import it.unipv.ingsfw.treninordovest.model.varie.GeneraID;
import it.unipv.ingsfw.treninordovest.strategy.abbonamento.IAbbonamentoStrategy;

import java.util.List;

public class VenditaAbbonamentoStrategy implements IVenditaTitoliStrategy{
    @Override
    public Pagamento generaPagamento(String idCliente, int numeroTitoli, double prezzoUnitario,String tipoPagamento) {
        GeneraID generaID = new GeneraID("PG");

        double prezzo = getTotalPagamento(numeroTitoli, prezzoUnitario);

        return new Pagamento(generaID.getID(),idCliente,prezzo,tipoPagamento, LocalDate.now());
    }


    private double getTotalPagamento(int numeroTitoli,double prezzoUnitario) {
        if (numeroTitoli == 0) {
            return numeroTitoli=1;
        }
        return numeroTitoli*prezzoUnitario;
    }
}
