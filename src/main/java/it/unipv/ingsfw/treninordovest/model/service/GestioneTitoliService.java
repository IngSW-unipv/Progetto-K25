package it.unipv.ingsfw.treninordovest.model.service;

import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.Abbonamento;
import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.AbbonamentoDAOimpl;
import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.Biglietto;
import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.BigliettoDAOImpl;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;

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
        return abbonamentoDAO.getAllAbbonamentiByCliente(clienteLoggato);
    }

    public List<Biglietto> getTitoliBiglietto(){
        String clienteLoggato= SessionManager.getInstance().getCurrentUser().getId().toString();
        return bigliettoDAO.getAllBigliettiByCliente(clienteLoggato);
    }

    public boolean controllaTitoloViaggio(){



        return false;
    }







}
