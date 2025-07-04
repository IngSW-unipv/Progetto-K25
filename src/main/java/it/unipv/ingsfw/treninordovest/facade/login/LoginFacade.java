package it.unipv.ingsfw.treninordovest.facade.login;


import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;
import it.unipv.ingsfw.treninordovest.service.LoginService;

import java.beans.PropertyChangeListener;


public class LoginFacade implements ILoginFacade {

    private LoginService loginService;

    public LoginFacade() {
        loginService = new LoginService();
    }


    @Override
    public boolean login(String id, String password, String tipoUtente) {
       return loginService.login(id, password, tipoUtente) ;
    }


    @Override
    public void logout() {
        loginService.logout();
    }


    public void addPropertyChangeListener(PropertyChangeListener listener) {
        loginService.addPropertyChangeListener(listener);
    }
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        loginService.removePropertyChangeListener(listener);
    }
    public void notifyPropertyChange(String propertyName, Object oldValue, Object newValue) {
        loginService.notifyPropertyChange(propertyName, oldValue, newValue);
    }


}
