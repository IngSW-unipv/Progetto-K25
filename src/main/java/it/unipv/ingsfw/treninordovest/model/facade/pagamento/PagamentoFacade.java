package it.unipv.ingsfw.treninordovest.model.facade.pagamento;

import it.unipv.ingsfw.treninordovest.model.titoli.pagamento.Pagamento;
import it.unipv.ingsfw.treninordovest.model.service.PagamentoService;


public class PagamentoFacade implements IPagamentoFacade {

    private PagamentoService pagamentoService;

    public PagamentoFacade() {
        this.pagamentoService=new PagamentoService();
    }

    @Override
    public Pagamento generaPagamento(String tipoPagamento,int quantita,double prezzo) {
        return pagamentoService.effettuaPagamento(tipoPagamento,quantita,prezzo);
    }



}
