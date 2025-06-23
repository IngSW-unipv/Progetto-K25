package it.unipv.ingsfw.treninordovest.service;


import it.unipv.ingsfw.treninordovest.model.strategy.ordine.Sale;
import it.unipv.ingsfw.treninordovest.model.strategy.ordine.SaleLineItem;
import it.unipv.ingsfw.treninordovest.model.strategy.pagamento.PagamentoContext;
import it.unipv.ingsfw.treninordovest.model.titoli.pagamento.Pagamento;
import it.unipv.ingsfw.treninordovest.model.titoli.pagamento.PagamentoDAOImpl;
import it.unipv.ingsfw.treninordovest.model.utenti.cliente.Cliente;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;

public class PagamentoService {
    private PagamentoDAOImpl pagamentoDAO;

    public PagamentoService() {
        this.pagamentoDAO=new PagamentoDAOImpl();

    }


    public Pagamento effettuaPagamento(String tipoPagamento,int quantita,double prezzo) {

        //Impostazione delle mie variabili
        Cliente clienteLoggato = (Cliente) SessionManager.getInstance().getCurrentUser();
        Pagamento pagamento = null;

        Sale vendita = new Sale();
        vendita.addItem(new SaleLineItem(quantita, prezzo));

        PagamentoContext pagamentoContext = new PagamentoContext(tipoPagamento);




        if (vendita.paga(pagamentoContext)){

            pagamento = vendita.getPagamento();
            pagamento.setCliente(clienteLoggato);
            pagamentoDAO.insert(pagamento);

            System.out.println("Pagamento effettuato");
            System.out.println("Dettagli: " + pagamento.getIdPagamento() + " Tipo" +pagamento.getTipo());

            return pagamento;

        }


        return pagamento;

    }


}
