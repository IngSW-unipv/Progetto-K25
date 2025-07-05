package it.unipv.ingsfw.treninordovest.model.service;

import it.unipv.ingsfw.treninordovest.model.factory.login.ILogin;
import it.unipv.ingsfw.treninordovest.model.factory.login.LoginFactoryProducer;
import it.unipv.ingsfw.treninordovest.model.utenti.cliente.Cliente;
import it.unipv.ingsfw.treninordovest.model.utenti.cliente.ClienteDAOImpl;
import it.unipv.ingsfw.treninordovest.model.utenti.dipendente.Dipendente;
import it.unipv.ingsfw.treninordovest.model.utenti.dipendente.DipendenteDAOImpl;
import it.unipv.ingsfw.treninordovest.model.utenti.utente.Utente;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class RegistrationService {


    private final PropertyChangeSupport support ;
    private final ClienteDAOImpl clienteDAO;
    private final DipendenteDAOImpl dipendenteDAO ;

    public RegistrationService() {
        this.support = new PropertyChangeSupport(this);
        clienteDAO = new ClienteDAOImpl();
        dipendenteDAO = new DipendenteDAOImpl();
    }


    public boolean login(String id, String password,String tipoUtente) {
        try {

            ILogin loginFactory =  new LoginFactoryProducer().getFactoryFromProperties(tipoUtente);
            Utente user = (Utente) loginFactory.login(id, password);

            if (user != null) {

                System.out.println("DEBUG: ID Utente:   "+user.getId());

                SessionManager.getInstance().setCurrentUser(user);
                support.firePropertyChange("login_success", null, user);
                return true;
            }


        }catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }


    public boolean logout() {
        SessionManager.getInstance().logout();
        System.out.println("DEBUG: Login effettuato con successo -- PCS");
        support.firePropertyChange("logout_success", null, null);
        return true;
    }

    public boolean registraCliente(Cliente cliente){

        try {
            clienteDAO.insert(cliente);
            System.out.println("DEBUG: Registrazione Cliente effettuata con successo -- PCS");
            support.firePropertyChange("customer_registration",null,cliente);
            return true;


        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public boolean registraDipendente(Dipendente dipendente){

        try {
            dipendenteDAO.insert(dipendente);
            System.out.println("DEBUG: Registrazione Dipendente effettuata con successo");
            support.firePropertyChange("employee_registration",null,dipendente);
            return true;

        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }



    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        support.removePropertyChangeListener(listener);
    }


}
