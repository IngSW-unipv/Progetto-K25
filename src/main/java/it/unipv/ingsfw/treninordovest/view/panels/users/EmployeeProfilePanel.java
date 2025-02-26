package it.unipv.ingsfw.treninordovest.view.panels.users;

import javax.swing.*;
import java.awt.*;

public class EmployeeProfilePanel extends JPanel {
    private JTextField txtNome;
    private JTextField txtCognome;
    private JTextField txtEmail;
    private JButton btnAggiorna;

    public EmployeeProfilePanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);

        JLabel lblNome = new JLabel("Nome:");
        txtNome = new JTextField(15);
        JLabel lblCognome = new JLabel("Cognome:");
        txtCognome = new JTextField(15);
        JLabel lblEmail = new JLabel("Email:");
        txtEmail = new JTextField(15);

        btnAggiorna = new JButton("Aggiorna Password");


        //Nome
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lblNome, gbc);
        gbc.gridx = 1;
        add(txtNome, gbc);

        //Cognome
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lblCognome, gbc);
        gbc.gridx = 1;
        add(txtCognome, gbc);

        //Email
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
}
