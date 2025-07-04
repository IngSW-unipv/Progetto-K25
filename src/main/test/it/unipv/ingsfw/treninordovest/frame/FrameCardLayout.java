package it.unipv.ingsfw.treninordovest.frame;

import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.panels.titolitable.TitoliViaggioTablePanel;

import javax.smartcardio.Card;
import javax.swing.*;
import java.awt.*;

import javax.swing.*;
import javax.swing.plaf.basic.BasicTabbedPaneUI;
import java.awt.*;
import java.awt.event.ActionEvent;

public class FrameCardLayout extends JFrame {

    private JPanel panelContenitore; // Il pannello che usa CardLayout// Il gestore del layout

    private JTabbedPane tabbedPane;

    public FrameCardLayout() {
        super("Esempio di CardLayout");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1120, 500);
        setLocationRelativeTo(null);

        TitoliViaggioTablePanel titoliViaggioTablePanel = new TitoliViaggioTablePanel();


        tabbedPane.addTab("TITOLI", titoliViaggioTablePanel);

    }

    public static void main(String[] args) {
        // È buona norma creare e mostrare la GUI nel thread degli eventi di Swing
        SwingUtilities.invokeLater(() -> {
            FrameCardLayout frame = new FrameCardLayout();
            frame.setVisible(true);
        });
    }
}
