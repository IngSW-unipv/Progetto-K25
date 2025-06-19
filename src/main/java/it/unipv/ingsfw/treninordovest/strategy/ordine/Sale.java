package it.unipv.ingsfw.treninordovest.strategy.ordine;

import it.unipv.ingsfw.treninordovest.model.titoli.pagamento.Pagamento;
import it.unipv.ingsfw.treninordovest.strategy.pagamento.PagamentoContext;

import java.util.ArrayList;
import java.util.List;

public class Sale {
    private List<SaleLineItem> items = new ArrayList<>();
    private Pagamento pagamento;

    public void addItem(SaleLineItem li) {
        items.add(li);
    }

    public double getTotal() {
        return items.stream()
                .mapToDouble(SaleLineItem::getSubtotal)
                .sum();
    }

    public boolean paga(PagamentoContext ctx) {
        double total = getTotal();
        if (ctx.paga(total)) {
            pagamento = new Pagamento(total, ctx.getStrategyType());
            return true;
        }
        return false;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

}
