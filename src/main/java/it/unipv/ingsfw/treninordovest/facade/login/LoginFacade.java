package it.unipv.ingsfw.treninordovest.facade.login;

import it.unipv.ingsfw.treninordovest.factory.implementations.LoginFactoryProducer;
import it.unipv.ingsfw.treninordovest.factory.interfaces.ILoginAbstractFactory;

public class LoginFacade implements ILoginFacade {
    @Override
    public boolean login(String username, String password, String tipoUtente) {

        try {

            ILoginAbstractFactory loginAbstractFactory = LoginFactoryProducer.getFactoryFromProperties(tipoUtente);


        }catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
