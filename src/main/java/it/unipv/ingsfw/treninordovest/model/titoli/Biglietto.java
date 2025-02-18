package it.unipv.ingsfw.treninordovest.model.titoli;

import it.unipv.ingsfw.treninordovest.model.ferrovia.Viaggio;

import java.util.Date;

public class Biglietto extends TitoloViaggio {
    //Attributi
    private boolean ritorno;
    private boolean validato;

    //Costruttore vuoto
    public Biglietto() {}

    //Costruttore completo
    public Biglietto(String id, String idPagamento, Date emissione, double prezzo, boolean ritorno, boolean validato) {
        super(id, idPagamento, emissione, prezzo);
        this.ritorno = ritorno;
        this.validato = validato;
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


}
