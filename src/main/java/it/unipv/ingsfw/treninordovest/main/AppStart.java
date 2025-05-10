package it.unipv.ingsfw.treninordovest.main;

import it.unipv.ingsfw.treninordovest.controller.misc.MainMenuController;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JMainMenuFrame;

import javax.swing.*;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * Punto di ingresso dell'applicazione che inizializza e configura tutti i componenti necessari.
 */
public class AppStart {
    
    private static final Logger LOGGER = Logger.getLogger(AppStart.class.getName());
    
    /**
     * Metodo main che avvia l'applicazione
     * @param args argomenti da linea di comando (non utilizzati)
     */
    public static void main(String[] args) {
        // Configurazione Look and Feel nativo del sistema
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            LOGGER.log(Level.WARNING, "Impossibile impostare il Look and Feel nativo", e);
            // Continua con il look and feel predefinito
        }
        
        // Avvio dell'applicazione nel thread di eventi Swing
        SwingUtilities.invokeLater(() -> {
            try {
                // Crea la finestra principale
                JMainMenuFrame mainFrame = new JMainMenuFrame();
                
                // Configura e mostra il frame principale
                mainFrame.setTitle("TreniNordOvest");
                mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                mainFrame.setLocationRelativeTo(null);
                mainFrame.setVisible(true);
                
                // Il controller viene già creato all'interno del JMainMenuFrame
                // in base alla tua struttura attuale
            } catch (Exception e) {
                LOGGER.log(Level.SEVERE, "Errore durante l'inizializzazione dell'applicazione", e);
                JOptionPane.showMessageDialog(
                    null,
                    "Si è verificato un errore durante l'avvio dell'applicazione: " + e.getMessage(),
                    "Errore di Avvio",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        });
    }
}