package it.unipv.ingsfw.treninordovest.factory.implementations;


import it.unipv.ingsfw.treninordovest.dao.implementations.utenti.ClienteDAOImpl;
import it.unipv.ingsfw.treninordovest.model.utenti.Utente;
import it.unipv.ingsfw.treninordovest.factory.abstracts.ClienteLoginAbstractFactory;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JCustomerMainFrame;

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
    public Utente login(String username, String password) {
        return clienteDAO.autenticate(username, password);
    }

    @Override
    public void showUserInterface(Utente utente) {
        JCustomerMainFrame frame = new JCustomerMainFrame();
        frame.setVisible(true);
    }
}