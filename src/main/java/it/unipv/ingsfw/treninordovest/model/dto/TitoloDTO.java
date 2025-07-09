package it.unipv.ingsfw.treninordovest.model.dto;

import java.time.LocalDate;

public class TitoloDTO {
    private final String tipoTitolo;
    private final String tipoPagamento;
    private final int quantita;
    private String idViaggio;
    boolean ritorno;
    private LocalDate dataRitorno;


    //Per biglietto
    public TitoloDTO(String tipoTitolo, String tipoPagamento, int quantita, String idViaggio, boolean ritorno, LocalDate dataRitorno) {
        this.tipoPagamento = tipoPagamento;
        this.quantita = quantita;
        this.idViaggio = idViaggio;
        this.ritorno = ritorno;
        this.dataRitorno = dataRitorno;
        this.tipoTitolo = tipoTitolo;
    }

    //Per Abbonamento

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

    public boolean isRitorno() {
        return ritorno;
    }

    public LocalDate getDataRitorno() {
        return dataRitorno;
    }
}
