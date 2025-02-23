package it.unipv.ingsfw.treninordovest.model.titoli;

import java.time.LocalDate;

public class Pagamento {

    private String idPagamento;
    private String idCliente;
    private double totale;
    private String tipo;
    private LocalDate dataPagamento;


    //Costruttore completo

    //Costruttore

    public Pagamento() {}

    public Pagamento(String idPagamento, String idCliente, double totale, String tipo, LocalDate dataPagamento) {
        this.idPagamento = idPagamento;
        this.idCliente = idCliente;
        this.totale = totale;
        this.tipo = tipo;
        this.dataPagamento = dataPagamento;
    }

    public String getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(String idPagamento) {
        this.idPagamento = idPagamento;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public double getTotale() {
        return totale;
    }

    public void setTotale(double totale) {
        this.totale = totale;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}
