package it.unipv.ingsfw.treninordovest.model.factory.login;

import it.unipv.ingsfw.treninordovest.model.dto.LoginDTO;
import it.unipv.ingsfw.treninordovest.model.utenti.utente.Utente;

public interface ILogin<T> {
   T login(LoginDTO loginDTO);
}
