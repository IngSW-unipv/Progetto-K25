package it.unipv.ingsfw.treninordovest.model.service;

import it.unipv.ingsfw.treninordovest.model.utenti.cliente.Cliente;
import it.unipv.ingsfw.treninordovest.model.utenti.cliente.ClienteDAOImpl;
import it.unipv.ingsfw.treninordovest.model.utenti.dipendente.Dipendente;
import it.unipv.ingsfw.treninordovest.model.utenti.dipendente.DipendenteDAOImpl;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

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
            propertyChangeSupport.firePropertyChange("cliente_aggiornato", null, clienteAggiornato);
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
        return false;
    }

    public boolean aggiornaDatiDipendente(){
        Dipendente dipendenteAggiornato;
        Dipendente dipendenteAttuale = (Dipendente) SessionManager.getInstance().getCurrentUser();
        if(dipendenteAttuale!=null) {
            dipendenteAggiornato = dipendenteDAO.get(dipendenteAttuale);
            SessionManager.getInstance().setCurrentUser(dipendenteAggiornato);
            propertyChangeSupport.firePropertyChange("dipendente_aggiornato", null, dipendenteAggiornato);
            return true;
        }
        return false;
    }


    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }


}
