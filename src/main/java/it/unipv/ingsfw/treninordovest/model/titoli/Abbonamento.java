package it.unipv.ingsfw.treninordovest.model.titoli;

import java.util.Date;
import java.time.Instant;


public class Abbonamento extends TitoloViaggio{
    //Attributi
    private String tipoAbbonamento;
    private Date scadenza;
    private Instant dataPagamento;
    private String idTessera;

    //Costruttore Vuoto
    public Abbonamento() {
        super();
    }

    public Abbonamento(String id, String idPagamento, Date emissione, double prezzo, String idAbbonamento, String tipoAbbonamento, Date scadenza, Instant dataPagamento, String idTessera) {
        super(id, idPagamento, emissione, prezzo);
        this.tipoAbbonamento = tipoAbbonamento;
        this.scadenza = scadenza;
        this.dataPagamento = dataPagamento;
        this.idTessera = idTessera;
    }

    //getters e setters

    public String getTipoAbbonamento() {
        return tipoAbbonamento;
    }

    public void setTipoAbbonamento(String tipoAbbonamento) {
        this.tipoAbbonamento = tipoAbbonamento;
    }

    public Date getScadenza() {
        return scadenza;
    }

    public void setScadenza(Date scadenza) {
        this.scadenza = scadenza;
    }

    public Instant getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(Instant dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public String getIdTessera() {
        return idTessera;
    }

    public void setIdTessera(String idTessera) {
        this.idTessera = idTessera;
    }
}
