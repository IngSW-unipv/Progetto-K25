package it.unipv.ingsfw.treninordovest.factory.implementations;

import it.unipv.ingsfw.treninordovest.factory.interfaces.IAbbonamentoFactory;


import java.io.FileInputStream;
import java.util.Properties;

public class AbbonamentoStrategyFactory {
    public static IAbbonamentoFactory getFactoryFromProperties(String tipo) {
        try {
            Properties pr = new Properties(System.getProperties());
            pr.load(new FileInputStream("properties/properties"));

            // Converte il tipo di utente in minuscolo per la costruzione della chiave
            String tipoLowerCase = tipo.toLowerCase();
            // Costruisce la chiave dinamicamente
            String propertyKey = tipoLowerCase + ".factory.class.name";

            // Ottiene il nome della classe dalla proprietà
            String factoryClassName = pr.getProperty(propertyKey);

            if (factoryClassName == null) {
                throw new IllegalArgumentException("Tipo di abbonamento non supportato: " + tipo);
            }

            return (IAbbonamentoFactory) Class.forName(factoryClassName).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Errore nella creazione della factory: " + e.getMessage(), e);
        }
    }
}
