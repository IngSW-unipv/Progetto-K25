package it.unipv.ingsfw.treninordovest.model.ferrovia;

import java.sql.Time;

public class TrattaFermata {
    //Attributi
    private String idFermata;
    private String idTratta;
    private int numOrdine;
    private int binario;
    private Time oraPartenza;
    private Time oraArrivo;

    //Costruttori
    public TrattaFermata() {}

    public TrattaFermata(String idFermata, int numOrdine, String idTratta, Time oraPartenza, Time oraArrivo, int binario) {
        this.idFermata = idFermata;
        this.numOrdine = numOrdine;
        this.idTratta = idTratta;
        this.oraPartenza = oraPartenza;
        this.oraArrivo = oraArrivo;
        this.binario = binario;
    }

    public String getIdFermata() {
        return idFermata;
    }

    public void setIdFermata(String idFermata) {
        this.idFermata = idFermata;
    }

    public String getIdTratta() {
        return idTratta;
    }

    public void setIdTratta(String idTratta) {
        this.idTratta = idTratta;
    }

    public int getNumOrdine() {
        return numOrdine;
    }

    public void setNumOrdine(int numOrdine) {
        this.numOrdine = numOrdine;
    }

    public Time getOraArrivo() {
        return oraArrivo;
    }

    public void setOraArrivo(Time oraArrivo) {
        this.oraArrivo = oraArrivo;
    }

    public Time getOraPartenza() {
        return oraPartenza;
    }

    public void setOraPartenza(Time oraPartenza) {
        this.oraPartenza = oraPartenza;
    }

    public int getBinario() {
        return binario;
    }

    public void setBinario(int binario) {
        this.binario = binario;
    }
}
