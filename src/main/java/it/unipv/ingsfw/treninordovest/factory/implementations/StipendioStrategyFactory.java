package it.unipv.ingsfw.treninordovest.factory.implementations;

import it.unipv.ingsfw.treninordovest.strategy.stipendio.IStipendioStrategy;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StipendioStrategyFactory {
    
    private static final Logger LOGGER = Logger.getLogger(StipendioStrategyFactory.class.getName());
    private static final String PROPERTIES_FILE = "properties/properties";
    private static final String PROPERTY_PREFIX = "stipendio.";
    private static final String PROPERTY_SUFFIX = ".strategy.class.name";
    
    /**
     * Restituisce la strategia di calcolo stipendio per il ruolo specificato
     * usando la reflection per caricare la classe dalla configurazione
     * 
     * @param ruolo il ruolo del dipendente
     * @return la strategia di calcolo stipendio
     * @throws RuntimeException se si verifica un errore durante la creazione della strategia
     */
    public static IStipendioStrategy getStrategy(String ruolo) {
        try {
            // Normalizza il ruolo per la ricerca nelle properties
            String ruoloNormalizzato = ruolo.toLowerCase().replaceAll("\\s+", "");
            
            // Carica le properties
            Properties props = new Properties(System.getProperties());
            props.load(new FileInputStream(PROPERTIES_FILE));
            
            // Costruisce la chiave per la property
            String propertyKey = PROPERTY_PREFIX + ruoloNormalizzato + PROPERTY_SUFFIX;
            
            // Ottiene il nome della classe dalla proprietà
            String strategyClassName = props.getProperty(propertyKey);
            
            if (strategyClassName == null) {
                LOGGER.warning("Nessuna strategia configurata per il ruolo: " + ruolo + ". Utilizzando strategia di default.");
                return new StipendioDefault();
            }
            
            // Istanzia la classe usando reflection
            return (IStipendioStrategy) Class.forName(strategyClassName)
                    .getDeclaredConstructor()
                    .newInstance();
            
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "Errore durante la creazione della strategia di stipendio per il ruolo: " + ruolo, e);
            throw new RuntimeException("Impossibile creare la strategia di stipendio: " + e.getMessage(), e);
        }
    }
    
    /**
     * Strategia di default che restituisce uno stipendio base
     * Utilizzata quando non è configurata una strategia specifica per un ruolo
     */
    private static class StipendioDefault implements IStipendioStrategy {
        @Override
        public double calcolaStipendio() {
            return 1200; // Stipendio base di default
        }
    }
}