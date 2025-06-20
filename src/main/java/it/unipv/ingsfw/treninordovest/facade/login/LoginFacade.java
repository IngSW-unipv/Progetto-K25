package it.unipv.ingsfw.treninordovest.facade.login;

import it.unipv.ingsfw.treninordovest.model.factory.login.ILogin;
import it.unipv.ingsfw.treninordovest.model.factory.login.LoginFactoryProducer;
import it.unipv.ingsfw.treninordovest.model.utenti.utente.Utente;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;



public class LoginFacade implements ILoginFacade {
    @Override
    public boolean login(String id, String password, String tipoUtente) {

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


    @Override
    public void logout() {
        SessionManager.getInstance().logout();
    }
}
