package it.unipv.ingsfw.treninordovest.model.facade.titoliviaggio;

import it.unipv.ingsfw.treninordovest.model.dto.TitoloDTO;
import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.Abbonamento;
import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.Biglietto;

import java.util.List;

public interface ITitoloViaggioFacade<T> {
   /**
    * Interfaccia comune per l'acquisto dei titoli di viaggio
    *
    * @return
    */
   List<Biglietto> mostraBigliettiAcquistati();
   List<Abbonamento> mostraAbbonamentiAcquistati();
   boolean verificaTitoloViaggio(TitoloDTO titoloDTO);

}
