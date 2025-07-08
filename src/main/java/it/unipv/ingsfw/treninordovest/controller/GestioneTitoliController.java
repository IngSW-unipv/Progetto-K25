package it.unipv.ingsfw.treninordovest.controller;

import it.unipv.ingsfw.treninordovest.model.facade.TreniNordOvestFacade;
import it.unipv.ingsfw.treninordovest.model.service.titoli.TitoliViaggioModel;
import it.unipv.ingsfw.treninordovest.model.service.viaggio.ViaggiModel;
import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.Abbonamento;
import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.Biglietto;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.JTreniNordOvestFrame;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.panels.titolitable.TitoliViaggioTablePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class GestioneTitoliController implements ActionListener{

    private final JTreniNordOvestFrame view;
    private TreniNordOvestFacade facade;
    private TitoliViaggioModel titoliViaggioModel;

    public GestioneTitoliController(JTreniNordOvestFrame frame) {
        this.view = frame;
        this.facade = TreniNordOvestFacade.getInstance();
        titoliViaggioModel=new TitoliViaggioModel();
        addActionListeners();
    }


    private void mostraBigliettiAcquistati(){
       List<Biglietto> listaBiglietti = facade.getTitoloViaggioFacade().mostraBigliettiAcquistati();
       titoliViaggioModel.setListaBiglietti(listaBiglietti);
        System.out.println("DEBUG : Mostra Biglietti");
    }
    private void mostraAbbonamentiAcquistati(){
        facade.getTitoloViaggioFacade().mostraAbbonamentiAcquistati();
        System.out.println("DEBUG : Mostra Abbonamenti");
    }
    private void rinnovaAbbonamento(){}
    private void controllaTitolo(){}
    private void validaTitolo(){}

    private void addActionListeners() {
        view.getCustomerMainPanel().getTitoliViaggioTablePanel().getBtnShowAbbonamenti().addActionListener(this);
        view.getCustomerMainPanel().getTitoliViaggioTablePanel().getBtnShowBiglietti().addActionListener(this);

        titoliViaggioModel.addPropertyChangeListener(view.getCustomerMainPanel().getTitoliViaggioTablePanel());

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        switch(cmd){
            case TitoliViaggioTablePanel.SHOW_ABBONAMENTI:
                view.getCustomerMainPanel().getTitoliViaggioTablePanel().showAbbonamentiCard();
                mostraAbbonamentiAcquistati();
                break;
            case TitoliViaggioTablePanel.SHOW_BIGLIETTI:
                view.getCustomerMainPanel().getTitoliViaggioTablePanel().showBigliettiCard();
                mostraBigliettiAcquistati();
                break;
        }

    }
}
