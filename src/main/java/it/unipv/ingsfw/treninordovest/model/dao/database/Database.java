package it.unipv.ingsfw.treninordovest.model.dao.database;

import it.unipv.ingsfw.treninordovest.exceptions.DatabaseConnectionException;
import it.unipv.ingsfw.treninordovest.model.dao.exception.PersistenceException;
import org.hibernate.PersistentObjectException;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Database {

    /*Attributi database */
    private static final String PROPERTYDBDRIVER = "DBDRIVER";
    private static final String PROPERTYDBURL = "DBURL";
    private static final String PROPERTYNAME = "db_usn";
    private static final String PROPERTYPSW = "db_psw";
    private static String username;
    private static String password;
    private static String dbDriver;
    private static String dbURL;
    private static final String filePath="properties/properties";


    private static void init() {
        try {
            Properties p = loadProperties();
            username=p.getProperty(PROPERTYNAME);
            password=p.getProperty(PROPERTYPSW);
            dbDriver =p.getProperty(PROPERTYDBDRIVER);
            dbURL =p.getProperty(PROPERTYDBURL);

        }catch(Exception e) {
            System.err.println("Errore:"+e.getMessage());

        }
    }


    private static Properties loadProperties() {
        Properties p = new Properties();
        try (FileInputStream fis = new FileInputStream(filePath)) {
            p.load(fis);
        }catch(IOException e) {
           // System.err.println("Errore nella lettura dei parametri di connessione: "+e.getMessage());
           // e.printStackTrace();

        }
        return p;
    }

    //Metodo statico di ottenimento della connessione
    public static Connection getConnection()
    {
        Connection conn=null;
        init();
        System.out.println("Debug: "+ dbURL);
        if ( isOpen(conn) )
            closeConnection(conn);
        try
        {
           Class.forName(dbDriver);
           conn = DriverManager.getConnection(dbURL, username, password);// Apertura connessione
        }
        catch (ClassNotFoundException e)
        {
            throw new DatabaseConnectionException("Impossibile trovare i driver JBDC",e);

        } catch (SQLException e) {
           System.out.println("Errore durante la connessione alle base dati: "+ e.getMessage());

        }
        return conn;
    }

    public static boolean isOpen(Connection conn)
    {
        try
        {
            return (conn != null && !conn.isClosed());
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }

    }

    public static Connection closeConnection(Connection conn)
    {
        if ( !isOpen(conn) )
            return null;
        try
        {
            conn.close();
            conn = null;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        return conn;
    }



}
