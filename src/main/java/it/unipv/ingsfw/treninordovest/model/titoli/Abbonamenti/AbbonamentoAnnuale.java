package it.unipv.ingsfw.treninordovest.model.titoli.Abbonamenti;

import java.time.LocalDate;

public class AbbonamentoAnnuale extends Abbonamento {
    public AbbonamentoAnnuale(String id, String idPagamento, LocalDate emissione, double prezzo, String tipoAbbonamento, LocalDate scadenza, String idTessera) {
        super(id, idPagamento, emissione, prezzo, tipoAbbonamento, scadenza, idTessera);
    }

    public AbbonamentoAnnuale() {
        super();
    }

   public void setAbbonamento(){
        this.setScadenza( LocalDate.now().plusYears(1));
   }

   public void setEmissioneAnnuale(){
       this.setEmissione(LocalDate.now());
   }


}
