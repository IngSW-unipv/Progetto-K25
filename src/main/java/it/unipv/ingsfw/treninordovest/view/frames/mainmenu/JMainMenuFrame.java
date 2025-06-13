package it.unipv.ingsfw.treninordovest.view.frames.mainmenu;

//import it.unipv.ingsfw.treninordovest.controller.provvisorio.misc.MainMenuController;
import it.unipv.ingsfw.treninordovest.view.frames.login.JLoginFrame;
import it.unipv.ingsfw.treninordovest.view.frames.utenti.clienti.menu.registrazione.JCustomerRegFrame;
import it.unipv.ingsfw.treninordovest.view.frames.utenti.dipendenti.menu.registrazione.JEmployeeRegFrame;

import javax.swing.*;
import java.awt.*;


public class JMainMenuFrame extends JFrame  {

    private MainMenuPanel view;



    public JMainMenuFrame() {
        setTitle("Treninordovest - Benvenuti");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(820, 230);
        setLocationRelativeTo(null);
        initComponents();


    }

    private void initComponents() {
        view = new MainMenuPanel();

       // new MainMenuController(view,this::openLogin,this::openCustomerRegistration,this::openEmployeeRegistration);

        add(view, BorderLayout.CENTER);
        setVisible(true);

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

    public void hideFrame() {
        setVisible(false);
    }
    public void showFrame() {
        setVisible(true);
    }
}