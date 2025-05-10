package it.unipv.ingsfw.treninordovest.view.panels.miscellanous;

import javax.swing.*;

/**
 * Interfaccia che definisce il contratto per i pannelli di login
 */
public interface ILoginPanel {

    JPanel getPanel();

    JTextField getCampoUtente();

    JPasswordField getCampoPassword();

    JButton getBottoneAccesso();

    JButton getBottoneIndietro();

    String getComboRuolo();
}