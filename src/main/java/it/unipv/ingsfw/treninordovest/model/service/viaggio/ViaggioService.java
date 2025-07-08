package it.unipv.ingsfw.treninordovest.model.service.viaggio;

import it.unipv.ingsfw.treninordovest.model.ferrovia.viaggio.Viaggio;
import it.unipv.ingsfw.treninordovest.model.ferrovia.viaggio.ViaggioDAOImpl;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class ViaggioService {

    private final ViaggioDAOImpl viaggioDAO;

    public ViaggioService() {
        this.viaggioDAO = new ViaggioDAOImpl();
    }
    //Lista dei viaggi da mostrare
    public List<Viaggio> getViaggiDisponibili(){
        System.out.println("DEBUG: Viaggi recepiti");
        return viaggioDAO.getAll();
    }







}
