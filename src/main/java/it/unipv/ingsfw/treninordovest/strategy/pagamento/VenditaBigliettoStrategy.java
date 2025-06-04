package it.unipv.ingsfw.treninordovest.strategy.pagamento;

import it.unipv.ingsfw.treninordovest.model.titoli.Pagamento;
import it.unipv.ingsfw.treninordovest.model.varie.GeneraID;

import java.time.LocalDate;
import java.util.List;

public class VenditaBigliettoStrategy implements IVenditaTitoliStrategy{
    @Override
    public Pagamento generaPagamento(String idCliente,double numeroTitoli) {
        GeneraID generaID = new GeneraID("PG");

        return new Pagamento(generaID.getID(),idCliente,0,"test", LocalDate.now());
    }

    @Override
    public double getTotalPagamento() {
        double total = 0;




        return 0;
    }


}
