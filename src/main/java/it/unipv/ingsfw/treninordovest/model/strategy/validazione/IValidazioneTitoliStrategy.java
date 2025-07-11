package it.unipv.ingsfw.treninordovest.model.strategy.validazione;


import it.unipv.ingsfw.treninordovest.model.titoli.titoloviaggio.TitoloViaggio;

public interface IValidazioneTitoliStrategy {

    boolean getValidazione(String idTitolo);
}
