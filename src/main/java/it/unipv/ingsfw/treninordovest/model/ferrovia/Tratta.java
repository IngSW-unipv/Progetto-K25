package it.unipv.ingsfw.treninordovest.model.ferrovia;

public class Tratta {
    private String idTratta;
    private String nome;
    private int lunghezza;


    //Costruttori
    public Tratta() {}

    public Tratta(String idTratta, String nome, int lunghezza) {
        this.idTratta = idTratta;
        this.nome = nome;
        this.lunghezza = lunghezza;
    }

    public String getIdTratta() {
        return idTratta;
    }

    public void setIdTratta(String idTratta) {
        this.idTratta = idTratta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getLunghezza() {
        return lunghezza;
    }

    public void setLunghezza(int lunghezza) {
        this.lunghezza = lunghezza;
    }
}
