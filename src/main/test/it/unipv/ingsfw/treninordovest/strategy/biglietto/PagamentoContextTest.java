package it.unipv.ingsfw.treninordovest.strategy.biglietto;

import it.unipv.ingsfw.treninordovest.model.factory.implementations.AbbonamentoStrategyFactory;
import it.unipv.ingsfw.treninordovest.model.strategy.abbonamento.IAbbonamentoStrategy;
import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.Abbonamento;
import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.AbbonamentoDAOimpl;
import it.unipv.ingsfw.treninordovest.model.titoli.pagamento.Pagamento;
import it.unipv.ingsfw.treninordovest.model.strategy.ordine.Sale;
import it.unipv.ingsfw.treninordovest.model.strategy.ordine.SaleLineItem;
import it.unipv.ingsfw.treninordovest.model.strategy.pagamento.PagamentoContext;
import org.junit.jupiter.api.Test;


public class PagamentoContextTest {

    public String testPagamentoContext(String tipoPagamento,int quantita,double prezzo) {
        Sale order = new Sale();
        order.addItem(new SaleLineItem(quantita, prezzo));


        String payPal = "paypal";
        String cartaCredito = "cartacredito";

        PagamentoContext ctx = new PagamentoContext(cartaCredito);
        Pagamento p = null;

        String idCliente= "32e4e573-8a97-4dc2-a9bd-71c770f59360";



        if (order.paga(ctx)) {
             p = order.getPagamento();

            //new PagamentoDAOImpl().insertPagamento(p,idCliente);

            System.out.println("Pagamento effettuato: " + p.getTotale() + " con " + p.getTipo());

            System.out.println("Dettagli pagamento -  Tipo: "+p.getTipo()+" ID:"+p.getIdPagamento());

        } else {
            System.out.println("Pagamento fallito!");
        }

        //Assertions.assertNotNull(p);
        return p.getIdPagamento().toString();

    }


    @Test
    public void testCreazioneAbbonamento() {

        String idCliente= "32e4e573-8a97-4dc2-a9bd-71c770f59360";
        String tipoAbbonamento = "settimanale";
        int quantita = 5;

        IAbbonamentoStrategy abbonamentoStrategy = AbbonamentoStrategyFactory.getFactoryFromProperties(tipoAbbonamento);
        Abbonamento abbonamento;


        String idPagamento= testPagamentoContext(tipoAbbonamento,quantita,abbonamentoStrategy.ottieniPrezzoAbbonamento());
        String idTessera="TS50381";


        AbbonamentoDAOimpl abbonamentoDAOimpl = new AbbonamentoDAOimpl();

        /*
        for(int i =0 ; i<quantita;i++){
            abbonamento = abbonamentoStrategy.createAbbonamento();
            abbonamentoDAOimpl.createAbbonamento(abbonamento,idTessera,idCliente,idPagamento);
        }*/




    }


}
