package it.unipv.ingsfw.treninordovest.model.utenti;

public class Cliente extends Utente {

    //Attributi
    private double bilancia;
    private String email;

    //Costruttore vuoto
    public Cliente(){
        super();
    };

    //Costruttore completo
    public Cliente(String id, String nome, String cognome, String luogoNascita, String dataNascita, char sesso, String cellulare, String indirizzo, double bilancia, String email) {
        super(id, nome, cognome, luogoNascita, dataNascita, sesso, cellulare, indirizzo);
        this.bilancia = bilancia;
        this.email = email;
    }

    //Getters e Setters

    public double getBilancia() {
        return bilancia;
    }

    public void setBilancia(double bilancia) {
        this.bilancia = bilancia;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
