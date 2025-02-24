package it.unipv.ingsfw.treninordovest.view.frames.miscellanous;

import it.unipv.ingsfw.treninordovest.view.panels.miscellanous.LogoPanel;

import javax.swing.*;
import java.awt.*;

public class JDecisionFrame extends JFrame {

    private JButton accessoCliente;
    private JButton registrazioneCliente;
    private JButton registrazioneDipendente;
    private JButton accessoDipendente;
    private Color coloreSfondo;

    public JDecisionFrame() {
        setTitle("Treninordovest - Benvenuti");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(820, 230);
        setLocationRelativeTo(null);
        coloreSfondo = new Color(131,168,195);
        inizializzaComponenti();
    }

    private void inizializzaComponenti() {
        accessoCliente = new JButton("Accesso Cliente");
        accessoDipendente = new JButton("Accesso Dipendente");
       registrazioneCliente = new JButton("Registrazione Cliente");
        registrazioneDipendente = new JButton("Registrazione Dipendente");

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
        gbc.gridy = 0;
        pannello.add(new JLabel("Benvenuti in TreniNordOvest, scegliere un'opzione tra le seguenti"), gbc);

        /*------------------------------------------*/
        gbc.gridy = 1;
        pannello.add(accessoCliente, gbc);
        /*------------------------------------------*/
        gbc.gridy = 2;
        pannello.add(accessoDipendente, gbc);
        /*------------------------------------------*/
        gbc.gridy = 3;
        pannello.add(registrazioneCliente, gbc);
        /*------------------------------------------*/
        gbc.gridy = 4;
        pannello.add(registrazioneDipendente, gbc);



        add(pannello);
    }


}
