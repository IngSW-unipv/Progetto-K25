package it.unipv.ingsfw.treninordovest.view.frames;

import it.unipv.ingsfw.treninordovest.view.panels.RegistrationPanel;

import javax.swing.*;
import java.awt.*;

public class JRegistrationFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private RegistrationPanel registrationPanel;

    public JRegistrationFrame() {
        setTitle("Treninordovest - Registrazione");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.BLUE);

        inizializzaComponenti();

    }

    private void inizializzaComponenti() {
        registrationPanel = new RegistrationPanel();
        getContentPane().add(registrationPanel, BorderLayout.CENTER);
    }


}
