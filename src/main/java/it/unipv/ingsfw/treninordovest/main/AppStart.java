package it.unipv.ingsfw.treninordovest.main;

import it.unipv.ingsfw.treninordovest.controller.AcquistoController;
import it.unipv.ingsfw.treninordovest.controller.GestioneTitoliController;
import it.unipv.ingsfw.treninordovest.controller.GestioneUtenzaController;
import it.unipv.ingsfw.treninordovest.controller.RimborsoController;
import it.unipv.ingsfw.treninordovest.model.facade.login.RegistrationFacade;
import it.unipv.ingsfw.treninordovest.model.service.AcquistoService;
import it.unipv.ingsfw.treninordovest.model.service.RimborsoService;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.JTreniNordOvestFrame;

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
                JTreniNordOvestFrame mainFrame = new JTreniNordOvestFrame();
                // Configura e mostra il frame principale
                mainFrame.setVisible(true);

                //Inizializzazione dei controller e iniezione della vista;
                new AcquistoController(mainFrame);
                new GestioneUtenzaController(mainFrame);
                new RimborsoController(mainFrame);
                new GestioneTitoliController(mainFrame);


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