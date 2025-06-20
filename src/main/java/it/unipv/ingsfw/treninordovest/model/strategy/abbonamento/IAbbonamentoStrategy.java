package it.unipv.ingsfw.treninordovest.model.strategy.abbonamento;

import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.Abbonamento;

import java.time.LocalDate;

public interface IAbbonamentoStrategy {
    double ottieniPrezzoAbbonamento();
    String getTipoAbbonamento();
    LocalDate getDataScadenza();
    LocalDate getEmissioneAbbonamento();
    Abbonamento createAbbonamento(String idCliente,String idPagamento,String idTessera);
   
}
