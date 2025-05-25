//package it.unipv.ingsfw.treninordovest.application;
//
//import it.unipv.ingsfw.treninordovest.controller.customer.CustomerTicketController;
//import it.unipv.ingsfw.treninordovest.controller.misc.IController;
//import it.unipv.ingsfw.treninordovest.controller.customer.CardPurchaseController;
//import it.unipv.ingsfw.treninordovest.controller.customer.CustomerProfileController;
//import it.unipv.ingsfw.treninordovest.controller.customer.SubscriptionController;
//import it.unipv.ingsfw.treninordovest.controller.customer.TicketRefundController;
//import it.unipv.ingsfw.treninordovest.view.frames.customer.JCustomerMainFrame;
//
//import java.util.ArrayList;
//import java.util.List;
//import javax.swing.JOptionPane;
//
///**
// * Classe per inizializzare e avviare l'applicazione cliente
// */
//public class CustomerApplicationLauncher {
//
//    /**
//     * Inizializza e avvia l'applicazione cliente
//     */
//    public static void launch() {
//        try {
//            // Crea la view
//            JCustomerMainFrame mainFrame = new JCustomerMainFrame();
//
//            // Crea e inizializza i controller
//            List<IController> controllers = new ArrayList<>();
//
//            controllers.add((IController) new CardPurchaseController(
//                    mainFrame.getCardPurchasePanel(), mainFrame));
//
//            controllers.add(new SubscriptionController(mainFrame.getSubscriptionPanel(), mainFrame));
//
//            controllers.add(new CustomerTicketController(
//                    mainFrame, mainFrame.getTratteTablePanel(),
//                    mainFrame.getTicketPurchasePanel()));
//
//            controllers.add(new TicketRefundController(
//                    mainFrame, mainFrame.getRefundPanel()));
//
//            controllers.add(new CustomerProfileController(
//                    mainFrame.getProfilePanel(), mainFrame));
//
//            // Inizializza tutti i controller
//            controllers.forEach(IController::init);
//
//            // Mostra la finestra principale
//            mainFrame.setVisible(true);
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null,
//                "Errore durante l'avvio dell'applicazione cliente: " + e.getMessage(),
//                "Errore", JOptionPane.ERROR_MESSAGE);
//            e.printStackTrace();
//        }
//    }
//}