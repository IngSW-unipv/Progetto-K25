package it.unipv.ingsfw.treninordovest.factory.implementations;



import it.unipv.ingsfw.treninordovest.model.utenti.cliente.Cliente;
import it.unipv.ingsfw.treninordovest.model.utenti.cliente.ClienteDAOImpl;
import it.unipv.ingsfw.treninordovest.model.utenti.dipendente.Dipendente;
import it.unipv.ingsfw.treninordovest.model.utenti.utente.Utente;
import it.unipv.ingsfw.treninordovest.factory.abstracts.ClienteLoginAbstractFactory;
import it.unipv.ingsfw.treninordovest.view.frames.utenti.clienti.menu.principale.JCustomerMainFrame;


public class ClienteLoginFactoryImpl extends ClienteLoginAbstractFactory {

    private final ClienteDAOImpl clienteDAO; // Usa l'interfaccia, non l'implementazione

    // Costruttore che accetta l'interfaccia
    public ClienteLoginFactoryImpl(ClienteDAOImpl clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    // Costruttore senza parametri per mantenere compatibilità
    public ClienteLoginFactoryImpl() {
        this(new ClienteDAOImpl());
    }

    @Override
    public Cliente login(Cliente cliente) {
        return clienteDAO.autenticateByEmail(cliente);
    }


    @Override
    public void showUserInterface() {
        JCustomerMainFrame frame = new JCustomerMainFrame();
        frame.setVisible(true);
    }
}