package it.unipv.ingsfw.treninordovest.model.service;

import it.unipv.ingsfw.treninordovest.model.ferrovia.viaggio.Viaggio;
import it.unipv.ingsfw.treninordovest.model.ferrovia.viaggio.ViaggioDAOImpl;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

public class ViaggioService {

    private ViaggioDAOImpl viaggioDAO;
    PropertyChangeSupport propertyChangeSupport;

    public ViaggioService() {
        this.viaggioDAO = new ViaggioDAOImpl();
        propertyChangeSupport = new PropertyChangeSupport(this);
    }
    //Lista dei viaggi da mostrare
    public void getViaggiDisponibili(){
       List<Viaggio> viaggi;
        viaggi=viaggioDAO.getAll();

        propertyChangeSupport.firePropertyChange("ottieni_viaggi_disponibili", null, viaggi);
        System.out.println("DEBUG: Viaggi recepiti -- PCS");
    }

   public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
   }
   public void removePropertyChangeListener(PropertyChangeListener listener) {
       propertyChangeSupport.removePropertyChangeListener(listener);
   }






}
