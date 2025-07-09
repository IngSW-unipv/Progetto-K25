package it.unipv.ingsfw.treninordovest.model.service.titoli;

import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.Abbonamento;
import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.AbbonamentoDAOimpl;
import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.Biglietto;
import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.BigliettoDAOImpl;
import it.unipv.ingsfw.treninordovest.model.titoli.titoloviaggio.TitoloViaggio;
import it.unipv.ingsfw.treninordovest.model.utenti.dipendente.Dipendente;
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


    //METODO DA RIVISITARE
    public boolean controllaTitoloViaggio(String idTitolo){
        Dipendente dipendenteLoggato = (Dipendente) SessionManager.getInstance().getCurrentUser();
        TitoloViaggio titoloViaggio;
        if(dipendenteLoggato!=null) {
            if(abbonamentoDAO.get(new Abbonamento(idTitolo)) != null){
               titoloViaggio = abbonamentoDAO.get(new Abbonamento(idTitolo));
                return titoloViaggio.isValido();
            }else if(bigliettoDAO.get(new Biglietto(idTitolo)) != null){
                titoloViaggio = bigliettoDAO.get(new Biglietto(idTitolo));
                return titoloViaggio.isValido();
            }
        }
        return false;
    }







}
