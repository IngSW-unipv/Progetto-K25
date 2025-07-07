package it.unipv.ingsfw.treninordovest.model.facade.utente;

public interface IUtenteFacade {

    boolean aggiornaProfiloCliente();
    boolean aggiornaProfiloDipendente();
    boolean aggiornaPasswordCliente(String password);
    boolean aggiornaPasswordDipendente(String password);
}
