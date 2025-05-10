package it.unipv.ingsfw.treninordovest.view.panels.miscellanous;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel implements ILoginPanel {
    //Dichiarazione dei componenti
    private final JTextField campoUtente;
    private final JPasswordField campoPassword;
    private final JButton bottoneAccesso;
    private final JButton bottoneIndietro;
    // private ImageIcon logoIcon = new ImageIcon("/logo.png");
    // private JLabel logoLabel;
    private Color coloreSfondo;
    private final JComboBox<String> comboRuolo;

    public LoginPanel() {
        // Implementazione del costruttore (mantenere il codice esistente)
        setLayout(new BorderLayout());
        coloreSfondo = new Color(131, 168, 195);
        setBackground(coloreSfondo);
        
        // Inizializzazione dei componenti (qui inserire il codice originale)
        campoUtente = new JTextField(20);
        campoPassword = new JPasswordField(20);
        bottoneAccesso = new JButton("Accedi");
        bottoneIndietro = new JButton("Indietro");
        comboRuolo = new JComboBox<>(new String[]{"Cliente", "Personale", "Amministratore"});
        
        // Costruzione del layout (qui inserire il resto del codice originale)
    }

    @Override
    public JPanel getPanel() {
        return this;
    }

    @Override
    public JTextField getCampoUtente() {
        return campoUtente;
    }

    @Override
    public JPasswordField getCampoPassword() {
        return campoPassword;
    }

    @Override
    public JButton getBottoneAccesso() {
        return bottoneAccesso;
    }

    @Override
    public JButton getBottoneIndietro() {
        return bottoneIndietro;
    }

    @Override
    public String getComboRuolo() {
        return (String) comboRuolo.getSelectedItem();
    }
}