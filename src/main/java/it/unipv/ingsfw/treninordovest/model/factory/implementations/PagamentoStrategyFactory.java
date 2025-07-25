package it.unipv.ingsfw.treninordovest.model.factory.implementations;

import it.unipv.ingsfw.treninordovest.exceptions.FactoryException;
import it.unipv.ingsfw.treninordovest.model.strategy.pagamento.IPagamentoStrategy;

import java.io.FileInputStream;
import java.util.Properties;

public class PagamentoStrategyFactory {

    private static final String PROPERTIES_FILE = "properties/patternproperties";

    public static IPagamentoStrategy getFactoryFromProperties(String tipo) {
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
                throw new IllegalArgumentException("Tipo non supportato: " + tipo);
            }

            return (IPagamentoStrategy) Class.forName(factoryClassName).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new FactoryException("Errore nella creazione della factory dei pagamenti" );
        }
    }

}
