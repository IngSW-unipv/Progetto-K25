package it.unipv.ingsfw.treninordovest.strategy.biglietto;

import it.unipv.ingsfw.treninordovest.model.titoli.Abbonamento;
import it.unipv.ingsfw.treninordovest.model.titoli.Biglietto;
import org.hibernate.query.criteria.internal.predicate.BooleanExpressionPredicate;

import java.time.LocalDate;

public interface IBigliettoStrategy {
    double ottieniPrezzoBiglietto();
    boolean getValidazione();
    LocalDate getDataEmissione();
    Biglietto createBiglietto(String idCliente, String idPagamento, String idTessera,boolean ritorno,LocalDate dataRitorno);
}
