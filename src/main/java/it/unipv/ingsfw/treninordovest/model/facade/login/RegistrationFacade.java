package it.unipv.ingsfw.treninordovest.model.facade.login;


import it.unipv.ingsfw.treninordovest.model.dto.LoginDTO;
import it.unipv.ingsfw.treninordovest.model.service.RegistrationService;
import it.unipv.ingsfw.treninordovest.model.utenti.cliente.Cliente;
import it.unipv.ingsfw.treninordovest.model.utenti.dipendente.Dipendente;
import it.unipv.ingsfw.treninordovest.model.utenti.utente.Utente;

import java.beans.PropertyChangeListener;


public class RegistrationFacade implements ILoginFacade {

    private final RegistrationService loginService;

    public RegistrationFacade() {
        loginService = new RegistrationService();
    }


    @Override
    public boolean login(LoginDTO loginDTO) {
       return loginService.login(loginDTO) ;
    }


    @Override
    public void logout() {
        loginService.logout();
    }

    @Override
    public boolean registraCliente(Cliente cliente) {
        return loginService.registraCliente(cliente);
    }

    @Override
    public boolean registraDipendente(Dipendente dipendente) {
        return loginService.registraDipendente(dipendente);
    }

//
//    public void addPropertyChangeListener(PropertyChangeListener listener) {
//        loginService.addPropertyChangeListener(listener);
//    }
//    public void removePropertyChangeListener(PropertyChangeListener listener) {
//        loginService.removePropertyChangeListener(listener);
//    }



}
