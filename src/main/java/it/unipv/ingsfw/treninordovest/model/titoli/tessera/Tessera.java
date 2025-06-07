package it.unipv.ingsfw.treninordovest.model.titoli.tessera;

import java.time.LocalDate;

public class Tessera {
    //Attributi
    private String idTessera;
    private LocalDate emissione;
    private LocalDate Scadenza;

    //Costruttore vuoto
    public Tessera() {}

    //Costruttore completo
    public Tessera(String idTessera, LocalDate emissione, LocalDate scadenza) {
        this.idTessera = idTessera;
        this.emissione = emissione;
        Scadenza = scadenza;
    }

    //Getters Setters
    public String getIdTessera() {
        return idTessera;
    }

    public void setIdTessera(String idTessera) {
        this.idTessera = idTessera;
    }

    public LocalDate getEmissione() {
        return emissione;
    }

    public void setEmissione(LocalDate emissione) {
        this.emissione = emissione;
    }

    public LocalDate getScadenza() {
        return Scadenza;
    }

    public void setScadenza(LocalDate scadenza) {
        Scadenza = scadenza;
    }
}
