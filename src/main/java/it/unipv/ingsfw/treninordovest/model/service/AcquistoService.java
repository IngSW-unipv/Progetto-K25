package it.unipv.ingsfw.treninordovest.model.service;


import it.unipv.ingsfw.treninordovest.model.dto.PagamentoDTO;
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


import java.util.UUID;

public class AcquistoService {
    private final AbbonamentoDAOimpl abbonamentoDAO;
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

                if (clienteLoggato==null){
                    System.out.println("Utente non loggato");
                    return false;
                }


            if (clienteLoggato.getTessera().getIdTessera() != null) {
                abbonamento = abbonamentoStrategy.createAbbonamento(clienteLoggato.getTessera());
                PagamentoDTO pagamentoDTO = new PagamentoDTO(titoloDTO.getTipoPagamento(), titoloDTO.getQuantita(), abbonamentoStrategy.ottieniPrezzoAbbonamento());
                pag =  pagamentoService.effettuaPagamento(pagamentoDTO);

                if(pag==null){
                    System.out.println(" DEBUG : Acquisto non effettuato, pagamento non valido");
                    return false;
                }

                abbonamento.setPagamento(pag);
                abbonamentoDAO.insert(abbonamento);
               return true;
            } else {
                System.out.println("Non disponi di una tessera");
                return false;
            }


    }

    public boolean acquistoBiglietto(TitoloDTO titoloDTO) {
        clienteLoggato = (Cliente) SessionManager.getInstance().getCurrentUser();

            if(clienteLoggato!=null) {
                IBigliettoStrategy bigliettoStrategy = BigliettoStrategyFactory.getFactoryFromProperties(titoloDTO.getTipoTitolo());
                Biglietto  biglietto = bigliettoStrategy.createBiglietto();
               PagamentoDTO pagamentoDTO = new PagamentoDTO(titoloDTO.getTipoPagamento(), titoloDTO.getQuantita(), bigliettoStrategy.ottieniPrezzoBiglietto());
               Pagamento pag = pagamentoService.effettuaPagamento(pagamentoDTO);

               if (pag != null){
                   biglietto.setPagamento(pag);

                   for(int it =0; it<titoloDTO.getQuantita(); it++) {
                       biglietto.setTipoBiglietto(titoloDTO.getTipoTitolo());
                       biglietto.setViaggio(new Viaggio(titoloDTO.getIdViaggio()));
                       bigliettoDAO.insert(biglietto);
                       biglietto.setId(UUID.randomUUID().toString());
                   }

                   return true;
               } else
                   return false;



            } else {
                System.out.println("DEBUG: Cliente non loggato, operazione non consentita");
                return false;
            }


    }


    public boolean acquistoTessera() {

        clienteLoggato = (Cliente) SessionManager.getInstance().getCurrentUser();

        if (clienteLoggato==null){
            System.out.println("Utente non loggato");
            return false;
        }

        if (!(tesseraDAO.exists(clienteLoggato.getId().toString())) && clienteLoggato != null) {
            Tessera tessera = new Tessera(UUID.randomUUID());
            return tesseraDAO.createTessera(tessera, clienteLoggato.getId().toString());
        }


        return false;
    }








}
