package it.unipv.ingsfw.treninordovest.strategy.abbonamento;

import it.unipv.ingsfw.treninordovest.model.titoli.Abbonamento;

public interface IAbbonamentoStrategy {
    double ottieniPrezzoAbbonamento();
    Abbonamento creaAbbonamento(Abbonamento Abbonamento);
}
