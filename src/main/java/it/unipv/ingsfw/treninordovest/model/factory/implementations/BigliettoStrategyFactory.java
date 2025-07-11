package it.unipv.ingsfw.treninordovest.model.factory.implementations;



import it.unipv.ingsfw.treninordovest.exceptions.FactoryException;
import it.unipv.ingsfw.treninordovest.model.strategy.biglietto.IBigliettoStrategy;

import java.io.FileInputStream;
import java.util.Properties;

public class BigliettoStrategyFactory {

    private static final String PROPERTIES_FILE = "properties/patternproperties";

    public static IBigliettoStrategy getFactoryFromProperties(String tipo) {
        try {
            Properties pr = new Properties(System.getProperties());
            pr.load(new FileInputStream(PROPERTIES_FILE));

            // Converte il tipo di utente in minuscolo per la costruzione della chiave
            String tipoLowerCase = tipo.toLowerCase();
            // Costruisce la chiave dinamicamente
            String propertyKey = tipoLowerCase + ".strategy.class.name";

            // Ottiene il nome della classe dalla proprietà
            String factoryClassName = pr.getProperty(propertyKey);

            if (factoryClassName == null) {
                throw new IllegalArgumentException("Tipo di biglietto non supportato: " + tipo);
            }



            return (IBigliettoStrategy) Class.forName(factoryClassName).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new FactoryException("Errore nella creazione della factory dei biglietti");
        }
    }
}
