package it.unipv.ingsfw.treninordovest.model.titoli.Abbonamenti;

import java.time.LocalDate;

public class AbbonamentoMensile extends Abbonamento {
    public AbbonamentoMensile(String id, String idPagamento, LocalDate emissione, double prezzo, String tipoAbbonamento, LocalDate scadenza, String idTessera) {
        super(id, idPagamento, emissione, prezzo, tipoAbbonamento, scadenza, idTessera);
    }

    public void setAbbonamentoMensile(){
        this.setScadenza( LocalDate.now().plusMonths(1));
    }

    public void setEmissione(){
        this.setEmissione(LocalDate.now());
    }

}
