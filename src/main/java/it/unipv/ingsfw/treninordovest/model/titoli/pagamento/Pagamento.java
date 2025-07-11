package it.unipv.ingsfw.treninordovest.model.titoli.pagamento;

import it.unipv.ingsfw.treninordovest.model.utenti.cliente.Cliente;
import it.unipv.ingsfw.treninordovest.model.varie.GeneraID;

import java.time.LocalDate;
import java.util.UUID;

public class Pagamento {

    private UUID idPagamento;
    private double totale;
    private String tipo;
    private LocalDate dataPagamento;
    private Cliente cliente;

    public Pagamento() {}

    public Pagamento(double totale, String tipo,Cliente cliente) {
        this.idPagamento = UUID.randomUUID();
        this.totale = totale;
        this.tipo = tipo;
        this.dataPagamento = LocalDate.now();
        this.cliente = cliente;
    }

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

    public Pagamento(String idPagamento) {
        this.idPagamento = UUID.fromString(idPagamento);

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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
