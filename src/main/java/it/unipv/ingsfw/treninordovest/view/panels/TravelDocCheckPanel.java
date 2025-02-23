package it.unipv.ingsfw.treninordovest.view.panels;

import javax.swing.*;
import java.awt.*;

public class TravelDocCheckPanel extends JPanel {
    private JLabel labelIDTitolo ;
    private JTextField textFieldIdTitolo;
    private JButton verificaButton;

    public TravelDocCheckPanel() {
        this.setBackground(Color.getHSBColor(205,(float) 0.33, (float)0.76));

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        labelIDTitolo = new JLabel("ID Titolo:");
        textFieldIdTitolo = new JTextField(15);
        verificaButton = new JButton("Verifica titolo");

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(labelIDTitolo, gbc);
        gbc.gridx = 1;
        add(textFieldIdTitolo, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        add(verificaButton, gbc);
    }

}
