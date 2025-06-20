package it.unipv.ingsfw.treninordovest.strategy.biglietto;

import it.unipv.ingsfw.treninordovest.model.titoli.pagamento.Pagamento;
import it.unipv.ingsfw.treninordovest.model.titoli.pagamento.PagamentoDAOImpl;
import it.unipv.ingsfw.treninordovest.model.strategy.ordine.Sale;
import it.unipv.ingsfw.treninordovest.model.strategy.ordine.SaleLineItem;
import it.unipv.ingsfw.treninordovest.model.strategy.pagamento.PagamentoContext;
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

        String payPal = "PayPal";
        String cartaCredito = "CartaCredito";

        PagamentoContext ctx = new PagamentoContext(payPal);

        String idCliente= "32e4e573-8a97-4dc2-a9bd-71c770f59360";

        if (order.paga(ctx)) {
            Pagamento p = order.getPagamento();

            new PagamentoDAOImpl().insertPagamento(p,idCliente);

            System.out.println("Pagamento effettuato: " + p.getTotale() + " con " + p.getTipo());

            System.out.println("Dettagli pagamento -  Tipo: "+p.getTipo()+" ID:"+p.getIdPagamento());

        } else {
            System.out.println("Pagamento fallito!");
        }


    }


}
