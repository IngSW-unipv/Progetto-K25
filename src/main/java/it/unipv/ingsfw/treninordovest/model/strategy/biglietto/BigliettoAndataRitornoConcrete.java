package it.unipv.ingsfw.treninordovest.model.strategy.biglietto;

import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.Biglietto;

import java.time.LocalDate;
import java.util.UUID;

public class BigliettoAndataRitornoConcrete implements IBigliettoStrategy {
    @Override
    public double ottieniPrezzoBiglietto() {
        return 10;
    }

    @Override
    public boolean getValidazione() {
        return false;
    }

    @Override
    public Biglietto createBiglietto() {
        return new Biglietto(UUID.randomUUID(),getDataEmissione(),ottieniPrezzoBiglietto(),getValidazione(),getTipoBiglietto());
    }

    @Override
    public LocalDate getDataEmissione() {
        return LocalDate.now();
    }

    private LocalDate getDataValidazione() {
        return null;
    }

    @Override
    public String getTipoBiglietto() {
        return "AndataRitorno";
    }
}
