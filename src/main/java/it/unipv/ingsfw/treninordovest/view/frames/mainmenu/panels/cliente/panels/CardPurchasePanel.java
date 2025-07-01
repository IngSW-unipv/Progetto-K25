package it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.panels;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CardPurchasePanel extends JPanel implements PropertyChangeListener {
    private JLabel labelIDCliente;
    private JTextField textIDCliente;
    private JButton buttonAcquistaTessera;
    private JLabel labelAvviso;

    public CardPurchasePanel() {

        Color color = new Color(255, 255, 255);
        this.setBackground(color);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        labelIDCliente = new JLabel("ID Cliente:");
        textIDCliente = new JTextField(15);
        buttonAcquistaTessera = new JButton("Acquista Tessera");
        labelAvviso = new JLabel("Immettere il codice Cliente per la tessera gratuita");

        gbc.gridx = 0;
        gbc.gridy = 0;
        //gbc.anchor = GridBagConstraints.ABOVE_BASELINE;
        add(labelAvviso, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        add(labelIDCliente, gbc);
        gbc.gridx = 1;
        add(textIDCliente, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        add(buttonAcquistaTessera, gbc);
    }

    // Getters per il Controller
    public JTextField getTextIDCliente() {
        return textIDCliente;
    }

    public void setTextIDCliente(String text) {
        this.textIDCliente.setText(text) ;
    }

    public JButton getButtonAcquistaTessera() {
        return buttonAcquistaTessera;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
}