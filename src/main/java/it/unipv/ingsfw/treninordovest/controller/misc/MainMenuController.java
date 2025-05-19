package it.unipv.ingsfw.treninordovest.controller.misc;

import it.unipv.ingsfw.treninordovest.application.UserRegistrationApplication;
import it.unipv.ingsfw.treninordovest.facade.LoginFacade;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JMainMenuFrame;
import it.unipv.ingsfw.treninordovest.view.frames.registration.JCustomerRegFrame;
import it.unipv.ingsfw.treninordovest.view.frames.registration.JEmployeeRegFrame;
import it.unipv.ingsfw.treninordovest.view.panels.miscellanous.MainMenuPanel;
import it.unipv.ingsfw.treninordovest.application.LoginApplication;

/**
 * Controller che gestisce le interazioni dell'utente con il menu principale
 */
public class MainMenuController implements IMenuController {

    private final MainMenuPanel view;
    private final JMainMenuFrame mainMenuFrame;

    /**
     * Costruttore che accetta una vista e un frame
     * @param view il pannello del menu principale
     * @param mainMenuFrame il frame contenitore
     */
    public MainMenuController(MainMenuPanel view, JMainMenuFrame mainMenuFrame) {
        this.view = view;
        this.mainMenuFrame = mainMenuFrame;
        initController();
    }

    @Override
    public void initController() {
       view.getAccesso().addActionListener(e -> apriLogin());
       view.getRegistrazioneCliente().addActionListener(e -> apriRegistrazioneCliente());
       view.getRegistrazioneDipendente().addActionListener(e -> apriRegistrazioneDipendente());
    }

    private void apriLogin() {
        // Nascondi la finestra corrente
        this.mainMenuFrame.setVisible(false);
        // Crea una nuova istanza di LoginApplication e poi avviala
        LoginApplication.start();
    }

    private void apriRegistrazioneCliente() {

        this.mainMenuFrame.setVisible(false);
        UserRegistrationApplication.startCustomerReg();
    }

    private void apriRegistrazioneDipendente() {

        this.mainMenuFrame.setVisible(false);
        UserRegistrationApplication.startEmployeeReg();
    }
}