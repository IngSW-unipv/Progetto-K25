package it.unipv.ingsfw.treninordovest.model.utenti.cliente;

import it.unipv.ingsfw.treninordovest.model.factory.login.ILogin;
import it.unipv.ingsfw.treninordovest.model.factory.login.LoginFactoryProducer;
import it.unipv.ingsfw.treninordovest.view.frames.login.JLoginFrame;
import org.junit.jupiter.api.Test;

public class FactoryTest {

    @Test
    void LoginFactory() {

        String tipo = "cliente" ;
        ILogin login = new LoginFactoryProducer().getFactoryFromProperties(tipo);
        Cliente cliente = (Cliente) login.login("mario@gmail.com","1234");

        System.out.println(cliente.getId());
        System.out.println(cliente.getNome());

    }

    @Test
    void viewLoginTest(){

        JLoginFrame frame = new JLoginFrame();

        frame.setVisible(true);

    }

}
