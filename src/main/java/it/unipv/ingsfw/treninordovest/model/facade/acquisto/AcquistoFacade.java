package it.unipv.ingsfw.treninordovest.model.facade.acquisto;

import it.unipv.ingsfw.treninordovest.model.dto.TitoloDTO;
import it.unipv.ingsfw.treninordovest.model.ferrovia.viaggio.Viaggio;
import it.unipv.ingsfw.treninordovest.model.service.AcquistoService;
import it.unipv.ingsfw.treninordovest.model.service.viaggio.ViaggioService;

import java.beans.PropertyChangeListener;
import java.util.List;


public class AcquistoFacade implements IAcquistoFacade {

   private final AcquistoService acquistoService;
   private final ViaggioService viaggioService;

    public AcquistoFacade() {
        this.acquistoService = new AcquistoService();
        this.viaggioService = new ViaggioService();
    }


    @Override
    public boolean acquistaBiglietto(TitoloDTO titoloDTO) {
        return acquistoService.acquistoBiglietto(titoloDTO);
    }

    @Override
    public boolean acquistoAbbonamento(TitoloDTO titoloDTO) {
        return acquistoService.acquistoAbbonamento(titoloDTO);
    }

    @Override
    public boolean acquistaTessera(){
        return acquistoService.acquistoTessera();

    }

    @Override
    public List<Viaggio> mostraViaggiDisponibili() {
        return viaggioService.getViaggiDisponibili();
    }






}
