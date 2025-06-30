package it.unipv.ingsfw.treninordovest.model.titoli.biglietto;

import it.unipv.ingsfw.treninordovest.model.ferrovia.viaggio.Viaggio;
import it.unipv.ingsfw.treninordovest.model.titoli.titoloviaggio.TitoloViaggio;

import java.time.LocalDate;
import java.util.UUID;


public class Biglietto extends TitoloViaggio {
    //Attributi
    private boolean validato;
    private LocalDate dataValidazione;
    private String tipoBiglietto;
    private Viaggio viaggio;

    //Costruttore vuoto
    public Biglietto() {}

    //Costruttore completo
    public Biglietto(UUID id, LocalDate emissione, double prezzo, boolean validato, String tipoBiglietto) {
        super(id, emissione, prezzo);
        this.validato = validato;
        this.tipoBiglietto = tipoBiglietto;
    }


    public Biglietto(UUID id, LocalDate emissione, double prezzo, boolean validato,Viaggio viaggio) {
        super(id, emissione, prezzo);
        this.validato = validato;
        this.viaggio = viaggio;
    }




    //Getters e setters
    public boolean isValidato() {
        return validato;
    }

    public void setValidato(boolean validato) {
        this.validato = validato;
    }

    public LocalDate getDataValidazione() {
        return dataValidazione;
    }

    public void setDataValidazione(LocalDate dataValidazione) {
        this.dataValidazione = dataValidazione;
    }

    public void setViaggio(Viaggio viaggio) {
        this.viaggio = viaggio;
    }

    public void setTipoBiglietto(String tipoBiglietto) {
        this.tipoBiglietto = tipoBiglietto;
    }

    public Viaggio getViaggio() {
        return viaggio;
    }

    public String getTipoBiglietto() {
        return tipoBiglietto;
    }
}
