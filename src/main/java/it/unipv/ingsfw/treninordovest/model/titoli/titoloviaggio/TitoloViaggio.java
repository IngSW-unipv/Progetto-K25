package it.unipv.ingsfw.treninordovest.model.titoli.titoloviaggio;

import java.time.LocalDate;
import java.util.UUID;

public abstract class TitoloViaggio {
    private UUID id;
    private LocalDate emissione;
    private double prezzo;

    //Costruttore vuoto
    public TitoloViaggio() {}

    //Costruttore completo
    public TitoloViaggio(UUID id, LocalDate emissione, double prezzo) {
        this.id = id;
        this.emissione = emissione;
        this.prezzo = prezzo;
    }

    //Getters e Setters
    public UUID getId() {
        return id;
    }

    public void setId(String id) {
        this.id = UUID.fromString(id);
    }

    public LocalDate getEmissione() {
        return emissione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }
}
