package it.unipv.ingsfw.treninordovest.facade.acquisto;

public interface IAcquistoFacade {

  boolean acquistaBiglietto();
  boolean acquistoAbbonamento(String tipoAbbonamento,String tipoPagamento );
  boolean acquistaTessera();

}
