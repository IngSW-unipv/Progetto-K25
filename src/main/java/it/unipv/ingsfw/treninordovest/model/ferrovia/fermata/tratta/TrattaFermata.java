package it.unipv.ingsfw.treninordovest.model.ferrovia.fermata.tratta;

import it.unipv.ingsfw.treninordovest.model.ferrovia.fermata.Fermata;
import it.unipv.ingsfw.treninordovest.model.ferrovia.tratta.Tratta;

import java.time.LocalTime;

public class TrattaFermata {
    //Attributi
    private Fermata fermata;
    private Tratta tratta;
    private int numOrdine;
    private int binario;
    private LocalTime oraPartenza;
    private LocalTime oraArrivo;

    //Costruttori
    public TrattaFermata() {}

    public TrattaFermata(String idFermata, int numOrdine, String idTratta, LocalTime oraPartenza, LocalTime oraArrivo, int binario) {
        //this.idFermata = idFermata;
        this.numOrdine = numOrdine;
        //this.idTratta = idTratta;
        this.oraPartenza = oraPartenza;
        this.oraArrivo = oraArrivo;
        this.binario = binario;
    }


    public int getNumOrdine() {
        return numOrdine;
    }

    public void setNumOrdine(int numOrdine) {
        this.numOrdine = numOrdine;
    }

    public LocalTime getOraArrivo() {
        return oraArrivo;
    }

    public void setOraArrivo(LocalTime oraArrivo) {
        this.oraArrivo = oraArrivo;
    }

    public LocalTime getOraPartenza() {
        return oraPartenza;
    }

    public void setOraPartenza(LocalTime oraPartenza) {
        this.oraPartenza = oraPartenza;
    }

    public int getBinario() {
        return binario;
    }

    public void setBinario(int binario) {
        this.binario = binario;
    }
}
