package it.unipv.ingsfw.treninordovest.facade.implementations.gestionetitoli;

import it.unipv.ingsfw.treninordovest.dao.implementations.titoli.AbbonamentoDAOimpl;
import it.unipv.ingsfw.treninordovest.dao.implementations.titoli.PagamentoDAOImpl;
import it.unipv.ingsfw.treninordovest.dao.implementations.titoli.StoricoPagamentoDAOImpl;
import it.unipv.ingsfw.treninordovest.dao.implementations.utenti.ClienteDAOImpl;
import it.unipv.ingsfw.treninordovest.dao.implementations.utenti.TesseraDAOImpl;
import it.unipv.ingsfw.treninordovest.facade.interfaces.ITitoloViaggioFacade;
import it.unipv.ingsfw.treninordovest.factory.implementations.AbbonamentoStrategyFactory;
import it.unipv.ingsfw.treninordovest.factory.implementations.MetodoPagamentoFactory;
import it.unipv.ingsfw.treninordovest.factory.implementations.VenditaStrategyFactory;
import it.unipv.ingsfw.treninordovest.model.titoli.Abbonamento;
import it.unipv.ingsfw.treninordovest.model.titoli.Pagamento;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;
import it.unipv.ingsfw.treninordovest.strategy.abbonamento.IAbbonamentoStrategy;
import it.unipv.ingsfw.treninordovest.strategy.pagamento.IVenditaTitoliStrategy;
import it.unipv.ingsfw.treninordovest.utils.metodipagamento.IMetodoPagamento;


import java.util.List;

public class AbbonamentoManagementFacade implements ITitoloViaggioFacade<Abbonamento> {

    private final TesseraDAOImpl tesseraDAO;
    private final AbbonamentoDAOimpl abbonamentoDAO;
    private final PagamentoDAOImpl pagamentoDAO;
    private final ClienteDAOImpl clienteDAO;
    private final StoricoPagamentoDAOImpl storicoPagamentoDAO;
    private final String tipoVendita="VenditaAbbonamento";
    private String idUtenteLog = SessionManager.getInstance().getCurrentUser().getId();


    public AbbonamentoManagementFacade() {
        this.tesseraDAO = new TesseraDAOImpl();
        this.abbonamentoDAO = new AbbonamentoDAOimpl();
        this.pagamentoDAO = new PagamentoDAOImpl();
        this.storicoPagamentoDAO = new StoricoPagamentoDAOImpl();
        this.clienteDAO = new ClienteDAOImpl();

    }

    @Override
    public void acquistaTitoloViaggio(String tipo,String metodoPagamento,int numeroTitoli) {
        Pagamento pagamento;
        Abbonamento abbonamento;

        IAbbonamentoStrategy abbonamentoStrategy = AbbonamentoStrategyFactory.getFactoryFromProperties(tipo);
        IVenditaTitoliStrategy venditaStrategy = VenditaStrategyFactory.getFactoryFromProperties(tipoVendita);

        String idTessera = cercaIdTessera();


        pagamento = venditaStrategy.generaPagamento(idUtenteLog,numeroTitoli,abbonamentoStrategy.ottieniPrezzoAbbonamento(),metodoPagamento);
        abbonamento= abbonamentoStrategy.createAbbonamento(idUtenteLog,pagamento.getIdPagamento(),idTessera);

        pagamentoDAO.insert(pagamento);
        abbonamentoDAO.insert(abbonamento);

    }

    @Override
    public Abbonamento rimuoviTitoloViaggio() {
        return null;
    }

    @Override
    public boolean titoloDisponibile() {
        return false;
    }

    @Override
    public void mostraTitolo() {



    }

    @Override
    public List<Abbonamento> getTitoloViaggio() {
        return List.of();
    }


    private String cercaIdTessera (){
        String idTessera = null;
        idTessera = tesseraDAO.getIdTesseraByCustomerID(idUtenteLog);
        return idTessera;
    }
}

