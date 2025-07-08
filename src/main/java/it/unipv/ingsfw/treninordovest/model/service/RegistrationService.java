package it.unipv.ingsfw.treninordovest.model.service;

import it.unipv.ingsfw.treninordovest.model.dto.LoginDTO;
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


//    public static final String ptNameLogin ="login_success";
//    public static final String ptNameLogout ="logout_success";
//    public static final String ptNameRegCliente ="customer_registration";
//    public static final String ptnRegDipendente ="employee_registration";


    public RegistrationService() {
        this.support = new PropertyChangeSupport(this);
        clienteDAO = new ClienteDAOImpl();
        dipendenteDAO = new DipendenteDAOImpl();
    }


    public boolean login(LoginDTO loginDTO) {
        try {

            ILogin loginFactory =  new LoginFactoryProducer().getFactoryFromProperties(loginDTO.getTipoUtente());
            Utente user = (Utente) loginFactory.login(loginDTO.getId(), loginDTO.getPassword());

            if (user != null) {

                System.out.println("DEBUG: ID Utente:   "+user.getId());

                SessionManager.getInstance().setCurrentUser(user);
//                support.firePropertyChange(ptNameLogin, null, user);
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
//        support.firePropertyChange(ptNameLogout, null, null);
        return true;
    }

    public boolean registraCliente(Cliente cliente){

        try {
            clienteDAO.insert(cliente);
            System.out.println("DEBUG: Registrazione Cliente effettuata con successo -- PCS");
//            support.firePropertyChange(ptNameRegCliente,null,cliente);
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
//            support.firePropertyChange(ptnRegDipendente,null,dipendente);
            return true;

        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }



//    public void addPropertyChangeListener(PropertyChangeListener listener) {
//        support.addPropertyChangeListener(listener);
//    }
//    public void removePropertyChangeListener(PropertyChangeListener listener) {
//        support.removePropertyChangeListener(listener);
//    }


}
