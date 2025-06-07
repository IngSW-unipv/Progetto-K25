package it.unipv.ingsfw.treninordovest.facade.interfaces;

import java.util.List;

public interface ITitoloViaggioFacade<T> {
   /**
    * Interfaccia comune per l'acquisto dei titoli di viaggio
    *
    * @return
    */
   void acquistaTitoloViaggio(String tipo,String metodoPagamento,int numeroTitoli);
   T rimuoviTitoloViaggio();
   boolean titoloDisponibile();
   void mostraTitolo();
   List<T> getTitoloViaggio();

}
