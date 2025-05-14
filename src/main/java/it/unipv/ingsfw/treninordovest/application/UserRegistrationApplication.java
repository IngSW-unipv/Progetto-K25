package it.unipv.ingsfw.treninordovest.application;

import it.unipv.ingsfw.treninordovest.facade.UserRegistrationFacade;
import it.unipv.ingsfw.treninordovest.view.frames.registration.JCustomerRegFrame;
import it.unipv.ingsfw.treninordovest.view.frames.registration.JEmployeeRegFrame;

public class UserRegistrationApplication {

    private static JCustomerRegFrame frameCus;
    private static JEmployeeRegFrame frameEmp;
    private static UserRegistrationFacade facade;

    public static void startCustomerReg(){

        if (frameCus == null || frameEmp == null || facade == null) {
            frameCus = new JCustomerRegFrame();
            facade = new UserRegistrationFacade();

        }
        frameCus.showFrame();

    }

    public static void startEmployeeReg(){
        if (frameCus == null || frameEmp == null || facade == null) {
            frameEmp = new JEmployeeRegFrame();
            facade = new UserRegistrationFacade();
        }

        frameEmp.showFrame();


    }



}
