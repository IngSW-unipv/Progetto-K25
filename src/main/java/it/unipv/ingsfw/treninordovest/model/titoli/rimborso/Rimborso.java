package it.unipv.ingsfw.treninordovest.model.titoli.rimborso;

import java.time.LocalDate;

public class Rimborso {

    //Attributi
    private String idRimborso;
    private LocalDate dataRimborso;
    private double totale;
    private String idBiglietto;
    private String idRichiedente;

    //Costruttori
    public Rimborso() {}

    public Rimborso(String idRimborso, LocalDate dataOra, double totale, String idBiglietto, String idRichiedente) {
        this.idRimborso = idRimborso;
        this.dataRimborso = dataOra;
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

    @Override
    public String toString() {
        return "Rimborso{" +
                "idRimborso='" + idRimborso + '\'' +
                ", dataRimborso=" + dataRimborso +
                ", totale=" + totale +
                ", idBiglietto='" + idBiglietto + '\'' +
                ", idRichiedente='" + idRichiedente + '\'' +
                '}';
    }
}
