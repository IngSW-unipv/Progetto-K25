package it.unipv.ingsfw.treninordovest.view.panels.users;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;

public class EmployeeRegistrationPanel extends JPanel  {
    private JPasswordField txtPassword;
    private JTextField txtNome;
    private JTextField txtCognome;
    private JTextField txtCellulare;
    private JTextField txtIndirizzo;
    private JButton btnRegister;
    private JComboBox<String> comboSesso;
    private JComboBox<String> comboRuolo;
    private JDateChooser dateChooser;
    private JTextField txtLuogoNascita;
    private Color colorePannello;
    private JButton btnMenuPrincipal;


    public EmployeeRegistrationPanel() {

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        colorePannello= new Color(131,168,195);
        setBackground(colorePannello);

        /*JLabel lblUsername = new JLabel("Username:");
        txtUsername = new JTextField(15);*/

        JLabel lblpassword = new JLabel("Password:");
        txtPassword = new JPasswordField(15);

        JLabel lblnome = new JLabel("Nome:");
        txtNome = new JTextField(15);

        JLabel lblcognome = new JLabel("Cognome:");
        txtCognome = new JTextField(15);

        JLabel lblsesso = new JLabel("Sesso:");
        comboSesso = new JComboBox<>(new String[] {"M", "F"});

        JLabel lblcellulare = new JLabel("Cellulare:");
        txtCellulare = new JTextField(15);

        JLabel lblRuolo = new JLabel("Ruolo:");
        comboRuolo = new JComboBox<>(new String[] {"Capotreno", "Macchinista","Controllore","Impiegato"});


        JLabel lblindirizzo = new JLabel("Indirizzo:");
        txtIndirizzo = new JTextField(15);


        btnRegister = new JButton("Registrati");
        btnMenuPrincipal = new JButton("Menu Principale");


        JLabel lbldataNascita= new JLabel("Data di nascita:");
        dateChooser= new JDateChooser();
        dateChooser.setDateFormatString("yyyy-MM-dd");

        JLabel lblLuogoNascita = new JLabel("Luogo di nascita:");
        txtLuogoNascita = new JTextField(15);


        //Password
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(lblpassword, gbc);
        gbc.gridx = 1;
        add(txtPassword, gbc);

        //Nome
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(lblnome, gbc);
        gbc.gridx = 1;
        add(txtNome, gbc);

        //Cognome
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(lblcognome, gbc);
        gbc.gridx = 1;
        add(txtCognome, gbc);

        //Sesso
        gbc.gridx = 0;
        gbc.gridy = 5;
        add(lblsesso, gbc);
        gbc.gridx = 1;
        add(comboSesso, gbc);

        //DataNascita
        gbc.gridx = 0;
        gbc.gridy = 6;
        add(lbldataNascita, gbc);
        gbc.gridx = 1;
        add(dateChooser, gbc);

        //Luogo di nascita
        gbc.gridx = 0;
        gbc.gridy = 7;
        add(lblLuogoNascita, gbc);
        gbc.gridx = 1;
        add(txtLuogoNascita, gbc);

        //Celullare
        gbc.gridx = 0;
        gbc.gridy = 8;
        add(lblcellulare, gbc);
        gbc.gridx = 1;
        add(txtCellulare, gbc);

        //Indirizzo
        gbc.gridx = 0;
        gbc.gridy = 9;
        add(lblindirizzo, gbc);
        gbc.gridx = 1;
        add(txtIndirizzo, gbc);

        //Ruolo
        gbc.gridx = 0;
        gbc.gridy = 10;
        add(lblRuolo, gbc);
        gbc.gridx = 1;
        add(comboRuolo, gbc);


        //Bottone di registrazione
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 2;
        add(btnRegister, gbc);

        //Bottone indietro
        gbc.gridx = 0;
        gbc.gridy = 12;
        gbc.gridwidth = 2;
        add(btnMenuPrincipal, gbc);

    }

    public JPasswordField getTxtPassword() {
        return txtPassword;
    }

    public JTextField getTxtNome() {
        return txtNome;
    }

    public JTextField getTxtCellulare() {
        return txtCellulare;
    }

    public JTextField getTxtCognome() {
        return txtCognome;
    }

    public JTextField getTxtIndirizzo() {
        return txtIndirizzo;
    }

    public JButton getBtnRegister() {
        return btnRegister;
    }

    public String getComboSesso() {
        return (String) comboSesso.getSelectedItem();
    }

    public String getComboRuolo() {
        return (String) comboRuolo.getSelectedItem();
    }

    public JTextField getTxtLuogoNascita() {
        return txtLuogoNascita;
    }

    public JDateChooser getDataNascita() {
        return dateChooser;
    }
}
