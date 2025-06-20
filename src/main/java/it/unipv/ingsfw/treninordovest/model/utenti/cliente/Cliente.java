package it.unipv.ingsfw.treninordovest.model.utenti.cliente;


import it.unipv.ingsfw.treninordovest.facade.login.LoginFacade;
import it.unipv.ingsfw.treninordovest.model.utenti.utente.Utente;
import it.unipv.ingsfw.treninordovest.utils.metodipagamento.wallet.EUWallet;

import java.time.LocalDate;
import java.util.UUID;

public class Cliente extends Utente {


    //Attributi
    private final EUWallet bilancio = new EUWallet();
    private String email;

    //Costruttore vuoto
    public Cliente(){
        super();
    }

    //Costruttore completo

    public Cliente(UUID id, String userPassword, String nome, String cognome, String luogoNascita, String sesso, LocalDate dataNascita, String cellulare, String indirizzo, double bilancio, String email) {
        super(id, userPassword, nome, cognome, luogoNascita, sesso, dataNascita, cellulare, indirizzo);
        this.bilancio.setVal(bilancio);
        this.email = email;
    }

    public Cliente(String email,String password){
        this.email = email;
        this.setUserPassword(password);
    }



//Getters e Setters

    public double getBilancio() {
        return bilancio.getValue();
    }

    public void setBilancio(double bilancio) {
        this.bilancio.setVal(bilancio);
    }

    public EUWallet getWallet() {
        return bilancio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    //Metodi di verifica

}
