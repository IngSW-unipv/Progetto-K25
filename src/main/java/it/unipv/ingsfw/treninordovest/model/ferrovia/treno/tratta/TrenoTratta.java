package it.unipv.ingsfw.treninordovest.model.ferrovia.treno.tratta;

public class TrenoTratta {

    private String idTratta;
    private String idTreno;
    private int numeroTreno;

    //Costruttore
    public TrenoTratta() {}

    //Costruttore completo
    public TrenoTratta(String idTratta, String idTreno, int numeroTreno) {
        this.idTratta = idTratta;
        this.idTreno = idTreno;
        this.numeroTreno = numeroTreno;
    }

    //Getters e Setters
    public String getIdTratta() {
        return idTratta;
    }

    public void setIdTratta(String idTratta) {
        this.idTratta = idTratta;
    }

    public String getIdTreno() {
        return idTreno;
    }

    public void setIdTreno(String idTreno) {
        this.idTreno = idTreno;
    }

    public int getNumeroTreno() {
        return numeroTreno;
    }

    public void setNumeroTreno(int numeroTreno) {
        this.numeroTreno = numeroTreno;
    }


}
