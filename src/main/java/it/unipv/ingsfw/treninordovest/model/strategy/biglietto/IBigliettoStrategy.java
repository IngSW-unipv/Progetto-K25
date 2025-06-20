package it.unipv.ingsfw.treninordovest.model.strategy.biglietto;

import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.Biglietto;

import java.time.LocalDate;

public interface IBigliettoStrategy {
    double ottieniPrezzoBiglietto();
    boolean getValidazione();
    LocalDate getDataEmissione();
    Biglietto createBiglietto(String idCliente, String idPagamento, String idTessera,boolean ritorno,LocalDate dataRitorno);
}
