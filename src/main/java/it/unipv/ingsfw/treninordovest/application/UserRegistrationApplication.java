package it.unipv.ingsfw.treninordovest.application;

import it.unipv.ingsfw.treninordovest.controller.users.CustomerRegController;
import it.unipv.ingsfw.treninordovest.facade.UserRegistrationFacade;
import it.unipv.ingsfw.treninordovest.view.frames.registration.JCustomerRegFrame;
import it.unipv.ingsfw.treninordovest.view.frames.registration.JEmployeeRegFrame;

public class UserRegistrationApplication {

    private static JCustomerRegFrame frameCus;
    private static JEmployeeRegFrame frameEmp;
    private static UserRegistrationFacade facade;

    public static void startCustomerReg(){
        if (frameCus == null || facade == null) {
            frameCus = new JCustomerRegFrame();
            facade = new UserRegistrationFacade();
            
            // Creiamo il controller qui invece che nel frame
            CustomerRegController customerRegController = new CustomerRegController(
                    frameCus.getCustomerRegistrationPanel(),
                    frameCus,
                    facade
            );
        }
        frameCus.showFrame();
    }

    public static void startEmployeeReg(){
        if (frameEmp == null || facade == null) {
            frameEmp = new JEmployeeRegFrame();
            facade = new UserRegistrationFacade();
            // Qui possiamo creare il controller per i dipendenti se necessario
        }
        frameEmp.showFrame();
    }
}