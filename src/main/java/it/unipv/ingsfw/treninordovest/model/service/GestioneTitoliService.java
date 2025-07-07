package it.unipv.ingsfw.treninordovest.model.service;

import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.Abbonamento;
import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.AbbonamentoDAOimpl;
import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.Biglietto;
import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.BigliettoDAOImpl;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class GestioneTitoliService {

    private final AbbonamentoDAOimpl abbonamentoDAO;
    private final BigliettoDAOImpl bigliettoDAO;
    PropertyChangeSupport propertyChangeSupport;


    public GestioneTitoliService() {
        abbonamentoDAO = new AbbonamentoDAOimpl();
        bigliettoDAO = new BigliettoDAOImpl();
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    //Lista degli abbonamenti
    public void getTitoliAbbonamento(){
        String clienteLoggato = SessionManager.getInstance().getCurrentUser().getId().toString();
         List<Abbonamento> abbonamentoList = abbonamentoDAO.getAllAbbonamentiByCliente(clienteLoggato);

        propertyChangeSupport.firePropertyChange("get_titoliAbbonamenti_acq",null,abbonamentoList);

    }

    public void getTitoliBiglietto(){
        String clienteLoggato= SessionManager.getInstance().getCurrentUser().getId().toString();
        List<Biglietto> bigliettiList = bigliettoDAO.getAllBigliettiByCliente(clienteLoggato);

        propertyChangeSupport.firePropertyChange("get_titoliBiglietti_acq",null,bigliettiList);

    }

    public boolean controllaTitoloViaggio(){



        return false;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }







}
