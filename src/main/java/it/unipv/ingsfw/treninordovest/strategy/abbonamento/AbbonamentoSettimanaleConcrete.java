package it.unipv.ingsfw.treninordovest.strategy.abbonamento;

import java.time.LocalDate;

public class AbbonamentoSettimanaleConcrete implements IAbbonamentoStrategy {
    @Override
    public double ottieniPrezzoAbbonamento() {
        return 100;
    }
    @Override
    public String getTipoAbbonamento() {
        return "settimanale";
    }

    @Override
    public LocalDate getDataScadenza() {
        return LocalDate.now().plusWeeks(1);
    }

    @Override
    public LocalDate getEmissioneAbbonamento() {
        return LocalDate.now();
    }
}
