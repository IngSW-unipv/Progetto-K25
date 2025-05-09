package it.unipv.ingsfw.treninordovest.controller.misc;

import it.unipv.ingsfw.treninordovest.facade.LoginFacade;
import it.unipv.ingsfw.treninordovest.view.frames.login.JLoginFrame;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JMainMenuFrame;
import it.unipv.ingsfw.treninordovest.view.panels.miscellanous.LoginPanel;

public class LoginController {
    private final LoginPanel view;
    private final JLoginFrame frame;
    private final LoginFacade loginFacade;

    public LoginController(LoginPanel view, JLoginFrame loginFrame) {
        this.view = view;
        this.frame = loginFrame;
        this.loginFacade = new LoginFacade();
        initController();
    }

    private void initController() {
        view.getBottoneAccesso().addActionListener(e -> doLogin());
        view.getBottoneIndietro().addActionListener(e -> tornaAlMenu());
    }

    private void doLogin() {
        String username = view.getCampoUtente().getText();
        String password = view.getCampoPassword().getText();
        String ruolo = view.getComboRuolo();
        
        // Utilizzare la facade per gestire il processo di login
        loginFacade.effettuaLogin(username, password, ruolo, frame, view);
    }

    private void tornaAlMenu() {
        frame.setVisible(false);
        JMainMenuFrame newFrame = new JMainMenuFrame();
        newFrame.setVisible(true);
    }
}