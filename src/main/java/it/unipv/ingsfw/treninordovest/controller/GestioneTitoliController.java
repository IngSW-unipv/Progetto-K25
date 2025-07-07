package it.unipv.ingsfw.treninordovest.controller;

import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.panels.titolitable.TitoliViaggioTablePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GestioneTitoliController implements ActionListener{

    private TitoliViaggioTablePanel titoliViaggioTablePanel;

    public GestioneTitoliController() {
        titoliViaggioTablePanel = new TitoliViaggioTablePanel();
    }


    private void mostraBigliettiAcquistati(){}
    private void mostraAbbonamentiAcquistati(){}
    private void rinnovaAbbonamento(){}
    private void controllaTitolo(){}
    private void validaTitolo(){}

    private void addActionListeners() {}

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
