package it.unipv.ingsfw.treninordovest.model.factory.login;


import it.unipv.ingsfw.treninordovest.model.dto.LoginDTO;
import it.unipv.ingsfw.treninordovest.model.utenti.dipendente.Dipendente;
import it.unipv.ingsfw.treninordovest.model.utenti.dipendente.DipendenteDAOImpl;

public class DipendenteLogin implements ILogin<Dipendente> {
    @Override
    public Dipendente login(LoginDTO loginDTO) {
        DipendenteDAOImpl dipendenteDAO = new DipendenteDAOImpl();
        return dipendenteDAO.autenticate(new Dipendente(loginDTO));
    }
}
