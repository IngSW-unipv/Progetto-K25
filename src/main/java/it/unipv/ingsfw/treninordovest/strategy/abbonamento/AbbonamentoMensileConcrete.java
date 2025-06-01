package it.unipv.ingsfw.treninordovest.strategy.abbonamento;

import java.time.LocalDate;

public class AbbonamentoMensileConcrete implements IAbbonamentoStrategy {
    @Override
    public double ottieniPrezzoAbbonamento() {
        return 100;
    }

    @Override
    public String getTipoAbbonamento() {
        return "mensile";
    }

    @Override
    public LocalDate getDataScadenza() {
        return LocalDate.now().plusMonths(1);
    }

    @Override
    public LocalDate getEmissioneAbbonamento() {
        return LocalDate.now();
    }
}
