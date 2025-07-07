package it.unipv.ingsfw.treninordovest.controller;

import it.unipv.ingsfw.treninordovest.model.facade.TreniNordOvestFacade;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.JTreniNordOvestFrame;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.panels.titolitable.TitoliViaggioTablePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestioneTitoliController implements ActionListener{

    private final JTreniNordOvestFrame view;
    private TreniNordOvestFacade facade;

    public GestioneTitoliController(JTreniNordOvestFrame frame) {
        this.view = frame;
        this.facade = TreniNordOvestFacade.getInstance();
        addActionListeners();
    }


    private void mostraBigliettiAcquistati(){
        facade.getTitoloViaggioFacade().mostraBigliettiAcquistati();
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
