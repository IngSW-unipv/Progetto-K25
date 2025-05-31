package it.unipv.ingsfw.treninordovest.model.titoli;

import java.time.LocalDate;



public class Abbonamento extends TitoloViaggio {
    //Attributi
    private String tipoAbbonamento;
    private LocalDate scadenza;
    private String idTessera;

    //Costruttore Vuoto
    public Abbonamento() {
        super();
    }

    public Abbonamento(String id, String idPagamento, LocalDate emissione, double prezzo, String tipoAbbonamento, LocalDate scadenza, String idTessera) {
        super(id, idPagamento, emissione, prezzo);
        this.tipoAbbonamento = tipoAbbonamento;
        this.scadenza = scadenza;
        this.idTessera = idTessera;
    }


    public String getTipoAbbonamento() {
        return tipoAbbonamento;
    }

    public void setTipoAbbonamento(String tipoAbbonamento) {
        this.tipoAbbonamento = tipoAbbonamento;
    }

    public LocalDate getScadenza() {
        return scadenza;
    }

    public void setScadenza(LocalDate scadenza) {
        this.scadenza = scadenza;
    }

    public String getIdTessera() {
        return idTessera;
    }

    public void setIdTessera(String idTessera) {
        this.idTessera = idTessera;
    }



}
//getters e setters




