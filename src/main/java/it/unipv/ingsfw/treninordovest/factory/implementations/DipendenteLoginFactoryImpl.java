package it.unipv.ingsfw.treninordovest.factory.implementations;

import it.unipv.ingsfw.treninordovest.dao.implementations.utenti.DipendenteDAOImpl;
import it.unipv.ingsfw.treninordovest.model.utenti.Utente;
import it.unipv.ingsfw.treninordovest.factory.abstracts.DipendenteLoginAbstractFactory;
import it.unipv.ingsfw.treninordovest.view.frames.employee.JEmployeeMainFrame;

public class DipendenteLoginFactoryImpl extends DipendenteLoginAbstractFactory {

    private final DipendenteDAOImpl dipendenteDAO; // Usa l'interfaccia, non l'implementazione

    // Costruttore che accetta l'interfaccia
    public DipendenteLoginFactoryImpl(DipendenteDAOImpl dipendenteDAO) {
        this.dipendenteDAO = dipendenteDAO;
    }
    
    // Costruttore senza parametri per mantenere compatibilità
    public DipendenteLoginFactoryImpl() {
        this(new DipendenteDAOImpl());
    }

    @Override
    public Utente login(String username, String password) {
        return dipendenteDAO.autenticate(username, password);
    }

    @Override
    public void showUserInterface(Utente utente) {
        JEmployeeMainFrame frame = new JEmployeeMainFrame();
        frame.setVisible(true);
    }
}