package it.unipv.ingsfw.treninordovest.model.ferrovia;

public class Treno {
    private String idTreno;
    private String modello;
    private int kw;
    private int numPosti;

    //Costruttori

    public Treno (){}

    public Treno(String idTreno, String modello, int kw, int numPosti) {
        this.idTreno = idTreno;
        this.modello = modello;
        this.kw = kw;
        this.numPosti = numPosti;
    }

    public String getIdTreno() {
        return idTreno;
    }

    public void setIdTreno(String idTreno) {
        this.idTreno = idTreno;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public int getKw() {
        return kw;
    }

    public void setKw(int kw) {
        this.kw = kw;
    }

    public int getNumPosti() {
        return numPosti;
    }

    public void setNumPosti(int numPosti) {
        this.numPosti = numPosti;
    }
}
