package it.unipv.ingsfw.treninordovest.model.factory.login;


import it.unipv.ingsfw.treninordovest.model.utenti.dipendente.Dipendente;
import it.unipv.ingsfw.treninordovest.model.utenti.dipendente.DipendenteDAOImpl;

public class DipendenteLogin implements ILogin<Dipendente> {
    @Override
    public Dipendente login(String username, String password) {
        DipendenteDAOImpl dipendenteDAO = new DipendenteDAOImpl();
        return dipendenteDAO.get(new Dipendente(username, password));
    }
}
