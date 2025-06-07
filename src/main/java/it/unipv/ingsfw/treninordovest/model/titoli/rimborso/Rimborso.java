package it.unipv.ingsfw.treninordovest.model.titoli.rimborso;

import java.time.LocalDate;

public class Rimborso {

    //Attributi
    private String idRimborso;
    private LocalDate dataRimborso;
    private double totale;

    //Costruttori
    public Rimborso() {}

    public Rimborso(String idRimborso, LocalDate dataOra, double totale) {
        this.idRimborso = idRimborso;
        this.dataRimborso = dataOra;
        this.totale = totale;
    }

    //Getters e Setters
    public String getIdRimborso() {
        return idRimborso;
    }

    public void setIdRimborso(String idRimborso) {
        this.idRimborso = idRimborso;
    }

    public LocalDate getDataRimborso() {
        return dataRimborso;
    }

    public void setDataRimborso(LocalDate dataRimborso) {
        this.dataRimborso = dataRimborso;
    }

    public double getTotale() {
        return totale;
    }

    public void setTotale(double totale) {
        this.totale = totale;
    }


}
