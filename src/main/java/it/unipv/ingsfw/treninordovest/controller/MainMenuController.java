package it.unipv.ingsfw.treninordovest.controller;

import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JCustomerRegFrame;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JEmployeeRegFrame;
import it.unipv.ingsfw.treninordovest.view.frames.login.JLoginFrame;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JMainMenuFrame;
import it.unipv.ingsfw.treninordovest.view.panels.miscellanous.MainMenuPanel;

public class MainMenuController {

    private MainMenuPanel view;
    private JMainMenuFrame mainMenuFrame;

    public MainMenuController(MainMenuPanel view, JMainMenuFrame mainMenuFrame) {
        this.view = view;
        this.mainMenuFrame = mainMenuFrame;
        initController();
    }

    public void initController(){
       view.getAccesso().addActionListener(e -> apriLogin());
       view.getRegistrazioneCliente().addActionListener(e -> apriRegistrazioneCliente());
       view.getRegistrazioneDipendente().addActionListener(e -> apriRegistrazioneDipendente());
    }

    private void apriLogin() {
        JLoginFrame loginFrame = new JLoginFrame();
        loginFrame.setVisible(true);
        this.mainMenuFrame.setVisible(false);
    }

    private void apriRegistrazioneCliente() {
        JCustomerRegFrame customerRegFrame = new JCustomerRegFrame();
        customerRegFrame.setVisible(true);
        this.mainMenuFrame.setVisible(false);
    }

    private void apriRegistrazioneDipendente() {
        JEmployeeRegFrame employeeRegFrame = new JEmployeeRegFrame();
        employeeRegFrame.setVisible(true);
        this.mainMenuFrame.setVisible(false);

    }

}
