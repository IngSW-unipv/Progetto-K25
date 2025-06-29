package it.unipv.ingsfw.treninordovest.view.frames.utenti.clienti.menu.principale.panels;

import javax.swing.*;
import java.awt.*;

public class AcquistoBigliettoPanel extends JPanel {
    private JButton btnCercaTratta = new JButton("Cerca Tratta");
    private JButton btnAcquista = new JButton("Acquista Biglietto");
    private JComboBox<String> trattaCombo = new JComboBox<>();

    public AcquistoBigliettoPanel() {
        setLayout(new BorderLayout(10,10));
        JPanel top = new JPanel(new FlowLayout());
        top.add(new JLabel("Seleziona tratta:"));
        top.add(trattaCombo);
        top.add(btnCercaTratta);
        add(top, BorderLayout.NORTH);
        add(btnAcquista, BorderLayout.SOUTH);

        btnCercaTratta.addActionListener(e -> caricaTratte());
        btnAcquista.addActionListener(e -> acquista());
    }

    private void caricaTratte() {
        trattaCombo.removeAllItems();
        trattaCombo.addItem("Tratta A → B | 10€");
        trattaCombo.addItem("Tratta B → C | 8€");
        // TODO: collegare service per ottenere tratte
    }

    private void acquista() {
        String tratta = (String) trattaCombo.getSelectedItem();
        if (tratta == null) {
            JOptionPane.showMessageDialog(this, "Seleziona una tratta prima!");
            return;
        }
        JOptionPane.showMessageDialog(this, "Biglietto per '" + tratta + "' acquistato.");
        // TODO: service.acquistaBiglietto(...)
    }
}
