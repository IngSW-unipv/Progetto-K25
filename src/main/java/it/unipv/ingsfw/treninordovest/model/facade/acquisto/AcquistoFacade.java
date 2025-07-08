package it.unipv.ingsfw.treninordovest.model.facade.acquisto;

import it.unipv.ingsfw.treninordovest.model.dto.TitoloDTO;
import it.unipv.ingsfw.treninordovest.model.service.AcquistoService;
import it.unipv.ingsfw.treninordovest.model.service.ViaggioService;

import java.beans.PropertyChangeListener;
import java.time.LocalDate;


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
    public boolean mostraViaggiDisponibili() {
        viaggioService.getViaggiDisponibili();

        return false;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        acquistoService.addPropertyChangeListener(listener);
    }

    public void addViaggiDisponibiliPropertyChangeListener(PropertyChangeListener listener) {
        viaggioService.addPropertyChangeListener(listener);
    }
    public void removeViaggiDisponibiliPropertyChangeListener(PropertyChangeListener listener) {
        viaggioService.removePropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        acquistoService.removePropertyChangeListener(listener);
        viaggioService.removePropertyChangeListener(listener);
    }



}
