package it.unipv.ingsfw.treninordovest.view.panels.miscellanous;

import javax.swing.*;
import java.awt.*;

public class MainMenuPanel extends JPanel {

    private JButton accessoCliente;
    private JButton registrazioneCliente;
    private JButton registrazioneDipendente;
    private JButton accessoDipendente;
    private Color coloreSfondo;

    public MainMenuPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        accessoCliente = new JButton("Accesso Cliente");
        accessoDipendente = new JButton("Accesso Dipendente");
        registrazioneCliente = new JButton("Registrazione Cliente");
        registrazioneDipendente = new JButton("Registrazione Dipendente");

        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(new JLabel("Benvenuti in TreniNordOvest, scegliere un'opzione tra le seguenti"), gbc);

        /*------------------------------------------*/
        gbc.gridy = 1;
        this.add(accessoCliente, gbc);
        /*------------------------------------------*/
        gbc.gridy = 2;
        this.add(accessoDipendente, gbc);
        /*------------------------------------------*/
        gbc.gridy = 3;
       this.add(registrazioneCliente, gbc);
        /*------------------------------------------*/
        gbc.gridy = 4;
        this.add(registrazioneDipendente, gbc);



    }

    public JButton getAccessoCliente() {
        return accessoCliente;
    }

    public JButton getRegistrazioneCliente() {
        return registrazioneCliente;
    }

    public JButton getRegistrazioneDipendente() {
        return registrazioneDipendente;
    }

    public JButton getAccessoDipendente() {
        return accessoDipendente;
    }
    // @Override
   /* protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Sfondo blu
        g.setColor(new Color(131, 168, 195));
        g.fillRect(0, 0, getWidth(), getHeight());

        // Disegna il testo "treninordovest" al centro
        //g.setColor(Color.BLUE);
        g.setFont(new Font("Arial", Font.BOLD, 48));
        String text = "Treninordovest";
        FontMetrics fm = g.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(text)) / 2;
        int y = getHeight() / 2;
        g.drawString(text, x, y);
    }*/
}
