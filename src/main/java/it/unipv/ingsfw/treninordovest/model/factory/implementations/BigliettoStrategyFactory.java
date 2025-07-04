package it.unipv.ingsfw.treninordovest.model.factory.implementations;



import it.unipv.ingsfw.treninordovest.model.strategy.biglietto.IBigliettoStrategy;

import java.io.FileInputStream;
import java.util.Properties;

public class BigliettoStrategyFactory {
    public static IBigliettoStrategy getFactoryFromProperties(String tipo) {
        try {
            Properties pr = new Properties(System.getProperties());
            pr.load(new FileInputStream("properties/properties"));

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
            throw new RuntimeException("Errore nella creazione della factory: " + e.getMessage(), e);
        }
    }
}
