package it.unipv.ingsfw.treninordovest.model.factory.implementations;

import it.unipv.ingsfw.treninordovest.exceptions.FactoryException;
import it.unipv.ingsfw.treninordovest.model.strategy.validazione.IValidazioneTitoliStrategy;

import java.io.FileInputStream;
import java.util.Properties;

public class ValidazioneTitoliStrategyFactory {
    private static final String PROPERTIES_FILE = "properties/patternproperties";

    public static IValidazioneTitoliStrategy getFactoryFromProperties(String soggettoDaValidare) {
        try {
            Properties pr = new Properties(System.getProperties());
            pr.load(new FileInputStream(PROPERTIES_FILE));

            // Converte il tipo di utente in minuscolo per la costruzione della chiave
            String validoLowerCase = soggettoDaValidare.toLowerCase();
            // Costruisce la chiave dinamicamente
            String propertyKey = validoLowerCase + "Validazione.strategy.class.name";

            // Ottiene il nome della classe dalla proprietà
            String factoryClassName = pr.getProperty(propertyKey);

            if (factoryClassName == null) {
                throw new IllegalArgumentException("Il biglietto non è validato");
            }



            return (IValidazioneTitoliStrategy) Class.forName(factoryClassName).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new FactoryException("Errore nella creazione della factory della validazione dei titoli");
        }
    }



}
