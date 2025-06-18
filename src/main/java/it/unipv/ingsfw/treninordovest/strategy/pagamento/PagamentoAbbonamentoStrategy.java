package it.unipv.ingsfw.treninordovest.strategy.pagamento;

//import it.unipv.ingsfw.treninordovest.factory.implementations.MetodoPagamentoFactory;
import it.unipv.ingsfw.treninordovest.model.titoli.pagamento.Pagamento;

public class PagamentoAbbonamentoStrategy implements IPagamentoTitoliStrategy {
    @Override
    public Pagamento generaPagamento(String idCliente, int numeroTitoli, double prezzoUnitario,String tipoPagamento) {
      /*  GeneraID generaID = new GeneraID("PG");

       // IMetodoPagamento metodoPagamento = MetodoPagamentoFactory.getFactoryFromProperties(tipoPagamento);
        double importo = getTotalPagamento(numeroTitoli, prezzoUnitario);

       // metodoPagamento.processaPagamento(importo);

        return new Pagamento(generaID.getID(),idCliente,importo,tipoPagamento, LocalDate.now());
    */
        return null;
    }



    private double getTotalPagamento(int numeroTitoli,double prezzoUnitario) {
        /*if (numeroTitoli == 0) {
            return numeroTitoli=1;
        }
        return numeroTitoli*prezzoUnitario;*/
        return 0;
    }
}
