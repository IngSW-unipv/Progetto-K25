package it.unipv.ingsfw.treninordovest.model.utenti;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utente {

    /*Attributi della classe*/
    private String id;
    private String userPassword;
    private String nome;
    private String cognome;
    private String luogoNascita;
    private LocalDate dataNascita;
    private String sesso;
    private String cellulare;
    private String indirizzo;


    /*Costruttore classe*/

    public Utente() { //Costruttore vuoto
    }

    //Costruttore completo


    public Utente(String id, String userPassword, String nome, String cognome, String luogoNascita, String sesso, LocalDate dataNascita, String cellulare, String indirizzo) {
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

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public String getSesso() {
        return sesso;
    }

    public void setSesso(String sesso) {
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

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    //Metodi vari


    @Override
    public String toString() {
        return "Utente{" +
                "id='" + id + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", luogoNascita='" + luogoNascita + '\'' +
                ", dataNascita=" + dataNascita +
                ", sesso=" + sesso +
                ", cellulare='" + cellulare + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                '}';
    }
}
