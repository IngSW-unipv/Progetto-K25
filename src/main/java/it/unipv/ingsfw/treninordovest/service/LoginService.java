package it.unipv.ingsfw.treninordovest.service;

import it.unipv.ingsfw.treninordovest.model.factory.login.ILogin;
import it.unipv.ingsfw.treninordovest.model.factory.login.LoginFactoryProducer;
import it.unipv.ingsfw.treninordovest.model.utenti.utente.Utente;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class LoginService {

    private final PropertyChangeSupport support ;

    public static final String LOGIN_SUCCESS_PROPERTY = "login_success";


    public LoginService() {
        this.support = new PropertyChangeSupport(this);
    }


    public boolean login(String id, String password,String tipoUtente) {
        try {

            ILogin loginFactory =  new LoginFactoryProducer().getFactoryFromProperties(tipoUtente);
            Utente user = (Utente) loginFactory.login(id, password);

            if (user != null) {

                System.out.println("DEBUG: ID Utente:   "+user.getId());

                SessionManager.getInstance().setCurrentUser(user);
                support.firePropertyChange(LOGIN_SUCCESS_PROPERTY, null, user);
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

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }
    public void notifyPropertyChange(String propertyName, Object oldValue, Object newValue) {
        support.firePropertyChange(propertyName, oldValue, newValue);
    }

}
