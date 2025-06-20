package it.unipv.ingsfw.treninordovest.model.utenti.dipendente;


import it.unipv.ingsfw.treninordovest.model.factory.implementations.StipendioStrategyFactory;
import it.unipv.ingsfw.treninordovest.model.utenti.utente.Utente;
import it.unipv.ingsfw.treninordovest.model.strategy.stipendio.IStipendioStrategy;

import java.time.LocalDate;
import java.util.UUID;

public class Dipendente extends Utente {

   private double stipendio;
   private String ruolo;

   //Costruttore vuoto
    public Dipendente() {
        super();
    }

    public Dipendente(String id , String password) {
        this.setId(UUID.fromString(id));
        this.setUserPassword(password);
    }


    //Costruttore completo

    public Dipendente(UUID id, String userPassword, String nome, String cognome, String luogoNascita, String sesso, LocalDate dataNascita, String cellulare, String indirizzo, double stipendio, String ruolo) {
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


    public static double getStipendioByRuolo(String ruolo) {
        IStipendioStrategy strategy = StipendioStrategyFactory.getStrategy(ruolo);
        return strategy.calcolaStipendio();
    }

    //Metodi vari (se necessari)

}
