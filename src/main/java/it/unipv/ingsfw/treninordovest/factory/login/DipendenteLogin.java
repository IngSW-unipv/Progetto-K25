package it.unipv.ingsfw.treninordovest.factory.login;


import it.unipv.ingsfw.treninordovest.model.utenti.dipendente.Dipendente;
import it.unipv.ingsfw.treninordovest.model.utenti.dipendente.DipendenteDAOImpl;
import it.unipv.ingsfw.treninordovest.model.utenti.utente.Utente;

public class DipendenteLogin implements ILogin<Dipendente> {
    @Override
    public Dipendente login(String username, String password) {
        DipendenteDAOImpl dipendenteDAO = new DipendenteDAOImpl();
        return dipendenteDAO.get(new Dipendente(username, password));
    }
}
