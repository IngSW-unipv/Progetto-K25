package it.unipv.ingsfw.treninordovest.strategy.biglietto;

import it.unipv.ingsfw.treninordovest.model.dto.TitoloDTO;
import it.unipv.ingsfw.treninordovest.model.factory.implementations.ValidazioneTitoliStrategyFactory;
import it.unipv.ingsfw.treninordovest.model.strategy.validazione.IValidazioneTitoliStrategy;
import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.Biglietto;
import it.unipv.ingsfw.treninordovest.model.titoli.titoloviaggio.TitoloViaggio;
import org.junit.jupiter.api.Test;

public class ValidazioneTest {



    @Test
    void name() {

        String tipoTitolo=  "abbonamento";
        String id= "cbeb0290-445b-4331-bedc-159bbf7094eb";
        TitoloDTO titoloDTO = new TitoloDTO(id,tipoTitolo);


        IValidazioneTitoliStrategy validazioneTitoliStrategy = ValidazioneTitoliStrategyFactory.getFactoryFromProperties(titoloDTO.getTipoTitolo());

        System.out.println(validazioneTitoliStrategy.getValidazione(titoloDTO.getId().toString()));






    }
}
