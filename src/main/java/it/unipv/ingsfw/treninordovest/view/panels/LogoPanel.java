package it.unipv.ingsfw.treninordovest.view.panels;

import javax.swing.*;
import java.awt.*;

public class LogoPanel extends JPanel {
    public LogoPanel() {
        setOpaque(false);
        // Supponiamo di avere un'immagine "logo.png" nelle risorse
        ImageIcon logoIcon = new ImageIcon(getClass().getResource("/logo.ico"));
        JLabel logoLabel = new JLabel(logoIcon);
        add(logoLabel);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(800, 100); // Dimensione adatta per il logo
    }
}
