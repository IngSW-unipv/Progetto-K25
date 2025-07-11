package it.unipv.ingsfw.treninordovest.model.factory.implementations;


import it.unipv.ingsfw.treninordovest.exceptions.FactoryException;
import it.unipv.ingsfw.treninordovest.model.strategy.abbonamento.IAbbonamentoStrategy;


import java.io.FileInputStream;
import java.util.Properties;

public class AbbonamentoStrategyFactory {

    private static final String PROPERTIES_FILE = "properties/patternproperties";

    public static IAbbonamentoStrategy getFactoryFromProperties(String tipo) {
        try {
            Properties pr = new Properties(System.getProperties());
            pr.load(new FileInputStream(PROPERTIES_FILE));

            // Converte il tipo di utente in minuscolo per la costruzione della chiave
            String tipoLowerCase = tipo.toLowerCase();
            // Costruisce la chiave dinamicamente
            String propertyKey = tipoLowerCase + ".factory.class.name";

            // Ottiene il nome della classe dalla proprietà
            String factoryClassName = pr.getProperty(propertyKey);

            if (factoryClassName == null) {
                throw new IllegalArgumentException("Tipo di abbonamento non supportato: " + tipo);
            }

            return (IAbbonamentoStrategy) Class.forName(factoryClassName).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new FactoryException("Errore nella creazione della factory degli abbonamenti");
        }
    }
}
