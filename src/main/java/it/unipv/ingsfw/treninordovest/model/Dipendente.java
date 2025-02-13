package it.unipv.ingsfw.treninordovest.model;

public class Dipendente extends Utente {

   private String codTreno;
   private double stipendio;
   private String ruolo;

   //Costruttore vuoto
    public Dipendente() {
        super();
    }

    //Costruttore completo
    public Dipendente(String id, String nome, String cognome, String luogoNascita, String dataNascita, char sesso, String cellulare, String indirizzo, String codTreno, double stipendio, String ruolo) {
        super(id, nome, cognome, luogoNascita, dataNascita, sesso, cellulare, indirizzo);
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
