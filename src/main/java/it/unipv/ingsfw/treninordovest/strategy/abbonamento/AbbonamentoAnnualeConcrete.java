package it.unipv.ingsfw.treninordovest.strategy.abbonamento;

import it.unipv.ingsfw.treninordovest.model.titoli.Abbonamento;

import java.time.LocalDate;

public class AbbonamentoAnnualeConcrete implements IAbbonamentoStrategy {
    @Override
    public double ottieniPrezzoAbbonamento() {
        return 100;
    }
    @Override
    public Abbonamento creaAbbonamento(Abbonamento Abbonamento) {
        Abbonamento.setTipoAbbonamento("annuale");
        Abbonamento.setPrezzo(100);
        Abbonamento.setScadenza(LocalDate.now().plusYears(1));

        return Abbonamento;
    }
}
