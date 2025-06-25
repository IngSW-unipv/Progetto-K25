package it.unipv.ingsfw.treninordovest.facade.acquisto;

import it.unipv.ingsfw.treninordovest.model.factory.implementations.AbbonamentoStrategyFactory;
import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.Abbonamento;
import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.AbbonamentoDAOimpl;
import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.BigliettoDAOImpl;
import it.unipv.ingsfw.treninordovest.model.titoli.pagamento.PagamentoDAOImpl;

import it.unipv.ingsfw.treninordovest.model.titoli.tessera.Tessera;
import it.unipv.ingsfw.treninordovest.model.titoli.tessera.TesseraDAOImpl;
import it.unipv.ingsfw.treninordovest.model.utenti.cliente.Cliente;
import it.unipv.ingsfw.treninordovest.model.varie.GeneraID;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;
import it.unipv.ingsfw.treninordovest.model.strategy.abbonamento.IAbbonamentoStrategy;
import it.unipv.ingsfw.treninordovest.service.AcquistoService;

import java.time.LocalDate;


public class AcquistoFacade implements IAcquistoFacade {

    ;
   private AcquistoService acquistoService;

    public AcquistoFacade() {
        this.acquistoService = new AcquistoService();
    }


    @Override
    public boolean acquistaBiglietto(String tipoBiglietto, String tipoPagamento, int quantita, String idTratta, boolean ritorno, LocalDate dataRitorno) {
        return acquistoService.acquistoBiglietto(tipoBiglietto,tipoPagamento, quantita,idTratta,ritorno,dataRitorno);
    }

    @Override
    public boolean acquistoAbbonamento(String tipoAbbonamento,String tipoPagamento,int quantita) {
        return acquistoService.acquistoAbbonamento(tipoAbbonamento,tipoPagamento,quantita);
    }

    @Override
    public boolean acquistaTessera(){
        return acquistoService.acquistoTessera();

    }






}
