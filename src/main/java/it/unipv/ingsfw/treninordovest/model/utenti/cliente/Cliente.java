package it.unipv.ingsfw.treninordovest.model.utenti.cliente;


import it.unipv.ingsfw.treninordovest.facade.login.ILoginFacade;
import it.unipv.ingsfw.treninordovest.facade.login.LoginFacade;
import it.unipv.ingsfw.treninordovest.model.factory.login.ILogin;
import it.unipv.ingsfw.treninordovest.model.factory.login.LoginFactoryProducer;
import it.unipv.ingsfw.treninordovest.model.titoli.tessera.Tessera;
import it.unipv.ingsfw.treninordovest.model.utenti.utente.Utente;
import it.unipv.ingsfw.treninordovest.utils.metodipagamento.wallet.EUWallet;

import java.time.LocalDate;
import java.util.UUID;

public class Cliente extends Utente {


    //Attributi
    private final EUWallet bilancio = new EUWallet();
    private String email;
    private Tessera tessera;

    //Costruttore vuoto
    public Cliente(){
        super();
    }

    //Costruttore completo

    public Cliente(UUID id, String userPassword, String nome, String cognome, String luogoNascita, String sesso, LocalDate dataNascita, String cellulare, String indirizzo, double bilancio, String email, Tessera tessera) {
        super(id, userPassword, nome, cognome, luogoNascita, sesso, dataNascita, cellulare, indirizzo);
        this.bilancio.setVal(bilancio);
        this.email = email;
        this.tessera = tessera;
    }

    public Cliente(String email,String password){
        this.email = email;
        this.setUserPassword(password);
    }

    public Cliente (String id){
        this.setId(UUID.fromString(id));
    }

    public Cliente(UUID id, String userPassword, String nome, String cognome, String luogoNascita, String sesso, LocalDate dataNascita, String cellulare, String indirizzo, double bilancio, String email ) {
        super(id, userPassword, nome, cognome, luogoNascita, sesso, dataNascita, cellulare, indirizzo);
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


    //Da vedere
    public boolean login(String email, String password){
       LoginFactoryProducer loginFactoryProducer = new LoginFactoryProducer();
       ILogin loginn = loginFactoryProducer.getFactoryFromProperties("cliente");
       loginn.login(email, password);
       return true;
    }

    public Tessera getTessera() {
        return tessera;
    }

    public void setTessera(Tessera tessera) {
        this.tessera = tessera;
    }




    //Metodi di verifica

}
