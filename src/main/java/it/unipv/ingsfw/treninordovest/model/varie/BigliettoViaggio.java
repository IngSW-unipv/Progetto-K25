package it.unipv.ingsfw.treninordovest.model.varie;

public class BigliettoViaggio {

    private String idViaggio;
    private String idBigliettoViaggio;

    public BigliettoViaggio(String idViaggio, String idBigliettoViaggio) {
        this.idViaggio = idViaggio;
        this.idBigliettoViaggio = idBigliettoViaggio;
    }

    public String getIdViaggio() {
        return idViaggio;
    }

    public void setIdViaggio(String idViaggio) {
        this.idViaggio = idViaggio;
    }

    public String getIdBigliettoViaggio() {
        return idBigliettoViaggio;
    }

    public void setIdBigliettoViaggio(String idBigliettoViaggio) {
        this.idBigliettoViaggio = idBigliettoViaggio;
    }
}
