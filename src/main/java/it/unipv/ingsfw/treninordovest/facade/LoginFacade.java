package it.unipv.ingsfw.treninordovest.facade;

import it.unipv.ingsfw.treninordovest.factory.implementations.LoginFactoryProducer;
import it.unipv.ingsfw.treninordovest.model.utenti.Utente;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;
import it.unipv.ingsfw.treninordovest.factory.abstracts.LoginAbstractFactory;
import it.unipv.ingsfw.treninordovest.view.frames.login.JLoginFrame;

import javax.swing.*;

/**
 * Facade che semplifica il processo di login
 */
public class LoginFacade implements ILoginFacade{
    
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
        } catch (Exception ex) {
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
}