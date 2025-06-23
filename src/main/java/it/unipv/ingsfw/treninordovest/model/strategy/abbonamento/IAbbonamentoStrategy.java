package it.unipv.ingsfw.treninordovest.model.strategy.abbonamento;

import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.Abbonamento;
import it.unipv.ingsfw.treninordovest.model.titoli.tessera.Tessera;

import java.time.LocalDate;

public interface IAbbonamentoStrategy {
    double ottieniPrezzoAbbonamento();
    String getTipoAbbonamento();
    LocalDate getDataScadenza();
    LocalDate getEmissioneAbbonamento();
    Abbonamento createAbbonamento(Tessera tessera);
   
}
