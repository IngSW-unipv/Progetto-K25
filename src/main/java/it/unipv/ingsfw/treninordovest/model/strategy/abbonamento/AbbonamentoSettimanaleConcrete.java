package it.unipv.ingsfw.treninordovest.model.strategy.abbonamento;

import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.Abbonamento;
import it.unipv.ingsfw.treninordovest.model.titoli.tessera.Tessera;

import java.time.LocalDate;
import java.util.UUID;

public class AbbonamentoSettimanaleConcrete implements IAbbonamentoStrategy {
    @Override
    public double ottieniPrezzoAbbonamento() {
        return 10;
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

    @Override
    public Abbonamento createAbbonamento(Tessera tessera) {
        return new Abbonamento(UUID.randomUUID(),LocalDate.now(),ottieniPrezzoAbbonamento(),getTipoAbbonamento(),getDataScadenza(),tessera);

    }
}
