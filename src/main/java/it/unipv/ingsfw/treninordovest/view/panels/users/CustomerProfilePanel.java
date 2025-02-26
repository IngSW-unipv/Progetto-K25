package it.unipv.ingsfw.treninordovest.view.panels.users;

import javax.swing.*;
import java.awt.*;

public class CustomerProfilePanel extends JPanel {
    private JTextField txtNome;
    private JTextField txtCognome;
    private JTextField txtEmail;
    private JButton btnAggiornaPassword;
    private JButton btnAggionaProfilo;
    private JPasswordField txtPassword;
    private JTextField txtSesso;
    private JTextField txtID;
    private JTextField txtLuogoNascita;
    private JTextField txtDataNascita;
    private JTextField txtCellulare;
    private JTextField txtBilancio;
    private JTextField txtIndirizzo;
    private Color coloreSfondo;
    private JButton btnEsci;
    private JTextField txtDenaro;
    private JButton btnConfermaDenaro;

    public CustomerProfilePanel() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5,5,5,5);
        coloreSfondo = new Color(131,168,195);
        setBackground(coloreSfondo);

        JLabel lblIntestazione = new JLabel("Dati profilo");

        JLabel lblNome = new JLabel("Nome:");
        txtNome = new JTextField(15);

        JLabel lblPassword = new JLabel("Password");
        txtPassword = new JPasswordField(15);

        JLabel lblCognome = new JLabel("Cognome:");
        txtCognome = new JTextField(15);

        JLabel lblEmail = new JLabel("Email:");
        txtEmail = new JTextField(15);

        JLabel lblSesso= new JLabel("Sesso:");
        txtSesso = new JTextField(15);

        JLabel lblLuogoNasc= new JLabel("Luogo di Nascita:");
        txtLuogoNascita = new JTextField(15);

        JLabel lblDataNasc= new JLabel("Data di Nascita:");
        txtDataNascita = new JTextField(15);

        JLabel lblCell= new JLabel("Cellulare:");
        txtCellulare = new JTextField(15);

        JLabel lblBilancio = new JLabel("Bilancio:");
        txtBilancio = new JTextField(15);

        JLabel lblIndirizzo= new JLabel("Indirizzo:");
        txtIndirizzo = new JTextField(15);

        JLabel lblID = new JLabel("ID Cliente:");
        txtID= new JTextField(15);

        txtDenaro = new JTextField(15);
        btnConfermaDenaro = new JButton("Carica credito");


        btnAggiornaPassword = new JButton("Aggiorna password");
        btnAggionaProfilo = new JButton("Aggiorna profilo");
        btnEsci = new JButton("Esci");


        /*Dati profilo*/

        gbc.gridx = 5;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(lblIntestazione, gbc);

        //Nome
        gbc.gridx = 5;
        gbc.gridy = 1;
        add(lblNome, gbc);
        gbc.gridx = 6;
        txtNome.setEditable(false);
        txtNome.setBackground(Color.YELLOW);
        add(txtNome, gbc);

        //Cognome
       gbc.gridx = 5;
        gbc.gridy = 2;
        add(lblCognome, gbc);
        gbc.gridx = 6;
        txtCognome.setEditable(false);
        txtCognome.setBackground(Color.YELLOW);
        add(txtCognome, gbc);

        //Sesso
        gbc.gridx = 5;
        gbc.gridy = 3;
        add(lblSesso, gbc);
        gbc.gridx = 6;
        txtSesso.setEditable(false);
        txtSesso.setBackground(Color.YELLOW);
        add(txtSesso, gbc);

        //Luogo di Nascita
        gbc.gridx = 5;
        gbc.gridy = 4;
        add(lblLuogoNasc, gbc);
        gbc.gridx = 6;
        txtLuogoNascita.setEditable(false);
        txtLuogoNascita.setBackground(Color.YELLOW);
        add(txtLuogoNascita, gbc);

        //Data di nascita
        gbc.gridx = 5;
        gbc.gridy = 5;
        add(lblDataNasc, gbc);
        gbc.gridx = 6;
        txtDataNascita.setEditable(false);
        txtDataNascita.setBackground(Color.YELLOW);
        add(txtDataNascita, gbc);

        //Cellulare
        gbc.gridx = 5;
        gbc.gridy = 6;
        add(lblCell, gbc);
        gbc.gridx = 6;
        txtCellulare.setEditable(false);
        txtCellulare.setBackground(Color.YELLOW);
        add(txtCellulare, gbc);

        //Indirizzo
        gbc.gridx = 5;
        gbc.gridy = 7;
        add(lblIndirizzo, gbc);
        gbc.gridx = 6;
        txtIndirizzo.setEditable(false);
        txtIndirizzo.setBackground(Color.YELLOW);
        add(txtIndirizzo, gbc);


        /*Email*/
        gbc.gridx = 5;
        gbc.gridy = 8;
        add(lblEmail, gbc);
        gbc.gridx = 6;
        txtEmail.setEditable(false);
        txtEmail.setBackground(Color.YELLOW);
        add(txtEmail, gbc);

        //Bilancio
        gbc.gridx = 5;
        gbc.gridy = 9;
        add(lblBilancio, gbc);
        gbc.gridx = 6;
        txtBilancio.setEditable(false);
        txtBilancio.setBackground(Color.YELLOW);
        add(txtBilancio, gbc);


        //ID
        gbc.gridx = 5;
        gbc.gridy = 10;
        add(lblID, gbc);
        gbc.gridx = 6;
        txtID.setEditable(false);
        txtID.setBackground(Color.YELLOW);
        add(txtID, gbc);

        //BTN
        gbc.gridx = 5;
        gbc.gridy = 11;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(btnAggionaProfilo, gbc);



        /*---------------------------------------------*/
        //Password
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        add(lblPassword, gbc);
        gbc.gridx = 1;
        add(txtPassword, gbc);

        //Aggiorna password
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(btnAggiornaPassword, gbc);

        //Bottone Esci
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(btnEsci, gbc);


        //Portafoglio
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(txtDenaro, gbc);

        //Bottone conferma caricamento denaro
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(btnConfermaDenaro, gbc);


    }

    // Getters per il controller

    public JButton getBtnAggiornaPassword() {
        return btnAggiornaPassword;
    }

    public JButton getBtnAggionaProfilo() {
        return btnAggionaProfilo;
    }

    public JPasswordField getTxtPassword() {
        return txtPassword;
    }

    public void setTxtNome(String txtNome) {
       this.txtNome.setText(txtNome);
    }

    public void setTxtCognome(String cognome) {
        this.txtCognome.setText(cognome);
    }

    public void setTxtEmail(String txtEmail) {
       this.txtEmail.setText(txtEmail);
    }

    public void setTxtSesso(String  txtSesso) {
        this.txtSesso.setText(txtSesso);
    }

    public void setTxtID(String ID) {
        this.txtID.setText(ID);
    }

    public void setTxtLuogoNascita(String txtLuogoNascita) {
        this.txtLuogoNascita.setText(txtLuogoNascita);
    }

    public void setTxtDataNascita(String txtDataNascita) {
        this.txtDataNascita.setText(txtDataNascita);
    }

    public void setTxtCellulare(String txtCellulare) {
       this.txtCellulare.setText(txtCellulare);
    }

    public void setTxtBilancio(String txtBilancio) {
        this.txtBilancio.setText(txtBilancio);
    }

    public void setTxtIndirizzo(String txtIndirizzo) {
        this.txtIndirizzo.setText(txtIndirizzo);
    }

    public JButton getBtnEsci() {
        return btnEsci;
    }

    public JButton getBtnConfermaDenaro() {
        return btnConfermaDenaro;
    }

    public double getTxtDenaro() {
        double denaro = Double.parseDouble(txtDenaro.getText().toString());
        return denaro;
    }
}
