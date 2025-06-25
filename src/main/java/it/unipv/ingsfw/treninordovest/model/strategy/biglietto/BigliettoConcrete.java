package it.unipv.ingsfw.treninordovest.model.strategy.biglietto;

import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.Biglietto;
import it.unipv.ingsfw.treninordovest.model.varie.GeneraID;

import java.time.LocalDate;
import java.util.UUID;

public class BigliettoConcrete implements IBigliettoStrategy {
    @Override
    public double ottieniPrezzoBiglietto() {
        return 5;
    }

    @Override
    public boolean getValidazione() {
        return false;
    }

    @Override
    public Biglietto createBiglietto(String idCliente, String idTessera,boolean ritorno,LocalDate dataRitorno) {
        return new Biglietto(UUID.randomUUID(),getDataEmissione(),ottieniPrezzoBiglietto(),ritorno,getValidazione(),dataRitorno,getDataValidazione());
    }

    @Override
    public LocalDate getDataEmissione() {
        return LocalDate.now();
    }

    private LocalDate getDataValidazione() {
        return null;
    }

}
