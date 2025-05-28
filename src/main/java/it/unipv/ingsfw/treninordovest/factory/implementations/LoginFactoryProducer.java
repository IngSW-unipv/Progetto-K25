package it.unipv.ingsfw.treninordovest.factory.implementations;

import it.unipv.ingsfw.treninordovest.factory.abstracts.ILoginAbstractFactory;

import java.util.Properties;
import java.io.FileInputStream;

/**
 * Factory per creare le istanze appropriate di LoginAbstractFactory
 */
public class LoginFactoryProducer {

    /**
     * Versione che usa reflection e properties come nell'UtenteDAOFactory esistente
     */
    public static ILoginAbstractFactory getFactoryFromProperties(String tipoUtente) {
        try {
            Properties pr = new Properties(System.getProperties());
            pr.load(new FileInputStream("properties/properties"));
        
            // Converte il tipo di utente in minuscolo per la costruzione della chiave
            String tipoUtenteLowerCase = tipoUtente.toLowerCase();
            // Costruisce la chiave dinamicamente
            String propertyKey = tipoUtenteLowerCase + ".factory.class.name";
        
            // Ottiene il nome della classe dalla proprietà
            String factoryClassName = pr.getProperty(propertyKey);
        
            if (factoryClassName == null) {
                throw new IllegalArgumentException("Tipo di utente non supportato: " + tipoUtente);
            }
        
            return (ILoginAbstractFactory) Class.forName(factoryClassName).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Errore nella creazione della factory: " + e.getMessage(), e);
        }
    }
}