package it.unipv.ingsfw.treninordovest.view.frames;

import it.unipv.ingsfw.treninordovest.view.panels.LogoPanel;

import javax.swing.*;
import java.awt.*;

public class JStartFrame extends JFrame {

    private JTextField campoUtente;
    private JPasswordField campoPassword;
    private JButton bottoneAccesso;
    private JButton bottoneRegistrazione;
    // Creazione dei componenti
//Logo
    private ImageIcon logoIcon = new ImageIcon("/logo.png");
    private JLabel logoLabel;

    public JStartFrame() {
        setTitle("Treninordovest - Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.BLUE);

        inizializzaComponenti();

    }

    private void inizializzaComponenti() {



        campoUtente = new JTextField(15);
        campoPassword = new JPasswordField(15);
        bottoneAccesso = new JButton("Accesso");
        bottoneRegistrazione = new JButton("Registrazione");

        // Layout dei componenti

        JPanel panel = new LogoPanel();

        JPanel pannello = new JPanel(new GridBagLayout());
        pannello.setBackground(Color.BLUE);
        GridBagConstraints gbc = new GridBagConstraints();

        ImageIcon icon = new ImageIcon(getClass().getResource("/logo.png"));
        JLabel labelLogo = new JLabel(icon);


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

        gbc.gridx = 0;
        gbc.gridy = 8;
        pannello.add(labelLogo, gbc);

        gbc.gridx = 1;
        pannello.add(bottoneRegistrazione, gbc);


        add(pannello);
    }

    // Metodi getter per i componenti
    public JTextField getCampoUtente() {
        return campoUtente;
    }

    public JPasswordField getCampoPassword() {
        return campoPassword;
    }

    public JButton getBottoneAccesso() {
        return bottoneAccesso;
    }

    public JButton getBottoneRegistrazione() {
        return bottoneRegistrazione;
    }






}
