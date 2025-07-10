package it.unipv.ingsfw.treninordovest.model.strategy.biglietto;

import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.Biglietto;

import java.time.LocalDate;
import java.util.UUID;

public class BigliettoAndataConcrete implements IBigliettoStrategy {
    @Override
    public double ottieniPrezzoBiglietto() {
        return 5;
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

    @Override
    public String getTipoBiglietto() {
        return "Andata";
    }
}
