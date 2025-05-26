//package it.unipv.ingsfw.treninordovest.application;
//
//import it.unipv.ingsfw.treninordovest.controller.customer.CustomerRegController;
//import it.unipv.ingsfw.treninordovest.controller.employee.EmployeeRegController;
//import it.unipv.ingsfw.treninordovest.facade.implementations.gestioneutenti.UserRegistrationFacade;
//import it.unipv.ingsfw.treninordovest.view.frames.customer.JCustomerRegFrame;
//import it.unipv.ingsfw.treninordovest.view.frames.employee.JEmployeeRegFrame;
//
//public class UserRegistrationApplication {
//
//    private static JCustomerRegFrame frameCus;
//    private static JEmployeeRegFrame frameEmp;
//    private static UserRegistrationFacade facade;
//    private static CustomerRegController customerRegController;
//    private static EmployeeRegController employeeRegController;
//
//    public static void startCustomerReg(){
//        if (frameCus == null || facade == null) {
//            frameCus = new JCustomerRegFrame();
//            facade = UserRegistrationFacade.getInstance();
//
//            // Creiamo il controller qui invece che nel frame
//            customerRegController = new CustomerRegController(
//                frameCus.getCustomerRegistrationPanel(),
//                frameCus,
//                facade
//            );
//        }
//        frameCus.showFrame();
//    }
//
//    public static void startEmployeeReg(){
//        if (frameEmp == null || facade == null) {
//            frameEmp = new JEmployeeRegFrame();
//            facade = UserRegistrationFacade.getInstance();
//
//            // Creiamo il controller qui invece che nel frame
//            employeeRegController = new EmployeeRegController(
//                frameEmp.getEmployeeRegistrationPanel(),
//                frameEmp,
//                facade
//            );
//        }
//        frameEmp.showFrame();
//    }
//}