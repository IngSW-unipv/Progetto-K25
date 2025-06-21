package it.unipv.ingsfw.treninordovest.model.titoli.pagamento;

import it.unipv.ingsfw.treninordovest.model.varie.GeneraID;

import java.time.LocalDate;
import java.util.UUID;

public class Pagamento {

    private UUID idPagamento;
    private double totale;
    private String tipo;
    private LocalDate dataPagamento;

    public Pagamento() {}

    public Pagamento(double totale, String tipo) {
        this.idPagamento = UUID.randomUUID();
        this.totale = totale;
        this.tipo = tipo;
        this.dataPagamento = LocalDate.now();
    }

    public Pagamento(UUID uuid, double totale, String tipo, LocalDate dataPagamento) {
        this.idPagamento = uuid;
        this.totale = totale;
        this.tipo = tipo;
        this.dataPagamento = dataPagamento;
    }


    public UUID getIdPagamento() {
        return idPagamento;
    }

    public double getTotale() {
        return totale;
    }

    public String getTipo() {
        return tipo;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }
}
