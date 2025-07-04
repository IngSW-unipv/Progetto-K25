package it.unipv.ingsfw.treninordovest.facade;

import it.unipv.ingsfw.treninordovest.facade.acquisto.AcquistoFacade;
import it.unipv.ingsfw.treninordovest.facade.login.LoginFacade;

public class TreniNordOvestFacade {

    private static TreniNordOvestFacade instance;

    private AcquistoFacade acquistoFacade;
    private LoginFacade loginFacade;


    public static TreniNordOvestFacade getInstance(){
        if(instance == null)
            instance = new TreniNordOvestFacade();
        return instance;
    }

    private TreniNordOvestFacade(){
        this.acquistoFacade = new AcquistoFacade();
        this.loginFacade = new LoginFacade();
    }


    public AcquistoFacade getAcquistoFacade(){
        return this.acquistoFacade;
    }

    public LoginFacade getLoginFacade(){
        return this.loginFacade;
    }




}
