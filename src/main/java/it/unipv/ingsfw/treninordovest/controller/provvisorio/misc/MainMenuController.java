//package it.unipv.ingsfw.treninordovest.controller.provvisorio.misc;
//
//import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JMainMenuFrame;
//import it.unipv.ingsfw.treninordovest.view.panels.miscellanous.MainMenuPanel;
//
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.beans.PropertyChangeListener;
//import java.beans.PropertyChangeSupport;
//
//public class MainMenuController implements ActionListener {
//    private final Runnable onLogin;
//    private final Runnable onCustomerRegistration;
//    private final Runnable onEmployeeRegistration;
//
//    public MainMenuController(MainMenuPanel panel, Runnable onLogin, Runnable onCustomerRegistration, Runnable onEmployeeRegistration) {
//        // registra se stesso ai click del panel
//        panel.addActionListener(this);
//
//        // salva i callback
//        this.onLogin                = onLogin;
//        this.onCustomerRegistration = onCustomerRegistration;
//        this.onEmployeeRegistration = onEmployeeRegistration;
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        switch (e.getActionCommand()) {
//            case MainMenuPanel.CMD_LOGIN:
//                onLogin.run();
//                break;
//            case MainMenuPanel.CMD_REG_CUSTOMER:
//                onCustomerRegistration.run();
//                break;
//            case MainMenuPanel.CMD_REG_EMPLOYEE:
//                onEmployeeRegistration.run();
//                break;
//        }
//    }
//}
