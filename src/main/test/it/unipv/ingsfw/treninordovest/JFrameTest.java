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
        String passwordOriginale = "PasswordSicura123!";
        System.out.println("--- INIZIO TEST ---");
        System.out.println("Password scelta per il test: [" + passwordOriginale + "]");
        System.out.println("-------------------------------------------");

        // 2. Hashing: Simuliamo la REGISTRAZIONE di un utente
        String hashGenerato = PasswordUtils.hashPassword(passwordOriginale);
        System.out.println("Hashing della password...");
        System.out.println("Hash generato: [" + hashGenerato + "]");
        System.out.println("La sua lunghezza è: " + hashGenerato.length()); // Deve essere 60
        System.out.println("-------------------------------------------");

        // 3. Verifica: Simuliamo il LOGIN con la password corretta
        System.out.println("Verifica con la password CORRETTA...");
        boolean esitoCorretto = PasswordUtils.verifyPassword(passwordOriginale, hashGenerato);
        System.out.println("Risultato della verifica: " + esitoCorretto);
        System.out.println("-------------------------------------------");

        // 4. Controprova: Simuliamo il LOGIN con una password sbagliata
        String passwordSbagliata = "password-errata";
        System.out.println("Verifica con la password SBAGLIATA (" + passwordSbagliata + ")...");
        boolean esitoSbagliato = PasswordUtils.verifyPassword(passwordSbagliata, hashGenerato);
        System.out.println("Risultato della verifica: " + esitoSbagliato);
        System.out.println("-------------------------------------------");

        // 5. Conclusione del test
        if (esitoCorretto && !esitoSbagliato) {
            System.out.println("✅ TEST SUPERATO: La classe PasswordUtils e la libreria funzionano perfettamente.");
        } else {
            System.out.println("❌ TEST FALLITO: C'è un problema nella logica di base dell'hashing o della verifica.");
        }

    }


}
