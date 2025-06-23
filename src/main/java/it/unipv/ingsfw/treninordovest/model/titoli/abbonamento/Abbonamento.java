package it.unipv.ingsfw.treninordovest.model.titoli.abbonamento;

import it.unipv.ingsfw.treninordovest.model.titoli.tessera.Tessera;
import it.unipv.ingsfw.treninordovest.model.titoli.titoloviaggio.TitoloViaggio;

import java.time.LocalDate;
import java.util.UUID;


public class Abbonamento extends TitoloViaggio {
    //Attributi
    private String tipoAbbonamento;
    private LocalDate scadenza;
    private Tessera tessera;

    //Costruttore Vuoto
    public Abbonamento() {
        super();
    }


    public Abbonamento(UUID id, LocalDate emissione, double prezzo, String tipoAbbonamento, LocalDate scadenza, Tessera tessera) {
        super(id, emissione, prezzo);
        this.tipoAbbonamento = tipoAbbonamento;
        this.scadenza = scadenza;
        this.tessera = tessera;
    }

    public Abbonamento(String id){
        this.setId(id);
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

    public Tessera getTessera() {
        return tessera;
    }

    public void setTessera(Tessera tessera) {
        this.tessera = tessera;
    }


}
//getters e setters




