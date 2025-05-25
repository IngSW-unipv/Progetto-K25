package it.unipv.ingsfw.treninordovest.controller.misc;

import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JMainMenuFrame;
import it.unipv.ingsfw.treninordovest.view.panels.miscellanous.MainMenuPanel;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;


public class MainMenuController implements ActionListener {

    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public MainMenuController(MainMenuPanel view) {
       view.addActionListener(this);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        pcs.addPropertyChangeListener(listener);
    }
    public void removePropertyChangeListener(PropertyChangeListener listener) {
        pcs.removePropertyChangeListener(listener);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        // notifica il cambiamento di 'command' con il nuovo valore
        pcs.firePropertyChange("command", null, command);
    }



}

