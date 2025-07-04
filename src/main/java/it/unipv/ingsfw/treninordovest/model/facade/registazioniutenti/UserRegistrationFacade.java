package it.unipv.ingsfw.treninordovest.model.facade.registazioniutenti;


import it.unipv.ingsfw.treninordovest.model.utenti.cliente.Cliente;
import it.unipv.ingsfw.treninordovest.model.utenti.cliente.ClienteDAOImpl;
import it.unipv.ingsfw.treninordovest.model.utenti.dipendente.Dipendente;
import it.unipv.ingsfw.treninordovest.model.utenti.dipendente.DipendenteDAOImpl;

public class UserRegistrationFacade implements IUserRegistrationFacade {


    private ClienteDAOImpl clienteDAO;
    private DipendenteDAOImpl dipendenteDAO;

    /**
     * Costruttore privato per implementare il Singleton
     */
    public UserRegistrationFacade() {
        clienteDAO = new ClienteDAOImpl();
        dipendenteDAO = new DipendenteDAOImpl();
    }

    @Override
    public boolean registraCliente(Cliente cliente) {

        try {
            clienteDAO.insert(cliente);
            return true;

        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean registraDipendente(Dipendente dipendente) {

        try {
            dipendenteDAO.insert(dipendente);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }





}