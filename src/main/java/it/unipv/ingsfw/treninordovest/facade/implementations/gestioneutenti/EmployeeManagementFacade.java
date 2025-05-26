package it.unipv.ingsfw.treninordovest.facade.implementations.gestioneutenti;

import it.unipv.ingsfw.treninordovest.dao.implementations.utenti.DipendenteDAOImpl;
import it.unipv.ingsfw.treninordovest.facade.interfaces.IUserManagementFacade;
import it.unipv.ingsfw.treninordovest.model.utenti.Dipendente;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;

public class EmployeeManagementFacade implements IUserManagementFacade<Dipendente> {

    private static EmployeeManagementFacade instance;

    public static EmployeeManagementFacade getInstance() {
        if (instance == null) {
            instance = new EmployeeManagementFacade();
        }
        return instance;
    }

    @Override
    public Dipendente mostraDati() {

        DipendenteDAOImpl dipendenteDAO = new DipendenteDAOImpl();
        String idUtenteLog = SessionManager.getInstance().getCurrentUser().getId();
        try {
            System.out.println("Mostrazione dati utente");
            return dipendenteDAO.get(idUtenteLog);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean aggiornaPassword(String password) {

        DipendenteDAOImpl dipendenteDAO = new DipendenteDAOImpl();
        String idUtenteLog = SessionManager.getInstance().getCurrentUser().getId();
        try {
            System.out.println("Aggiornamento password");
            return dipendenteDAO.updatePassword(idUtenteLog, password);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void controllaTitolo(){}




}
