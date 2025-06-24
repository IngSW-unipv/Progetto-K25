package it.unipv.ingsfw.treninordovest.service;

import it.unipv.ingsfw.treninordovest.model.factory.login.ILogin;
import it.unipv.ingsfw.treninordovest.model.factory.login.LoginFactoryProducer;
import it.unipv.ingsfw.treninordovest.model.utenti.utente.Utente;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;

public class LoginService {

    public LoginService() {}


    public boolean login(String id, String password,String tipoUtente) {
        try {

            ILogin loginFactory =  new LoginFactoryProducer().getFactoryFromProperties(tipoUtente);
            Utente user = (Utente) loginFactory.login(id, password);

            if (user != null) {

                System.out.println("DEBUG: ID Utente:   "+user.getId());

                SessionManager.getInstance().setCurrentUser(user);
                return true;
            }


        }catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    public boolean logout() {
        SessionManager.getInstance().logout();
        return true;
    }

}
