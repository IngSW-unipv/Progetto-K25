package it.unipv.ingsfw.treninordovest.model.strategy.abbonamento;

import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.Abbonamento;

import java.time.LocalDate;
import java.util.UUID;

public class AbbonamentoAnnualeConcrete implements IAbbonamentoStrategy {
    @Override
    public double ottieniPrezzoAbbonamento() {
        return 300;
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

    @Override
    public Abbonamento createAbbonamento() {
        return new Abbonamento(UUID.randomUUID(),LocalDate.now(),ottieniPrezzoAbbonamento(),getTipoAbbonamento(),getDataScadenza());
    }


}
