package it.unipv.ingsfw.treninordovest.view.frames.miscellanous;

import it.unipv.ingsfw.treninordovest.controller.misc.MainMenuController;
import it.unipv.ingsfw.treninordovest.view.frames.customer.JCustomerRegFrame;
import it.unipv.ingsfw.treninordovest.view.frames.employee.JEmployeeRegFrame;
import it.unipv.ingsfw.treninordovest.view.panels.miscellanous.MainMenuPanel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Observable;
import java.util.Observer;

public class JMainMenuFrame extends JFrame implements PropertyChangeListener {

    private MainMenuPanel panel;
    private MainMenuController controller;


    public JMainMenuFrame() {
        setTitle("Treninordovest - Benvenuti");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(820, 230);
        setLocationRelativeTo(null);

        initComponents();

    }

    private void initComponents() {
        panel = new MainMenuPanel();
        controller = new MainMenuController(panel);
        controller.addPropertyChangeListener(this);
        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (!"command".equals(evt.getPropertyName())) return;
        String cmd =(String) evt.getNewValue();

        // 3) reagisce al comando
        if ("login".equals(cmd)) {
            openLogin();
        }else if ("registrazione".equals(cmd)) {
            openCustomerRegistration();
        }
        else if ("registrazioneDipendente".equals(cmd)) {
            openEmployeeRegistration();
        }
        else if ("errore".equals(cmd)) {
            JOptionPane.showMessageDialog(this, "Errore di login", "Errore", JOptionPane.ERROR_MESSAGE);
        }
        else if ("erroreRegistrazione".equals(cmd)) {
            JOptionPane.showMessageDialog(this, "Errore nella registrazione", "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void openLogin() {
        setVisible(false);
        new JLoginFrame().showFrame();
    }

    private void openCustomerRegistration() {
        setVisible(false);
        new JCustomerRegFrame().showFrame();
        JOptionPane.showMessageDialog(this, "Registrazione Cliente!");
    }

    private void openEmployeeRegistration() {
        setVisible(false);
        new JEmployeeRegFrame().showFrame();
        JOptionPane.showMessageDialog(this, "Registrazione Dipendente!");
    }
}