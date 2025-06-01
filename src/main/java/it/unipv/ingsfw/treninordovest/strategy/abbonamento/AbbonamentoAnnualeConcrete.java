package it.unipv.ingsfw.treninordovest.strategy.abbonamento;

import it.unipv.ingsfw.treninordovest.model.titoli.Abbonamento;

import java.time.LocalDate;

public class AbbonamentoAnnualeConcrete implements IAbbonamentoStrategy {
    @Override
    public double ottieniPrezzoAbbonamento() {
        return 100;
    }
    @Override
    public LocalDate getDataScadenza() {
        return LocalDate.now().plusYears(1);
    }
    @Override
    public String getTipoAbbonamento() {
        return "annuale";
    }
    @Override
    public LocalDate getEmissioneAbbonamento() {
        return LocalDate.now();
    }

}
