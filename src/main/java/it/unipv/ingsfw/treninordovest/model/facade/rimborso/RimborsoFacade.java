package it.unipv.ingsfw.treninordovest.model.facade.rimborso;

import it.unipv.ingsfw.treninordovest.model.service.RimborsoService;

public class RimborsoFacade implements IRimborsoFacade {

    private final RimborsoService rimborsoService;

    public RimborsoFacade() {
        rimborsoService = new RimborsoService();
    }

    @Override
    public boolean rimborsoBiglietto(String idBiglietto) {
        return rimborsoService.effettuaRimborso(idBiglietto);
    }
}
