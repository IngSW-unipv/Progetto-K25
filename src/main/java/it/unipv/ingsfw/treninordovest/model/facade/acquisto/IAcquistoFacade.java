package it.unipv.ingsfw.treninordovest.model.facade.acquisto;

import it.unipv.ingsfw.treninordovest.model.dto.TitoloDTO;

import java.time.LocalDate;

public interface IAcquistoFacade {

  boolean acquistaBiglietto(TitoloDTO titoloDTO);
  boolean acquistoAbbonamento(TitoloDTO titoloDTO);
  boolean acquistaTessera();
  boolean mostraViaggiDisponibili();

}
