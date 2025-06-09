package it.unipv.ingsfw.treninordovest.strategy.pagamento;

import it.unipv.ingsfw.treninordovest.model.titoli.pagamento.Pagamento;
import it.unipv.ingsfw.treninordovest.model.varie.GeneraID;

import java.time.LocalDate;

public class VenditaBigliettoStrategy implements IVenditaTitoliStrategy{
    @Override
    public Pagamento generaPagamento(String idCliente, int numeroTitoli, double prezzoUnitario ,String tipoPagamento) {
        /*GeneraID generaID = new GeneraID("PG");

        double prezzo = getTotalPagamento(numeroTitoli,prezzoUnitario);

        return new Pagamento(generaID.getID(),idCliente,prezzo,tipoPagamento, LocalDate.now());

         */
        return null;
    }


    private double getTotalPagamento(double numeroTitoli, double prezzoUnitario) {
        return prezzoUnitario*numeroTitoli;
    }


}
