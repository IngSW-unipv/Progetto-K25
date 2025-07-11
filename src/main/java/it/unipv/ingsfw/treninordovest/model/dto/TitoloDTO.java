package it.unipv.ingsfw.treninordovest.model.dto;

import java.time.LocalDate;
import java.util.UUID;

public class TitoloDTO {
    private  String tipoTitolo;
    private  String tipoPagamento;
    private  int quantita;
    private  String idViaggio;
    private UUID idTitolo;

    //Per Acquisto Abbonamento
    public TitoloDTO(String tipoTitolo, String tipoPagamento, int quantita) {
        this.tipoPagamento = tipoPagamento;
        this.quantita = quantita;
        this.tipoTitolo = tipoTitolo;
    }

    public TitoloDTO(String tipoBiglietto, String tipoPagamento, int quantita, String idTratta) {
        this.tipoPagamento = tipoPagamento;
        this.quantita = quantita;
        this.tipoTitolo = tipoBiglietto;
        this.idViaggio = idTratta;
    }

    //Per validazione
    public TitoloDTO (String id , String tipoTitolo){
        this.idTitolo = UUID.fromString(id);
        this.tipoTitolo=tipoTitolo;
    }


    public String getTipoTitolo() {
        return tipoTitolo;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public int getQuantita() {
        return quantita;
    }

    public String getIdViaggio() {
        return idViaggio;
    }

    public UUID getId() {
        return idTitolo;
    }
}
