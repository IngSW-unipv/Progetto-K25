//package it.unipv.ingsfw.treninordovest.facade.implementations.gestioneutenti;
//
//import it.unipv.ingsfw.treninordovest.factory.implementations.LoginFactoryProducer;
//import it.unipv.ingsfw.treninordovest.model.utenti.utente.Utente;
//import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;
//import it.unipv.ingsfw.treninordovest.factory.interfaces.ILoginAbstractFactory;
//
///**
// * Facade che semplifica il processo di login implementata come Singleton
// */
//public class LoginFacade {
//
//    // Istanza singleton
//    private static LoginFacade instance;
//
//    /**
//     * Metodo per ottenere l'istanza singleton
//     * @return l'unica istanza di LoginFacade
//     */
//    public static LoginFacade getInstance() {
//        if (instance == null) {
//            instance = new LoginFacade();
//        }
//        return instance;
//    }
//
//    /**
//     * Effettua il login di un utente
//     */
//    public void effettuaLogin(String username, String password, String tipoUtente) {
//        try {
//            ILoginAbstractFactory factory = LoginFactoryProducer.getFactoryFromProperties(tipoUtente);
//            Utente utente = factory.login(username, password);
//
//            if (utente != null) {
//                // Imposta l'utente nella sessione
//                SessionManager.getInstance().setCurrentUser(utente);
//            } else {
//                System.out.println("Errore durante il login");
//            }
//        } catch (Exception ex) {
//            throw new RuntimeException("Errore durante il login", ex);
//
//        }
//    }
//
//
//
//
//    public void effettuaLogout() {
//        // Rimuovi l'utente dalla sessione
//        SessionManager.getInstance().setCurrentUser(null);
//        // Torna al menu principale
//    }
//}