package it.unipv.ingsfw.treninordovest.view.panels.miscellanous;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {
    private JTextField campoUtente;
    private JPasswordField campoPassword;
    private JButton bottoneAccesso;
    private JButton bottoneIndietro;
    private ImageIcon logoIcon = new ImageIcon("/logo.png");
    private JLabel logoLabel;
    private Color coloreSfondo;

    public LoginPanel() {  campoUtente = new JTextField(15);
        campoPassword = new JPasswordField(15);
        bottoneAccesso = new JButton("Accesso");
        bottoneIndietro = new JButton("Torna al menù");

        // Layout dei componenti
        JPanel panel = new LogoPanel();
        JPanel pannello = new JPanel(new GridBagLayout());
        pannello.setBackground(coloreSfondo);
        GridBagConstraints gbc = new GridBagConstraints();

        /*
        ImageIcon icon = new ImageIcon(getClass().getResource("/logo.png"));
        JLabel labelLogo = new JLabel(icon);*/

        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 1;
        pannello.add(new JLabel("Nome utente/email:"), gbc);

        gbc.gridx = 1;
        pannello.add(campoUtente, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        pannello.add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        pannello.add(campoPassword, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        pannello.add(bottoneAccesso, gbc);

      /* gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        pannello.add(labelLogo, gbc);*/

        gbc.gridx = 1;
        pannello.add(bottoneIndietro, gbc);

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

}
