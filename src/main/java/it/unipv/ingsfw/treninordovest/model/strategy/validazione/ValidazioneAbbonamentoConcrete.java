package it.unipv.ingsfw.treninordovest.model.strategy.validazione;

import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.Abbonamento;
import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.AbbonamentoDAOimpl;
import it.unipv.ingsfw.treninordovest.model.titoli.titoloviaggio.TitoloViaggio;

public class ValidazioneAbbonamentoConcrete implements IValidazioneTitoliStrategy{

    @Override
    public boolean getValidazione(String idTitolo) {

        AbbonamentoDAOimpl abbonamentoDAOimpl = new AbbonamentoDAOimpl();
        Abbonamento abbonamento = abbonamentoDAOimpl.get(new Abbonamento(idTitolo));

        if(abbonamento!=null){
            if (abbonamento.isValido()){
                System.out.println("DEBUG: Strategia Validazione Abbonamento ok");
                return abbonamento.isValido();
            }
        }



        return false;
    }

    @Override
    public void valida(String idTitolo) {
    }
}
