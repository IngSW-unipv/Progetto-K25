package it.unipv.ingsfw.treninordovest.factory;

import it.unipv.ingsfw.treninordovest.dao.implementations.utenti.ClienteDAOImpl;
import it.unipv.ingsfw.treninordovest.dao.implementations.utenti.DipendenteDAOImpl;
import it.unipv.ingsfw.treninordovest.dao.interfaces.DAO;
import it.unipv.ingsfw.treninordovest.model.utenti.Cliente;
import it.unipv.ingsfw.treninordovest.model.utenti.Dipendente;
import it.unipv.ingsfw.treninordovest.model.utenti.Utente;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.util.Properties;

public class UtenteDAOFactory {


    public void UtenteDaoFactory() {}

    /*
    public DAO<?> getUtenteDao(String tipoAccesso) {
        if ("Cliente".equalsIgnoreCase(tipoAccesso)) {
            return new ClienteDAOImpl();
        } else if ("Dipendente".equalsIgnoreCase(tipoAccesso)) {
            return new DipendenteDAOImpl();
        } else {
            throw new IllegalArgumentException("Tipo di accesso non supportato: " + tipoAccesso);
        }
    }*/
    private static  Cliente cliente;
    private static Dipendente dipendente;
    private static final String ClPropName = "cliente.class.name";
    private static final String DpPropName = "dipendente.class.name";


    public static Utente getCliente(Utente tipoUtente) {

        if(cliente==null) {
            String clienteClassName ;

            try{
                Properties pr = new Properties(System.getProperties());
                pr.load(new FileInputStream("properties/properties"));
                clienteClassName = pr.getProperty(ClPropName);

                Constructor c = Class.forName(clienteClassName).getConstructor(Utente.class);
                cliente= (Cliente) c.newInstance(tipoUtente);

            }catch (Exception e)
            {
                throw new IllegalArgumentException("Errore nella lettura del file di configurazione",e);
            }



        }
        return cliente;

    }


}


