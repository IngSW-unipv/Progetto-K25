package it.unipv.ingsfw.treninordovest.model.facade;

import it.unipv.ingsfw.treninordovest.model.facade.acquisto.AcquistoFacade;
import it.unipv.ingsfw.treninordovest.model.facade.login.RegistrationFacade;
import it.unipv.ingsfw.treninordovest.model.facade.rimborso.RimborsoFacade;
import it.unipv.ingsfw.treninordovest.model.facade.titoliviaggio.TitoloViaggioFacade;
import it.unipv.ingsfw.treninordovest.model.facade.utente.UtenteFacade;

public class TreniNordOvestFacade {

    private static TreniNordOvestFacade instance;

    private final AcquistoFacade acquistoFacade;
    private final RegistrationFacade loginFacade;
    private final RimborsoFacade rimborsoFacade;
    private final UtenteFacade utenteFacade;
    private final TitoloViaggioFacade titoloViaggioFacade;


    public static TreniNordOvestFacade getInstance(){
        if(instance == null)
            instance = new TreniNordOvestFacade();
        return instance;
    }

    private TreniNordOvestFacade(){
        this.acquistoFacade = new AcquistoFacade();
        this.loginFacade = new RegistrationFacade();
        this.rimborsoFacade = new RimborsoFacade();
        this.utenteFacade = new UtenteFacade();
        this.titoloViaggioFacade = new TitoloViaggioFacade();
    }


    public AcquistoFacade getAcquistoFacade(){
        return this.acquistoFacade;
    }

    public RegistrationFacade getRegistrationFacade(){
        return this.loginFacade;
    }

    public RimborsoFacade getRimborsoFacade(){
        return this.rimborsoFacade;
    }

    public UtenteFacade getUtenteFacade(){
        return this.utenteFacade;
    }
    public TitoloViaggioFacade getTitoloViaggioFacade(){
        return this.titoloViaggioFacade;
    }




}
