package it.unipv.ingsfw.treninordovest.application;

import it.unipv.ingsfw.treninordovest.controller.misc.LoginController;
import it.unipv.ingsfw.treninordovest.facade.LoginFacade;
import it.unipv.ingsfw.treninordovest.view.frames.login.JLoginFrame;

/**
 * Classe che configura e inizializza l'applicazione di login
 */
public class LoginApplication {

    private static JLoginFrame loginFrame;
    private static LoginFacade loginFacade;

    /**
     * Costruttore che accetta dipendenze personalizzate
     * @param loginFrame il frame di login
     * @param loginFacade la facade per gestire il login
     */
    public LoginApplication(JLoginFrame loginFrame, LoginFacade loginFacade) {
        LoginApplication.loginFrame = loginFrame;
        LoginApplication.loginFacade = loginFacade;
    }
    
    /**
     * Costruttore senza parametri che crea le dipendenze di default
     */
    public LoginApplication() {
        loginFrame = new JLoginFrame();
        loginFacade = LoginFacade.getInstance();
    }

    /**
     * Avvia l'applicazione configurando il controller e mostrando la UI
     */
    public static void start() {
        // Verifica se le dipendenze sono state inizializzate
        if (loginFrame == null || loginFacade == null) {
            // Inizializza le dipendenze se non sono già state create
            loginFrame = new JLoginFrame();
            loginFacade = LoginFacade.getInstance();
        }
        
        // Configurazione delle dipendenze
        LoginController loginController = new LoginController(
                loginFrame.getLoginPanel(),
                loginFrame,
                loginFacade
        );
        
        // Avvio dell'applicazione
        loginFrame.showFrame();
    }
}