package it.unipv.ingsfw.treninordovest.model.strategy.pagamento;

import it.unipv.ingsfw.treninordovest.model.factory.login.ILogin;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;

public class PagamentoStrategyFactory {

    private IPagamentoStrategy pagamentoStrategy;

    private final static String PROPERTIES_FILE= "properties/patternproperties";

    public IPagamentoStrategy getFactoryFromProperties(String tipo) {

        try {
            Properties pr = new Properties(System.getProperties());
            pr.load(new FileInputStream(PROPERTIES_FILE));

            // Converte il tipo di utente in minuscolo per la costruzione della chiave
            String tipoLowerCase = tipo.toLowerCase();
            // Costruisce la chiave dinamicamente
            String propertyKey = tipoLowerCase + ".strategy.class.name";


            // Ottiene il nome della classe dalla proprietà
            String factoryClassName = pr.getProperty(propertyKey);


            if (factoryClassName == null)
                System.out.println("Error: property " + propertyKey + " not found");

            Constructor constructor = Class.forName(factoryClassName).getConstructor();
            pagamentoStrategy = (IPagamentoStrategy) constructor.newInstance();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return pagamentoStrategy;

    }


}
