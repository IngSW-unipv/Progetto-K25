package it.unipv.ingsfw.treninordovest.view.panels.miscellanous;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {
    //Dichiarazione dei componenti
    private final JTextField campoUtente;
    private final JPasswordField campoPassword;
    private final JButton bottoneAccesso;
    private final JButton bottoneIndietro;
   // private ImageIcon logoIcon = new ImageIcon("/logo.png");
    //private JLabel logoLabel;
    private Color coloreSfondo;
    private final JComboBox<String> comboRuolo;

    public LoginPanel() {
        //Definizione degli oggetti
        campoUtente = new JTextField(15);
        campoPassword = new JPasswordField(15);
        bottoneAccesso = new JButton("Accesso");
        bottoneIndietro = new JButton("Torna al menù");
        coloreSfondo = new  Color(131,168,195);

        String[] tipo = new String[]{"Cliente", "Dipendente"};
        comboRuolo = new JComboBox<>(tipo);


        // Layout dei componenti
        setLayout(new GridBagLayout());
        setBackground(coloreSfondo);
        GridBagConstraints gbc = new GridBagConstraints();

        /*
        ImageIcon icon = new ImageIcon(getClass().getResource("/logo.png"));
        JLabel labelLogo = new JLabel(icon);*/

        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 1;
       add(new JLabel("Nome utente/email:"), gbc);

        gbc.gridx = 1;
       add(campoUtente, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        add(campoPassword, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        add(bottoneAccesso, gbc);


        gbc.gridx = 1;
        add(bottoneIndietro, gbc);

        gbc.gridx = 2;
        add(comboRuolo, gbc);

    }

    public JPanel getPanel() {
        return this;
    }

    public JTextField getCampoUtente() {
        return campoUtente;
    }

    public JPasswordField getCampoPassword() {
        return campoPassword;
    }

    public JButton getBottoneAccesso() {
        return bottoneAccesso;
    }

    public JButton getBottoneIndietro() {
        return bottoneIndietro;
    }

    public String getComboRuolo() {
        return (String) comboRuolo.getSelectedItem();
    }
}