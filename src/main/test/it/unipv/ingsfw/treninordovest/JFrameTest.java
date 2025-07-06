package it.unipv.ingsfw.treninordovest;

import it.unipv.ingsfw.treninordovest.model.facade.login.RegistrationFacade;
import it.unipv.ingsfw.treninordovest.model.factory.login.ILogin;
import it.unipv.ingsfw.treninordovest.model.factory.login.LoginFactoryProducer;
import it.unipv.ingsfw.treninordovest.model.utenti.cliente.Cliente;
import it.unipv.ingsfw.treninordovest.model.utils.PasswordUtils;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.JTreniNordOvestFrame;
import org.junit.jupiter.api.Test;

import javax.swing.*;

public class JFrameTest  extends JFrame {

    @Test
    public void Test() {

//        Cliente cliente;
//
//        ILogin login = new  LoginFactoryProducer().getFactoryFromProperties("cliente");
//
//        cliente = (Cliente)  login.login("provamail@gmail.com","giacomoporetti");
//
//
//        System.out.println("IdCliente   "+cliente.getId());
//        System.out.println("IdTessera   "+cliente.getTessera().getIdTessera());

        // 1. Crea un hash con il nuovo sistema (BCrypt)
        String passwordDaSalvare = "PassTreno!2025";
        String hashBCrypt = PasswordUtils.hashPassword(passwordDaSalvare);

// 'hashBCrypt' conterrà qualcosa di simile a "$2a$10$..."
        System.out.println("Nuovo hash: " + hashBCrypt);

// 2. Ora la verifica con questo nuovo hash funzionerà
        boolean corrisponde = PasswordUtils.verifyPassword(passwordDaSalvare, hashBCrypt);
        System.out.println("La password corrisponde? " + corrisponde); // Questo stamperà 'true'


    }


}
