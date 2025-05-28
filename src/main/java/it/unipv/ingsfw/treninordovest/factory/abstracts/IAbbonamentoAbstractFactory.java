package it.unipv.ingsfw.treninordovest.factory.abstracts;

import it.unipv.ingsfw.treninordovest.model.titoli.Abbonamenti.Abbonamento;

public interface IAbbonamentoAbstractFactory {
    Abbonamento getAbbonamento(String tipoAbbonamento);
    String getTipoAbbonamento(Abbonamento abbonamento);


}
