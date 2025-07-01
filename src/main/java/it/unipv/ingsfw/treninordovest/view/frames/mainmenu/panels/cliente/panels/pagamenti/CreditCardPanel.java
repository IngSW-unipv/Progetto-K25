package it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.panels.pagamenti;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;

public class CreditCardPanel extends JPanel {
    public CreditCardPanel(JPanel parent) {
        setLayout(new GridLayout(4,2,5,5));
        JTextField tfNum = new JTextField(16);
        JDateChooser tfExpiry = new JDateChooser();
        JTextField tfCvv = new JTextField(3);
        JButton btnPay = new JButton("Paga con Carta");

        btnPay.addActionListener(e -> {
            // puoi aggiungere validazioni qui...

        });

        add(new JLabel("Numero Carta:")); add(tfNum);
        add(new JLabel("Scadenza:"));        add(tfExpiry);
        add(new JLabel("CVV:"));             add(tfCvv);
        add(new JLabel());                   add(btnPay);
    }
}
