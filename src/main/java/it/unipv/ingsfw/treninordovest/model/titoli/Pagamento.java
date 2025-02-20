package it.unipv.ingsfw.treninordovest.model.titoli;

import java.time.Instant;
import java.time.LocalDate;

public class Pagamento {

    //Attributi
    private String idPagamento;
    private double totale;
    private String idCliente;
    private String idTitolo;
    private String Tipo;
    private LocalDate dataPagamento;

    //Costruttore vuoto
    public Pagamento() {
    }

    public Pagamento(String idPagamento, String idCliente, double totale, String idTitolo, String tipo, LocalDate dataPagamento) {
        this.idPagamento = idPagamento;
        this.idCliente = idCliente;
        this.totale = totale;
        this.idTitolo = idTitolo;
        Tipo = tipo;
        this.dataPagamento = dataPagamento;
    }

    //Getters e setters

    public String getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(String idPagamento) {
        this.idPagamento = idPagamento;
    }

    public double getTotale() {
        return totale;
    }

    public void setTotale(double totale) {
        this.totale = totale;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getIdTitolo() {
        return idTitolo;
    }

    public void setIdTitolo(String idTitolo) {
        this.idTitolo = idTitolo;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}
