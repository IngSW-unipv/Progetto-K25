package it.unipv.ingsfw.treninordovest.model.utenti;

import java.util.Date;

public class Tessera {
    //Attributi
    private String idTessera;
    private Date emissione;
    private Date Scadenza;
    private String idCliente;

    //Costruttore vuoto
    public Tessera() {}

    //Costruttore completo
    public Tessera(String idTessera, Date emissione, Date scadenza, String idCliente) {
        this.idTessera = idTessera;
        this.emissione = emissione;
        Scadenza = scadenza;
        this.idCliente = idCliente;
    }

    //Getters Setters
    public String getIdTessera() {
        return idTessera;
    }

    public void setIdTessera(String idTessera) {
        this.idTessera = idTessera;
    }

    public Date getEmissione() {
        return emissione;
    }

    public void setEmissione(Date emissione) {
        this.emissione = emissione;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public Date getScadenza() {
        return Scadenza;
    }

    public void setScadenza(Date scadenza) {
        Scadenza = scadenza;
    }
}
