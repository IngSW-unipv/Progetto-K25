package it.unipv.ingsfw.treninordovest.model.titoli;

import java.time.Instant;

public class Rimborso {

    //Attributi
    private String idRimborso;
    private Instant dataOra;
    private double totale;
    private String idBiglietto;
    private String idRichiedente;

    //Costruttori
    public Rimborso() {}

    public Rimborso(String idRimborso, Instant dataOra, double totale, String idBiglietto, String idRichiedente) {
        this.idRimborso = idRimborso;
        this.dataOra = dataOra;
        this.totale = totale;
        this.idBiglietto = idBiglietto;
        this.idRichiedente = idRichiedente;
    }

    //Getters e Setters
    public String getIdRimborso() {
        return idRimborso;
    }

    public void setIdRimborso(String idRimborso) {
        this.idRimborso = idRimborso;
    }

    public Instant getDataOra() {
        return dataOra;
    }

    public void setDataOra(Instant dataOra) {
        this.dataOra = dataOra;
    }

    public double getTotale() {
        return totale;
    }

    public void setTotale(double totale) {
        this.totale = totale;
    }

    public String getIdBiglietto() {
        return idBiglietto;
    }

    public void setIdBiglietto(String idBiglietto) {
        this.idBiglietto = idBiglietto;
    }

    public String getIdRichiedente() {
        return idRichiedente;
    }

    public void setIdRichiedente(String idRichiedente) {
        this.idRichiedente = idRichiedente;
    }
}
