package it.unipv.ingsfw.treninordovest.model.titoli.titoloviaggio;

import java.time.LocalDate;

public abstract class TitoloViaggio {
    private String id;
    private LocalDate emissione;
    private double prezzo;

    //Costruttore vuoto
    public TitoloViaggio() {}

    //Costruttore completo
    public TitoloViaggio(String id, LocalDate emissione, double prezzo) {
        this.id = id;
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
