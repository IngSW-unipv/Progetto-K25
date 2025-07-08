package it.unipv.ingsfw.treninordovest.model.service.titoli;

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


    public GestioneTitoliService() {
        abbonamentoDAO = new AbbonamentoDAOimpl();
        bigliettoDAO = new BigliettoDAOImpl();
    }

    //Lista degli abbonamenti
    public List<Abbonamento> getTitoliAbbonamento(){
        String clienteLoggato = SessionManager.getInstance().getCurrentUser().getId().toString();
         List<Abbonamento> abbonamentoList = abbonamentoDAO.getAllAbbonamentiByCliente(clienteLoggato);

         return abbonamentoList;
    }

    public List<Biglietto> getTitoliBiglietto(){
        String clienteLoggato= SessionManager.getInstance().getCurrentUser().getId().toString();
        List<Biglietto> bigliettiList = bigliettoDAO.getAllBigliettiByCliente(clienteLoggato);

        return bigliettiList;

    }

    public boolean controllaTitoloViaggio(){


        return false;
    }







}
