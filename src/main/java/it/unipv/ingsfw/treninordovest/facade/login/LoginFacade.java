package it.unipv.ingsfw.treninordovest.facade.login;

import it.unipv.ingsfw.treninordovest.factory.login.ILogin;
import it.unipv.ingsfw.treninordovest.factory.login.LoginFactoryProducer;
import it.unipv.ingsfw.treninordovest.model.utenti.utente.Utente;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;



public class LoginFacade implements ILoginFacade {
    @Override
    public boolean login(String id, String password, String tipoUtente) {

        try {

            ILogin loginAbstractFactory = LoginFactoryProducer.getFactoryFromProperties(tipoUtente);
           Utente user = (Utente) loginAbstractFactory.login(id, password);


            if (user != null) {

                System.out.println(user.getId());

                //SessionManager.getInstance().setCurrentUser(user);
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
