package it.unipv.ingsfw.treninordovest.model.utenti;

import java.util.Date;

public class Utente {

    /*Attributi della classe*/
    private String id;
    private String userPassword;
    private String nome;
    private String cognome;
    private String luogoNascita;
    private Date dataNascita;
    private char sesso;
    private String cellulare;
    private String indirizzo;


    /*Costruttore classe*/

    public Utente() { //Costruttore vuoto
    }

    //Costruttore completo


    public Utente(String id, String userPassword, String nome, String cognome, String luogoNascita, char sesso, Date dataNascita, String cellulare, String indirizzo) {
        this.id = id;
        this.userPassword = userPassword;
        this.nome = nome;
        this.cognome = cognome;
        this.luogoNascita = luogoNascita;
        this.sesso = sesso;
        this.dataNascita = dataNascita;
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

    public Date getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(Date dataNascita) {
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
