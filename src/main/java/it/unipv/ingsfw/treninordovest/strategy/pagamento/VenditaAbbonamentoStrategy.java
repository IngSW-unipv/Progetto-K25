package it.unipv.ingsfw.treninordovest.strategy.pagamento;

import it.unipv.ingsfw.treninordovest.factory.implementations.MetodoPagamentoFactory;
import it.unipv.ingsfw.treninordovest.model.titoli.pagamento.Pagamento;
import it.unipv.ingsfw.treninordovest.model.varie.GeneraID;
import it.unipv.ingsfw.treninordovest.utils.metodipagamento.IMetodoPagamento;

import java.time.LocalDate;

public class VenditaAbbonamentoStrategy implements IVenditaTitoliStrategy{
    @Override
    public Pagamento generaPagamento(String idCliente, int numeroTitoli, double prezzoUnitario,String tipoPagamento) {
        GeneraID generaID = new GeneraID("PG");

        IMetodoPagamento metodoPagamento = MetodoPagamentoFactory.getFactoryFromProperties(tipoPagamento);
        double importo = getTotalPagamento(numeroTitoli, prezzoUnitario);

        metodoPagamento.processaPagamento(importo);

        return new Pagamento(generaID.getID(),idCliente,importo,tipoPagamento, LocalDate.now());
    }


    private double getTotalPagamento(int numeroTitoli,double prezzoUnitario) {
        if (numeroTitoli == 0) {
            return numeroTitoli=1;
        }
        return numeroTitoli*prezzoUnitario;
    }
}
