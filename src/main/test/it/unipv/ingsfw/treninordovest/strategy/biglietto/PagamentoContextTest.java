package it.unipv.ingsfw.treninordovest.strategy.biglietto;

import it.unipv.ingsfw.treninordovest.model.titoli.pagamento.Pagamento;
import it.unipv.ingsfw.treninordovest.strategy.ordine.Sale;
import it.unipv.ingsfw.treninordovest.strategy.ordine.SaleLineItem;
import it.unipv.ingsfw.treninordovest.strategy.pagamento.PagamentoContext;
import it.unipv.ingsfw.treninordovest.utils.metodipagamento.CartaCredito;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;


public class PagamentoContextTest {

    @Test
    public void testPagamentoContext() {
        Sale order = new Sale();
        order.addItem(new SaleLineItem(2, 50.0));
        order.addItem(new SaleLineItem(2, 50.0));
        order.addItem(new SaleLineItem(2, 50.0));
        order.addItem(new SaleLineItem(1, 75.0));

        PagamentoContext ctx = new PagamentoContext();

        ctx.setStrategy(new CartaCredito("534535",LocalDate.now().plusYears(4),"113"));

        if (order.paga(ctx)) {
            Pagamento p = order.getPagamento();
            System.out.println("Pagamento effettuato: " + p.getTotale() + " con " + p.getTipo());

            System.out.println("Dettagli pagamento -  Tipo: "+p.getTipo()+" ID:"+p.getIdPagamento());

        } else {
            System.out.println("Pagamento fallito!");
        }


    }


}
