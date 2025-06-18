package it.unipv.ingsfw.treninordovest.strategy.pagamento;

import it.unipv.ingsfw.treninordovest.model.titoli.pagamento.Pagamento;

import java.time.LocalDate;
import java.util.UUID;

public class PagamentoBigliettoStrategy implements IPagamentoTitoliStrategy {
    @Override
    public Pagamento generaPagamento(String idCliente, int numeroTitoli, double prezzoUnitario ,String tipoPagamento) {

        double prezzo = getTotalPagamento(numeroTitoli,prezzoUnitario);

        return new Pagamento(UUID.randomUUID(),prezzo,tipoPagamento, LocalDate.now());

    }


    private double getTotalPagamento(double numeroTitoli, double prezzoUnitario) {
        return prezzoUnitario*numeroTitoli;
    }


}
