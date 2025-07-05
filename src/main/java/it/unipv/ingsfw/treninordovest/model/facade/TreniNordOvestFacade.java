package it.unipv.ingsfw.treninordovest.model.facade;

import it.unipv.ingsfw.treninordovest.model.facade.acquisto.AcquistoFacade;
import it.unipv.ingsfw.treninordovest.model.facade.login.RegistrationFacade;

public class TreniNordOvestFacade {

    private static TreniNordOvestFacade instance;

    private AcquistoFacade acquistoFacade;
    private RegistrationFacade loginFacade;


    public static TreniNordOvestFacade getInstance(){
        if(instance == null)
            instance = new TreniNordOvestFacade();
        return instance;
    }

    private TreniNordOvestFacade(){
        this.acquistoFacade = new AcquistoFacade();
        this.loginFacade = new RegistrationFacade();
    }


    public AcquistoFacade getAcquistoFacade(){
        return this.acquistoFacade;
    }

    public RegistrationFacade getRegistrationFacade(){
        return this.loginFacade;
    }




}
