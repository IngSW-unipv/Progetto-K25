package it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MainMenuPanel extends JPanel {


    //Comandi
    public final static String CMD_Accesso = "login_pannel";
    public final static String CMD_RegistrazioneCliente = "customerRegistration_panel";
    public final static String CMD_RegistrazioneDipendente = "employeeRegistration_panel";

    //private JButton accessoCliente;
    private final JButton registrazioneCliente;
    private final JButton registrazioneDipendente;
    private final JButton accesso;
    private Color coloreSfondo;

    public MainMenuPanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        //accessoCliente = new JButton("Accesso Cliente");
        accesso = new JButton("Accesso");
        registrazioneCliente = new JButton("Registrazione Cliente");
        registrazioneDipendente = new JButton("Registrazione Dipendente");

        accesso.setActionCommand(CMD_Accesso);
        registrazioneCliente.setActionCommand(CMD_RegistrazioneCliente);
        registrazioneDipendente.setActionCommand(CMD_RegistrazioneDipendente);

        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(new JLabel("Benvenuti in TreniNordOvest, scegliere un'opzione tra le seguenti"), gbc);

        /*------------------------------------------*/
        //  gbc.gridy = 1;
        // this.add(accessoCliente, gbc);
        /*------------------------------------------*/
        gbc.gridy = 1;
        this.add(accesso, gbc);
        /*------------------------------------------*/
        gbc.gridy = 2;
        this.add(registrazioneCliente, gbc);
        /*------------------------------------------*/
        gbc.gridy = 3;
        this.add(registrazioneDipendente, gbc);



    }

    public JButton getRegistrazioneCliente() {
        return registrazioneCliente;
    }

    public JButton getRegistrazioneDipendente() {
        return registrazioneDipendente;
    }

    public JButton getAccesso() {
        return accesso;
    }




}
