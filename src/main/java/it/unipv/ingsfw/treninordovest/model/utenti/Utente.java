package it.unipv.ingsfw.treninordovest.model.utenti;

public class Utente {

    /*Attributi della classe*/
    private String id;
    private String nome;
    private String cognome;
    private String luogoNascita;
    private String dataNascita;
    private char sesso;
    private String cellulare;
    private String indirizzo;


    /*Costruttore classe*/

    public Utente() { //Costruttore vuoto
    }

    //Costruttore completo
    public Utente(String id, String nome, String cognome, String luogoNascita, String dataNascita, char sesso, String cellulare, String indirizzo) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.luogoNascita = luogoNascita;
        this.dataNascita = dataNascita;
        this.sesso = sesso;
        this.cellulare = cellulare;
        this.indirizzo = indirizzo;
    }

    //Getters e setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLuogoNascita() {
        return luogoNascita;
    }

    public void setLuogoNascita(String luogoNascita) {
        this.luogoNascita = luogoNascita;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(String dataNascita) {
        this.dataNascita = dataNascita;
    }

    public char getSesso() {
        return sesso;
    }

    public void setSesso(char sesso) {
        this.sesso = sesso;
    }

    public String getCellulare() {
        return cellulare;
    }

    public void setCellulare(String cellulare) {
        this.cellulare = cellulare;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    //Metodi vari


}
