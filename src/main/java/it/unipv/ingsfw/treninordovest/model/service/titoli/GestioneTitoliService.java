package it.unipv.ingsfw.treninordovest.model.service.titoli;

import it.unipv.ingsfw.treninordovest.model.dto.TitoloDTO;
import it.unipv.ingsfw.treninordovest.model.factory.implementations.ValidazioneTitoliStrategyFactory;
import it.unipv.ingsfw.treninordovest.model.strategy.validazione.IValidazioneTitoliStrategy;
import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.Abbonamento;
import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.AbbonamentoDAOimpl;
import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.Biglietto;
import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.BigliettoDAOImpl;
import it.unipv.ingsfw.treninordovest.model.utenti.dipendente.Dipendente;
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
         List<Abbonamento> abbonamentoList = abbonamentoDAO.getAllAbbonamentiByCliente(clienteLoggato);

         return abbonamentoList;
    }

    public List<Biglietto> getTitoliBiglietto(){
        String clienteLoggato= SessionManager.getInstance().getCurrentUser().getId().toString();
        List<Biglietto> bigliettiList = bigliettoDAO.getAllBigliettiByCliente(clienteLoggato);

        return bigliettiList;

    }


    public boolean controllaTitoloViaggio(TitoloDTO titoloDTO){
        Dipendente dipendenteLoggato = (Dipendente) SessionManager.getInstance().getCurrentUser();
        if(dipendenteLoggato!=null) {
            IValidazioneTitoliStrategy validazioneTitoliStrategy = ValidazioneTitoliStrategyFactory.getFactoryFromProperties(titoloDTO.getTipoTitolo());
            if(validazioneTitoliStrategy.getValidazione(titoloDTO.getId().toString())){
                System.out.println("DEBUG: Service Controllo Eseguito");
                return true;
            } else {
                validazioneTitoliStrategy.valida(titoloDTO.getId().toString());
                System.out.println("DEBUG: Validazione in corso");
            }


        }

        return false;
    }







}
