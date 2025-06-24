package it.unipv.ingsfw.treninordovest.facade.login;


import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;
import it.unipv.ingsfw.treninordovest.service.LoginService;


public class LoginFacade implements ILoginFacade {

    private LoginService loginService;

    public LoginFacade() {

    }


    @Override
    public boolean login(String id, String password, String tipoUtente) {
       return loginService.login(id, password, tipoUtente) ;
    }


    @Override
    public void logout() {
        loginService.logout();
    }
}
