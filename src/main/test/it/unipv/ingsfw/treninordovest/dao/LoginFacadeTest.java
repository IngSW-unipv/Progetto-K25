package it.unipv.ingsfw.treninordovest.dao;

import it.unipv.ingsfw.treninordovest.facade.login.LoginFacade;
import it.unipv.ingsfw.treninordovest.model.utenti.cliente.Cliente;
import org.junit.jupiter.api.Test;

public class LoginFacadeTest {
    @Test
    void loginTest() {

        LoginFacade lf = new LoginFacade();
        lf.login(new Cliente("admin", "admin"),"Cliente");

    }
}
