package it.unipv.ingsfw.treninordovest.model.utenti;


import java.time.LocalDate;

public class Dipendente extends Utente {

   private String codTreno;
   private double stipendio;
   private String ruolo;

   //Costruttore vuoto
    public Dipendente() {
        super();
    }

    //Costruttore completo

    public Dipendente(String id, String userPassword, String nome, String cognome, String luogoNascita, String sesso, LocalDate dataNascita, String cellulare, String indirizzo, String codTreno, double stipendio, String ruolo) {
        super(id, userPassword, nome, cognome, luogoNascita, sesso, dataNascita, cellulare, indirizzo);
        this.codTreno = codTreno;
        this.stipendio = stipendio;
        this.ruolo = ruolo;
    }


    //Getters e setters

    public String getCodTreno() {
        return codTreno;
    }

    public void setCodTreno(String codTreno) {
        this.codTreno = codTreno;
    }

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
