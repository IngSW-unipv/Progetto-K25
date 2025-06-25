package it.unipv.ingsfw.treninordovest.model.ferrovia.fermata;

public class Fermata {

    //Attributi
    private String idFermata;
    private String citta;
    private int numBinari;

    //Costruttori
    public Fermata() {}

    public Fermata(String idFermata, String citta, int numBinari) {
        this.idFermata = idFermata;
        this.citta = citta;
        this.numBinari = numBinari;
    }

    public Fermata(String idFermata) {
        this.idFermata = idFermata;
    }


    public String getIdFermata() {
        return idFermata;
    }

    public void setIdFermata(String idFermata) {
        this.idFermata = idFermata;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public int getNumBinari() {
        return numBinari;
    }

    public void setNumBinari(int numBinari) {
        this.numBinari = numBinari;
    }
}
