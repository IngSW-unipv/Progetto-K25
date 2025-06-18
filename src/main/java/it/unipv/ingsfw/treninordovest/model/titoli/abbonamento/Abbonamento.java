package it.unipv.ingsfw.treninordovest.model.titoli.abbonamento;

import it.unipv.ingsfw.treninordovest.model.titoli.titoloviaggio.TitoloViaggio;

import java.time.LocalDate;
import java.util.UUID;


public class Abbonamento extends TitoloViaggio {
    //Attributi
    private String tipoAbbonamento;
    private LocalDate scadenza;

    //Costruttore Vuoto
    public Abbonamento() {
        super();
    }


    public Abbonamento(UUID id, LocalDate emissione, double prezzo, String tipoAbbonamento, LocalDate scadenza) {
        super(id, emissione, prezzo);
        this.tipoAbbonamento = tipoAbbonamento;
        this.scadenza = scadenza;
    }


    public String getTipoAbbonamento() {
        return tipoAbbonamento;
    }

    public void setTipoAbbonamento(String tipoAbbonamento) {
        this.tipoAbbonamento = tipoAbbonamento;
    }

    public LocalDate getScadenza() {
        return scadenza;
    }

    public void setScadenza(LocalDate scadenza) {
        this.scadenza = scadenza;
    }




}
//getters e setters




