package it.unipv.ingsfw.treninordovest.view.panels.miscellanous;

import javax.swing.*;
import java.awt.*;

public class ProfilePanel extends JPanel {
    private JTextField txtNome;
    private JTextField txtCognome;
    private JTextField txtEmail;
    private JButton btnAggiorna;

    public ProfilePanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);

        JLabel lblNome = new JLabel("Nome:");
        txtNome = new JTextField(15);
        JLabel lblCognome = new JLabel("Cognome:");
        txtCognome = new JTextField(15);
        JLabel lblEmail = new JLabel("Email:");
        txtEmail = new JTextField(15);

        btnAggiorna = new JButton("Aggiorna Profilo");

        //Nome
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lblNome, gbc);

        //Cognome
        gbc.gridx = 1;

        add(txtNome, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lblCognome, gbc);

        gbc.gridx = 1;
        add(txtCognome, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(lblEmail, gbc);
        gbc.gridx = 1;
        add(txtEmail, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(btnAggiorna, gbc);
    }

    // Getters per il controller
    public JTextField getTxtNome() { return txtNome; }
    public JTextField getTxtCognome() { return txtCognome; }
    public JTextField getTxtEmail() { return txtEmail; }
    public JButton getBtnAggiorna() { return btnAggiorna; }
}
