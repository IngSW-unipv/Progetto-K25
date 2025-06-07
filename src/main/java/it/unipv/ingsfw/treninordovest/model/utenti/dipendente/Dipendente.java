package it.unipv.ingsfw.treninordovest.model.utenti.dipendente;


import it.unipv.ingsfw.treninordovest.model.utenti.utente.Utente;

import java.time.LocalDate;

public class Dipendente extends Utente {

   private double stipendio;
   private String ruolo;

   //Costruttore vuoto
    public Dipendente() {
        super();
    }

    //Costruttore completo

    public Dipendente(String id, String userPassword, String nome, String cognome, String luogoNascita, String sesso, LocalDate dataNascita, String cellulare, String indirizzo, String codTreno, double stipendio, String ruolo) {
        super(id, userPassword, nome, cognome, luogoNascita, sesso, dataNascita, cellulare, indirizzo);
        this.stipendio = stipendio;
        this.ruolo = ruolo;
    }


    //Getters e setters

    public double getStipendio() {
        return stipendio;
    }

    public void setStipendio(double stipendio) {
        this.stipendio = stipendio;
    }

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }


    //Metodi vari (se necessari)

}
