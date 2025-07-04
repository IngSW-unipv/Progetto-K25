package it.unipv.ingsfw.treninordovest.model.facade.acquisto;

import it.unipv.ingsfw.treninordovest.model.service.AcquistoService;

import java.beans.PropertyChangeListener;
import java.time.LocalDate;


public class AcquistoFacade implements IAcquistoFacade {

    ;
   private AcquistoService acquistoService;

    public AcquistoFacade() {
        this.acquistoService = new AcquistoService();
    }


    @Override
    public boolean acquistaBiglietto(String tipoBiglietto, String tipoPagamento, int quantita, String idTratta, boolean ritorno, LocalDate dataRitorno) {
        return acquistoService.acquistoBiglietto(tipoBiglietto,tipoPagamento, quantita,idTratta,ritorno,dataRitorno);
    }

    @Override
    public boolean acquistoAbbonamento(String tipoAbbonamento,String tipoPagamento,int quantita) {
        return acquistoService.acquistoAbbonamento(tipoAbbonamento,tipoPagamento,quantita);
    }

    @Override
    public boolean acquistaTessera(){
        return acquistoService.acquistoTessera();

    }

    @Override
    public boolean rimborsoBiglietto(String idBiglietto) {
        return false;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        acquistoService.addPropertyChangeListener(listener);
    }
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        acquistoService.removePropertyChangeListener(listener);
    }



}
