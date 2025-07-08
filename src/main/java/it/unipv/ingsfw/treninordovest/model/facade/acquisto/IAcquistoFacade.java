package it.unipv.ingsfw.treninordovest.model.facade.acquisto;

import it.unipv.ingsfw.treninordovest.model.dto.TitoloDTO;
import it.unipv.ingsfw.treninordovest.model.ferrovia.viaggio.Viaggio;

import java.time.LocalDate;
import java.util.List;

public interface IAcquistoFacade {

  boolean acquistaBiglietto(TitoloDTO titoloDTO);
  boolean acquistoAbbonamento(TitoloDTO titoloDTO);
  boolean acquistaTessera();
  List<Viaggio> mostraViaggiDisponibili();

}
