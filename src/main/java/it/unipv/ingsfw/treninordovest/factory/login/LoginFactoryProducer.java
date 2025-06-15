package it.unipv.ingsfw.treninordovest.factory.login;

import java.lang.reflect.Constructor;
import java.util.Properties;
import java.io.FileInputStream;

/**
 * Factory per creare le istanze appropriate di LoginAbstractFactory
 */


public class LoginFactoryProducer {

    public static ILogin getFactoryFromProperties(String tipoUtente) {
        try {
            Properties pr = new Properties();
            pr.load(new FileInputStream("properties/properties"));
            String key = tipoUtente.toLowerCase() + ".factory.class.name";
            String className = pr.getProperty(key);
            if (className == null) {
                throw new IllegalArgumentException("Tipo utente non supportato: " + tipoUtente);
            }

            Class<?> cls = Class.forName(className);
            Constructor<? extends ILogin> ctor = cls.asSubclass(ILogin.class).getConstructor();
            return ctor.newInstance();

        } catch (Exception e) {
            throw new RuntimeException("Errore nel creare factory per " + tipoUtente, e);
        }
    }



}