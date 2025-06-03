package it.unipv.ingsfw.treninordovest.facade.implementations.gestioneutenti;

import it.unipv.ingsfw.treninordovest.dao.implementations.utenti.DipendenteDAOImpl;
import it.unipv.ingsfw.treninordovest.dao.interfaces.DipendenteDAO;
import it.unipv.ingsfw.treninordovest.facade.interfaces.IUserManagementFacade;
import it.unipv.ingsfw.treninordovest.model.utenti.Dipendente;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;

public class EmployeeManagementFacade implements IUserManagementFacade<Dipendente> {

        private final DipendenteDAO dipendenteDAO;

        public EmployeeManagementFacade() {
            this.dipendenteDAO = new DipendenteDAOImpl();

        }


    @Override
    public Dipendente mostraDati() {
        String idUtenteLog = SessionManager.getInstance().getCurrentUser().getId();
        try {
            System.out.println("Stampa dati utente");
            return dipendenteDAO.get(idUtenteLog);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean aggiornaPassword(String password) {

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
