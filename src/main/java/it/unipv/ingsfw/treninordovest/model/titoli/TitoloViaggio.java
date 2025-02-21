package it.unipv.ingsfw.treninordovest.model.titoli;

import java.time.LocalDate;
import java.util.Date;

public abstract class TitoloViaggio {
    private String id;
    private String idPagamento;
    private LocalDate emissione;
    private double prezzo;

    //Costruttore vuoto
    public TitoloViaggio() {}

    //Costruttore completo
    public TitoloViaggio(String id, String idPagamento, LocalDate emissione, double prezzo) {
        this.id = id;
        this.idPagamento = idPagamento;
        this.emissione = emissione;
        this.prezzo = prezzo;
    }

    //Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(String idPagamento) {
        this.idPagamento = idPagamento;
    }

    public LocalDate getEmissione() {
        return emissione;
    }

    public void setEmissione(LocalDate emissione) {
        this.emissione = emissione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
}
