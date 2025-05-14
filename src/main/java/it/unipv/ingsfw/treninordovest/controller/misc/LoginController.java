package it.unipv.ingsfw.treninordovest.controller.misc;

import it.unipv.ingsfw.treninordovest.facade.LoginFacade;
import it.unipv.ingsfw.treninordovest.view.frames.login.JLoginFrame;
import it.unipv.ingsfw.treninordovest.view.panels.miscellanous.LoginPanel;

/**
 * Controller che gestisce le interazioni dell'utente con la schermata di login
 */
public class LoginController implements ILoginController {
    private final LoginPanel view;
    private final JLoginFrame frame;
    private final LoginFacade loginFacade;

    /**
     * Costruttore che accetta un pannello di login e il frame che lo contiene
     * @param view il pannello di login
     * @param loginFrame il frame contenitore
     */
    public LoginController(LoginPanel view, JLoginFrame loginFrame) {
        this.view = view;
        this.frame = loginFrame;
        this.loginFacade = new LoginFacade();
        initController();
    }

    /**
     * Costruttore che permette anche l'iniezione della facade
     * @param view il pannello di login
     * @param loginFrame il frame contenitore
     * @param loginFacade la facade per gestire il login
     */
    public LoginController(LoginPanel view, JLoginFrame loginFrame, LoginFacade loginFacade) {
        this.view = view;
        this.frame = loginFrame;
        this.loginFacade = loginFacade;
        initController();
    }

    @Override
    public void initController() {
        view.getBottoneAccesso().addActionListener(e -> doLogin());
        view.getBottoneIndietro().addActionListener(e -> tornaAlMenu());
    }

    private void doLogin() {
        // Recupera username, password e ruolo dall'interfaccia
        String username = view.getCampoUtente().getText();
        char[] passwordChars = view.getCampoPassword().getPassword();
        String password = new String(passwordChars);
        String ruolo = view.getComboRuolo();
        
        // Utilizza la facade per effettuare il login
        loginFacade.effettuaLogin(username, password, ruolo, frame, view.getPanel());
    }

    private void tornaAlMenu() {
        // Logica per tornare al menu principale
        loginFacade.tornaAlMenu(frame);
        // Codice per aprire il menu principale
    }
}