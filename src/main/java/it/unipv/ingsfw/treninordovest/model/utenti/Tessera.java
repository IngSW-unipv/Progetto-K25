package it.unipv.ingsfw.treninordovest.model.utenti;

import java.time.LocalDate;
import java.util.Date;

public class Tessera {
    //Attributi
    private String idTessera;
    private LocalDate emissione;
    private LocalDate Scadenza;
    private String idCliente;

    //Costruttore vuoto
    public Tessera() {}

    //Costruttore completo
    public Tessera(String idTessera, LocalDate emissione, LocalDate scadenza, String idCliente) {
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

    public LocalDate getScadenza() {
        return Scadenza;
    }

    public void setScadenza(Date scadenza) {
        Scadenza = scadenza;
    }
}
