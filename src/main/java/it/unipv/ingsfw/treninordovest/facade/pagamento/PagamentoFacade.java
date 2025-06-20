package it.unipv.ingsfw.treninordovest.facade.pagamento;

import it.unipv.ingsfw.treninordovest.model.titoli.pagamento.Pagamento;
import it.unipv.ingsfw.treninordovest.model.titoli.pagamento.PagamentoDAOImpl;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;

import java.time.LocalDate;
import java.util.UUID;

public class PagamentoFacade implements IPagamentoFacade {

    private PagamentoDAOImpl pagamentoDAO ;

    public PagamentoFacade() {
        pagamentoDAO = new PagamentoDAOImpl();

    }

    @Override
    public boolean generaPagamento(String tipoPagamento) {
        String idClienteLoggato = SessionManager.getInstance().getCurrentUser().getId().toString();

        Pagamento pagamento;

        pagamento= new Pagamento(UUID.randomUUID(),0,tipoPagamento, LocalDate.now());

        pagamentoDAO.insertPagamento(pagamento,idClienteLoggato);

        return false;
    }



}
