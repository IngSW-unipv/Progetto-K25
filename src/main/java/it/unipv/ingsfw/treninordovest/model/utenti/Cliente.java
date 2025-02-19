package it.unipv.ingsfw.treninordovest.model.utenti;

import java.util.Date;

public class Cliente extends Utente {

    //Attributi
    private double bilancio;
    private String email;

    //Costruttore vuoto
    public Cliente(){
        super();
    };

    //Costruttore completo

    public Cliente(String id, String userPassword, String nome, String cognome, String luogoNascita, char sesso, Date dataNascita, String cellulare, String indirizzo, double bilancio, String email) {
        super(id, userPassword, nome, cognome, luogoNascita, sesso, dataNascita, cellulare, indirizzo);
        this.bilancio = bilancio;
        this.email = email;
    }
//Getters e Setters

    public double getBilancio() {
        return bilancio;
    }

    public void setBilancio(double bilancio) {
        this.bilancio = bilancio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
