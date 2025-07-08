package it.unipv.ingsfw.treninordovest.model.service;

import it.unipv.ingsfw.treninordovest.model.dto.TitoloDTO;
import it.unipv.ingsfw.treninordovest.model.factory.implementations.AbbonamentoStrategyFactory;
import it.unipv.ingsfw.treninordovest.model.factory.implementations.BigliettoStrategyFactory;
import it.unipv.ingsfw.treninordovest.model.ferrovia.viaggio.Viaggio;
import it.unipv.ingsfw.treninordovest.model.strategy.abbonamento.IAbbonamentoStrategy;
import it.unipv.ingsfw.treninordovest.model.strategy.biglietto.IBigliettoStrategy;
import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.Abbonamento;
import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.AbbonamentoDAOimpl;
import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.Biglietto;
import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.BigliettoDAOImpl;
import it.unipv.ingsfw.treninordovest.model.titoli.pagamento.Pagamento;
import it.unipv.ingsfw.treninordovest.model.titoli.tessera.Tessera;
import it.unipv.ingsfw.treninordovest.model.titoli.tessera.TesseraDAOImpl;
import it.unipv.ingsfw.treninordovest.model.utenti.cliente.Cliente;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.JTreniNordOvestFrame;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalDate;
import java.util.UUID;

public class AcquistoService {
    private AbbonamentoDAOimpl abbonamentoDAO;
    private final BigliettoDAOImpl bigliettoDAO;
    private final TesseraDAOImpl tesseraDAO;
    private Cliente clienteLoggato;
    private final PagamentoService pagamentoService;


    public AcquistoService() {
        this.abbonamentoDAO=new AbbonamentoDAOimpl();
        this.bigliettoDAO=new BigliettoDAOImpl();
        this.tesseraDAO=new TesseraDAOImpl();
        this.pagamentoService=new PagamentoService();

    }

    public boolean acquistoAbbonamento(TitoloDTO titoloDTO) {

        IAbbonamentoStrategy abbonamentoStrategy = AbbonamentoStrategyFactory.getFactoryFromProperties(titoloDTO.getTipoTitolo());
        Abbonamento abbonamento;
        clienteLoggato = (Cliente) SessionManager.getInstance().getCurrentUser();
        Pagamento pag;

        try {
            if (clienteLoggato!=null && clienteLoggato.getTessera().getIdTessera()!=null) {
                abbonamento = abbonamentoStrategy.createAbbonamento(clienteLoggato.getTessera());
                pag =  pagamentoService.effettuaPagamento(titoloDTO.getTipoPagamento(), titoloDTO.getQuantita(), abbonamentoStrategy.ottieniPrezzoAbbonamento());
                abbonamento.setPagamento(pag);

                abbonamentoDAO.insert(abbonamento);
               return true;
            } else if(clienteLoggato.getTessera()==null) {
                System.out.println("Non disponi di una tessera");

            }


        }catch (Exception e) {
            System.out.println("Non disponi di una tessera");
            e.getMessage();
            e.printStackTrace();
            return false;
        }

        return false;

    }

    public boolean acquistoBiglietto(TitoloDTO titoloDTO) {
        clienteLoggato = (Cliente) SessionManager.getInstance().getCurrentUser();
        Pagamento pag;
        Biglietto biglietto;
        IBigliettoStrategy bigliettoStrategy = BigliettoStrategyFactory.getFactoryFromProperties(titoloDTO.getTipoTitolo());

        try {

            if(clienteLoggato!=null) {
               biglietto = bigliettoStrategy.createBiglietto();
               pag = pagamentoService.effettuaPagamento(titoloDTO.getTipoPagamento(), titoloDTO.getQuantita(), bigliettoStrategy.ottieniPrezzoBiglietto());
                biglietto.setPagamento(pag);

               for(int it =0; it<titoloDTO.getQuantita(); it++) {
                   biglietto.setTipoBiglietto(titoloDTO.getTipoTitolo());
                   biglietto.setViaggio(new Viaggio(titoloDTO.getIdViaggio()));
                   bigliettoDAO.insert(biglietto);
                   biglietto.setId(UUID.randomUUID().toString());
               }

               return true;
            }

        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }


    public boolean acquistoTessera() {

        clienteLoggato = (Cliente) SessionManager.getInstance().getCurrentUser();

        try {
            if (!(tesseraDAO.exists(clienteLoggato.getId().toString())) && clienteLoggato != null) {
                Tessera tessera = new Tessera(UUID.randomUUID());
                if (tesseraDAO.createTessera(tessera, clienteLoggato.getId().toString()))
                    return true;

            }


        } catch (Exception e) {
            e.printStackTrace();

        }


        return false;
    }








}
