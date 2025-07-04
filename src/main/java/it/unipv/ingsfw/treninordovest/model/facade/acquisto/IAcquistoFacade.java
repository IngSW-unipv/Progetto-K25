package it.unipv.ingsfw.treninordovest.model.facade.acquisto;

import java.time.LocalDate;

public interface IAcquistoFacade {

  boolean acquistaBiglietto(String tipoBiglietto, String tipoPagamento, int quantita, String idTratta, boolean ritorno, LocalDate dataRitorno);
  boolean acquistoAbbonamento(String tipoAbbonamento,String tipoPagamento,int quantita );
  boolean acquistaTessera();
  boolean rimborsoBiglietto(String idBiglietto);

}
