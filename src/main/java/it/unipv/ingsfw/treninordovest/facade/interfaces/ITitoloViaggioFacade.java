package it.unipv.ingsfw.treninordovest.facade.interfaces;

import it.unipv.ingsfw.treninordovest.model.titoli.Biglietto;
import it.unipv.ingsfw.treninordovest.model.titoli.TitoloViaggio;

import java.util.List;

public interface ITitoloViaggioFacade<T> {
   /**
    * Interfaccia comune per l'acquisto dei titoli di viaggio
    *
    * @return
    */
   T acquistaTitoloViaggio();
   T rimuoviTitoloViaggio();
   boolean titoloDisponibile();
   void mostraTitolo();
   List<T> getTitoloViaggio();

}
