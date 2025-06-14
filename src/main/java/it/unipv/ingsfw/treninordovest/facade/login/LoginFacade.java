package it.unipv.ingsfw.treninordovest.facade.login;

import it.unipv.ingsfw.treninordovest.factory.login.ILoginFactory;
import it.unipv.ingsfw.treninordovest.factory.login.LoginFactoryProducer;
import it.unipv.ingsfw.treninordovest.factory.login.ILoginAbstractFactory;
import it.unipv.ingsfw.treninordovest.model.utenti.utente.Utente;

public class LoginFacade implements ILoginFacade {
    @Override
    public boolean login(Utente utente, String tipoUtente) {

        try {

            ILoginFactory loginAbstractFactory = LoginFactoryProducer.getFactoryFromProperties(tipoUtente);
             loginAbstractFactory.login(utente);


        }catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
}
