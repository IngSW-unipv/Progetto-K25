package it.unipv.ingsfw.treninordovest.facade;

import it.unipv.ingsfw.treninordovest.factory.implementations.LoginFactoryProducer;
import it.unipv.ingsfw.treninordovest.model.utenti.Utente;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;
import it.unipv.ingsfw.treninordovest.factory.abstracts.LoginAbstractFactory;
import it.unipv.ingsfw.treninordovest.view.frames.login.JLoginFrame;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JMainMenuFrame;

import javax.swing.*;

/**
 * Facade che semplifica il processo di login implementata come Singleton
 */
public class LoginFacade {
    
    // Istanza singleton
    private static LoginFacade instance;
    
    /**
     * Costruttore privato per impedire l'istanziazione diretta
     */
    public LoginFacade() {
        // Inizializzazione privata
    }
    
    /**
     * Metodo per ottenere l'istanza singleton
     * @return l'unica istanza di LoginFacade
     */
    public static LoginFacade getInstance() {
        if (instance == null) {
            instance = new LoginFacade();
        }
        return instance;
    }
    
    /**
     * Effettua il login di un utente
     */
    public void effettuaLogin(String username, String password, String tipoUtente,
                              JLoginFrame loginFrame, JComponent componenteParent) {
        try {
            // Ottieni la factory appropriata
            LoginAbstractFactory factory = LoginFactoryProducer.getFactoryFromProperties(tipoUtente);
            
            // Effettua il login
            Utente utente = factory.login(username, password);
            
            if (utente != null) {
                // Imposta l'utente nella sessione
                SessionManager.getInstance().setCurrentUser(utente);
                
                // Mostra l'interfaccia utente
                factory.showUserInterface(utente);
                
                // Chiudi il frame di login
                loginFrame.setVisible(false);

            } else {
                JOptionPane.showMessageDialog(componenteParent, "Credenziali errate!!!");
            }
        } catch (NullPointerException ex) {
            gestisciErroreLogin(ex, componenteParent);
        }
    }



    
    /**
     * Gestisce gli errori durante il login
     */
    private void gestisciErroreLogin(Exception ex, JComponent componenteParent) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(componenteParent, 
                "Si è verificato un errore durante il login", 
                "Errore", JOptionPane.ERROR_MESSAGE);
    }

    public void tornaAlMenu(JFrame currentFrame){
        if (currentFrame != null) {
            currentFrame.dispose();
        }
        JMainMenuFrame mainmenu = new JMainMenuFrame();
        mainmenu.setVisible(true);
    }

    public void effettuaLogout(JFrame currentFrame) {
        // Rimuovi l'utente dalla sessione
        SessionManager.getInstance().setCurrentUser(null);

        // Torna al menu principale
        tornaAlMenu(currentFrame);
    }
}