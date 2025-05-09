package it.unipv.ingsfw.treninordovest.factory.implementations;

import it.unipv.ingsfw.treninordovest.dao.implementations.utenti.DipendenteDAOImpl;
import it.unipv.ingsfw.treninordovest.model.utenti.Utente;
import it.unipv.ingsfw.treninordovest.factory.abstracts.DipendenteLoginAbstractFactory;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JEmployeeMainFrame;

public class DipendenteLoginFactoryImpl extends DipendenteLoginAbstractFactory {

    private final DipendenteDAOImpl dipendenteDAO;

    public DipendenteLoginFactoryImpl() {
        this.dipendenteDAO = new DipendenteDAOImpl();
    }

    @Override
    public Utente login(String username, String password) {
        return dipendenteDAO.autenticate(username,password);

    }

    @Override
    public void showUserInterface(Utente utente) {
        JEmployeeMainFrame frame = new JEmployeeMainFrame();
        frame.setVisible(true);

    }
}
