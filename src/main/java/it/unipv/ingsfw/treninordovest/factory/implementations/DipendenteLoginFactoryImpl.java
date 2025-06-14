package it.unipv.ingsfw.treninordovest.factory.implementations;


import it.unipv.ingsfw.treninordovest.model.utenti.dipendente.Dipendente;
import it.unipv.ingsfw.treninordovest.model.utenti.dipendente.DipendenteDAOImpl;
import it.unipv.ingsfw.treninordovest.model.utenti.utente.Utente;
import it.unipv.ingsfw.treninordovest.factory.abstracts.DipendenteLoginAbstractFactory;
import it.unipv.ingsfw.treninordovest.view.frames.utenti.dipendenti.menu.principale.JEmployeeMainFrame;


public class DipendenteLoginFactoryImpl extends DipendenteLoginAbstractFactory{

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
    public Dipendente login(Dipendente dipendente) {
        return null;
    }

    @Override
    public void showUserInterface() {
        JEmployeeMainFrame frame = new JEmployeeMainFrame();
        frame.setVisible(true);
    }
}