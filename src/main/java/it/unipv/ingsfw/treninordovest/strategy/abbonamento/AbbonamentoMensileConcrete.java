package it.unipv.ingsfw.treninordovest.strategy.abbonamento;

import it.unipv.ingsfw.treninordovest.model.titoli.Abbonamento;
import it.unipv.ingsfw.treninordovest.model.varie.GeneraID;

import java.time.LocalDate;

public class AbbonamentoMensileConcrete implements IAbbonamentoStrategy {
    @Override
    public double ottieniPrezzoAbbonamento() {
        return 30;
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

    @Override
    public Abbonamento createAbbonamento(String idCliente, String idPagamento, String idTessera) {
        GeneraID generaIDAbbonamento = new GeneraID("AB");
        return new Abbonamento(generaIDAbbonamento.getID(),idPagamento,LocalDate.now(),ottieniPrezzoAbbonamento(),getTipoAbbonamento(),getDataScadenza(),idTessera);
    }
}
