package it.unipv.ingsfw.treninordovest.model.titoli.Abbonamenti;

import java.time.LocalDate;

public class AbbonamentoAnnuale extends Abbonamento {
    public AbbonamentoAnnuale(String id, String idPagamento, LocalDate emissione, double prezzo, String tipoAbbonamento, LocalDate scadenza, String idTessera) {
        super(id, idPagamento, emissione, prezzo, tipoAbbonamento, scadenza, idTessera);
    }

    @Override
   public void setScadenzaAbbonamento(){
        this.setScadenza( LocalDate.now().plusYears(1));
   }
    @Override
   public void setEmissione(){
       this.setEmissione(LocalDate.now());
   }


}
