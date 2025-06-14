package it.unipv.ingsfw.treninordovest.factory.login;

import it.unipv.ingsfw.treninordovest.model.utenti.dipendente.Dipendente;

public interface IDipendenteLogin {
    Dipendente login(Dipendente dipendente);
}
