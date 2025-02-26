package it.unipv.ingsfw.treninordovest.view.panels.miscellanous;

import it.unipv.ingsfw.treninordovest.view.panels.finance.CardPurchasePanel;

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




        btnAggiornaPassword = new JButton("Aggiorna password");
        btnAggionaProfilo = new JButton("Aggiorna profilo");


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

    public void setTxtNome(JTextField txtNome) {
        this.txtNome = txtNome;
    }

    public void setTxtCognome(JTextField txtCognome) {
        this.txtCognome = txtCognome;
    }

    public void setTxtEmail(JTextField txtEmail) {
        this.txtEmail = txtEmail;
    }

    public void setTxtSesso(JTextField txtSesso) {
        this.txtSesso = txtSesso;
    }

    public void setTxtID(JTextField txtID) {
        this.txtID = txtID;
    }

    public void setTxtLuogoNascita(JTextField txtLuogoNascita) {
        this.txtLuogoNascita = txtLuogoNascita;
    }

    public void setTxtDataNascita(JTextField txtDataNascita) {
        this.txtDataNascita = txtDataNascita;
    }

    public void setTxtCellulare(JTextField txtCellulare) {
        this.txtCellulare = txtCellulare;
    }

    public void setTxtBilancio(JTextField txtBilancio) {
        this.txtBilancio = txtBilancio;
    }

    public void setTxtIndirizzo(JTextField txtIndirizzo) {
        this.txtIndirizzo = txtIndirizzo;
    }
}
