package it.unipv.ingsfw.treninordovest.model.factory.login;

import java.lang.reflect.Constructor;
import java.util.Properties;
import java.io.FileInputStream;

/**
 * Factory per creare le istanze appropriate di LoginAbstractFactory
 */


public class LoginFactoryProducer {

    private ILogin login=null;

    public  ILogin getFactoryFromProperties(String tipo) {

            try {
                Properties pr = new Properties(System.getProperties());
                pr.load(new FileInputStream("properties/properties"));

                // Converte il tipo di utente in minuscolo per la costruzione della chiave
                String tipoLowerCase = tipo.toLowerCase();
                // Costruisce la chiave dinamicamente
                String propertyKey = tipoLowerCase + "Login.factory.class.name";


                // Ottiene il nome della classe dalla proprietà
                String factoryClassName = pr.getProperty(propertyKey);


                if (factoryClassName == null)
                    System.out.println("Error: property " + propertyKey + " not found");

                Constructor constructor = Class.forName(factoryClassName).getConstructor();
                 login = (ILogin) constructor.newInstance();


                //return (ILogin) Class.forName(factoryClassName).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
                login = null;
            }



        return  login;

    }



}