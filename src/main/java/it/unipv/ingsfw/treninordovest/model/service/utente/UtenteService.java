package it.unipv.ingsfw.treninordovest.model.service.utente;

import it.unipv.ingsfw.treninordovest.model.utenti.cliente.Cliente;
import it.unipv.ingsfw.treninordovest.model.utenti.cliente.ClienteDAOImpl;
import it.unipv.ingsfw.treninordovest.model.utenti.dipendente.Dipendente;
import it.unipv.ingsfw.treninordovest.model.utenti.dipendente.DipendenteDAOImpl;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class UtenteService {

    private ClienteDAOImpl clienteDAO;
    private DipendenteDAOImpl dipendenteDAO;
    PropertyChangeSupport propertyChangeSupport;

    public UtenteService() {
        this.clienteDAO = new ClienteDAOImpl();
        this.dipendenteDAO=new DipendenteDAOImpl();
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public boolean aggiornaDatiCliente(){
        Cliente clienteAggiornato;
        Cliente clienteAttuale = (Cliente) SessionManager.getInstance().getCurrentUser();
        if(clienteAttuale!=null) {
            clienteAggiornato = clienteDAO.get(clienteAttuale);
            SessionManager.getInstance().setCurrentUser(clienteAggiornato);
            return true;
        }
        return false;
    }

    public boolean aggiornaPasswordCliente(String nuovaPassword){

        Cliente clienteAttuale = (Cliente) SessionManager.getInstance().getCurrentUser();

        Cliente dtoPassword = new Cliente(clienteAttuale.getId(),nuovaPassword);

        if(clienteAttuale!=null) {
            if(clienteDAO.updatePassword(dtoPassword)){
                System.out.println("DEBUG:Password aggiornata con successo");
                return true;
            }
        }
        return false;
    }

    public boolean aggiornaPasswordDipendente(String nuovaPassword){
        Dipendente dipendenteAttuale = (Dipendente) SessionManager.getInstance().getCurrentUser();
        Dipendente dtoPassword = new Dipendente(dipendenteAttuale.getId().toString(),nuovaPassword);
        if(dipendenteAttuale!=null) {
            if(dipendenteDAO.updatePassword(dtoPassword)){
                System.out.println("DEBUG:Password aggiornata con successo");
                return true;
            }
        }
        return false;
    }

    public Dipendente aggiornaDatiDipendente(){
        Dipendente dipendenteAggiornato = null;
        Dipendente dipendenteAttuale = (Dipendente) SessionManager.getInstance().getCurrentUser();
        if(dipendenteAttuale!=null) {
            dipendenteAggiornato = dipendenteDAO.get(dipendenteAttuale);
            SessionManager.getInstance().setCurrentUser(dipendenteAggiornato);
            return dipendenteAggiornato;
        }
        return false;
    }



}
