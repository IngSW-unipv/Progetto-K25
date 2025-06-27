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
        this.dataValidazione = dataValidazione;
        this.tipoBiglietto = tipoBiglietto;
    }


    public Biglietto(UUID id, LocalDate emissione, double prezzo, boolean ritorno, boolean validato, LocalDate dataRitorno, LocalDate dataValidazione,Viaggio viaggio) {
        super(id, emissione, prezzo);
        this.validato = validato;
        this.dataValidazione = dataValidazione;
        this.viaggio = viaggio;
    }




    //Getters e setters
    public boolean isValidato() {
        return validato;
    }

    public void setValidato(boolean validato) {
        this.validato = validato;
    }

    public boolean isRitorno() {
        return ritorno;
    }

    public void setRitorno(boolean ritorno) {
        this.ritorno = ritorno;
    }

    public LocalDate getDataRitorno() {
        return dataRitorno;
    }

    public void setDataRitorno(LocalDate dataRitorno) {
        this.dataRitorno = dataRitorno;
    }

    public LocalDate getDataValidazione() {
        return dataValidazione;
    }

    public void setDataValidazione(LocalDate dataValidazione) {
        this.dataValidazione = dataValidazione;
    }


}
