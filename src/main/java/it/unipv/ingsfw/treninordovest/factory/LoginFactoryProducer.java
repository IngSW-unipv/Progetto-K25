package it.unipv.ingsfw.treninordovest.factory;

import it.unipv.ingsfw.treninordovest.factory.abstracts.LoginAbstractFactory;

import java.util.Properties;
import java.io.FileInputStream;

/**
 * Factory per creare le istanze appropriate di LoginAbstractFactory
 */
public class LoginFactoryProducer {
    
    private static final String CLIENTE_FACTORY_PROP = "cliente.factory.class.name";
    private static final String DIPENDENTE_FACTORY_PROP = "dipendente.factory.class.name";


    /**
     * Versione che usa reflection e properties come nell'UtenteDAOFactory esistente
     */
    public static LoginAbstractFactory getFactoryFromProperties(String tipoUtente) {
        try {
            Properties pr = new Properties(System.getProperties());
            pr.load(new FileInputStream("properties/properties"));
            
            String factoryClassName;
            if ("Cliente".equals(tipoUtente)) {
                factoryClassName = pr.getProperty(CLIENTE_FACTORY_PROP, 
                                              "it.unipv.ingsfw.treninordovest.factory.implementations.ClienteLoginFactoryImpl");
            } else if ("Dipendente".equals(tipoUtente)) {
                factoryClassName = pr.getProperty(DIPENDENTE_FACTORY_PROP, 
                                              "it.unipv.ingsfw.treninordovest.factory.implementations.DipendenteLoginFactoryImpl");
            } else {
                throw new IllegalArgumentException("Tipo di utente non supportato: " + tipoUtente);
            }
            
            return (LoginAbstractFactory) Class.forName(factoryClassName).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Errore nella creazione della factory: " + e.getMessage(), e);
        }
    }
}