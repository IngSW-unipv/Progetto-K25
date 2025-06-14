package it.unipv.ingsfw.treninordovest.factory.login;

import it.unipv.ingsfw.treninordovest.model.utenti.cliente.ClienteDAOImpl;
import it.unipv.ingsfw.treninordovest.model.utenti.dipendente.Dipendente;
import it.unipv.ingsfw.treninordovest.model.utenti.dipendente.DipendenteDAOImpl;

public class DipendenteLoginAdapter implements IDipendenteLogin{
    @Override
    public Dipendente login(Dipendente dipendente) {
        DipendenteDAOImpl dao = new DipendenteDAOImpl();
        return null;
    }
}
