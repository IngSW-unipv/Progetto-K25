package it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.dipendente.panels;

import it.unipv.ingsfw.treninordovest.model.utenti.cliente.Cliente;
import it.unipv.ingsfw.treninordovest.model.utenti.dipendente.Dipendente;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class EmployeeProfilePanel extends JPanel implements PropertyChangeListener {
    private final JTextField txtNome;
    private final JTextField txtCognome;
    private final JTextField txtRuolo;
    private final JButton btnAggiornaPassword;
    private final JButton btnAggionaProfilo;
    private final JPasswordField txtPassword;
    private final JTextField txtSesso;
    private final JTextField txtID;
    private final JTextField txtLuogoNascita;
    private final JTextField txtDataNascita;
    private final JTextField txtCellulare;
    private final JTextField txtStipendio;
    private final JTextField txtIndirizzo;
    private final Color coloreSfondo;
    private final JButton btnEsci;

    public static final String CMD_Logout = "logout";
    public static final String CMD_ChangePassword = "changePassword";
    public static final String CMD_UpdateProfile = "updateProfile";

    public EmployeeProfilePanel() {
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

        JLabel lblRuolo = new JLabel("Ruolo:");
        txtRuolo = new JTextField(15);

        JLabel lblSesso= new JLabel("Sesso:");
        txtSesso = new JTextField(15);

        JLabel lblLuogoNasc= new JLabel("Luogo di Nascita:");
        txtLuogoNascita = new JTextField(15);

        JLabel lblDataNasc= new JLabel("Data di Nascita:");
        txtDataNascita = new JTextField(15);

        JLabel lblCell= new JLabel("Cellulare:");
        txtCellulare = new JTextField(15);

        JLabel lblBilancio = new JLabel("Stipendio:");
        txtStipendio = new JTextField(15);

        JLabel lblIndirizzo= new JLabel("Indirizzo:");
        txtIndirizzo = new JTextField(15);

        JLabel lblID = new JLabel("ID Dipendente:");
        txtID= new JTextField(15);


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
        add(lblRuolo, gbc);
        gbc.gridx = 6;
        txtRuolo.setEditable(false);
        txtRuolo.setBackground(Color.YELLOW);
        add(txtRuolo, gbc);

        //Stipendio
        gbc.gridx = 5;
        gbc.gridy = 9;
        add(lblBilancio, gbc);
        gbc.gridx = 6;
        txtStipendio.setEditable(false);
        txtStipendio.setBackground(Color.YELLOW);
        add(txtStipendio, gbc);


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

        btnEsci.setActionCommand(CMD_Logout);
        btnAggiornaPassword.setActionCommand(CMD_ChangePassword);
        btnAggionaProfilo.setActionCommand(CMD_UpdateProfile);



    }

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

    public void setTxtRuolo(String txtRuolo) {
        this.txtRuolo.setText(txtRuolo);
    }

    public void setTxtIndirizzo(String txtIndirizzo) {
        this.txtIndirizzo.setText(txtIndirizzo);
    }

    public JButton getBtnEsci() {
        return btnEsci;
    }

    public void setTxtStipendio(String stipendioString) {
        this.txtStipendio.setText(stipendioString);
    }


    public void propertyChange(PropertyChangeEvent evt) {
        String propertyName = evt.getPropertyName();
        if("dipendente_aggiornato".equals(propertyName)){
            Dipendente dipendente = (Dipendente) evt.getNewValue();
            setTxtNome(dipendente.getNome());
            setTxtCognome(dipendente.getCognome());
            setTxtSesso(dipendente.getSesso());
            setTxtLuogoNascita(dipendente.getLuogoNascita());
            setTxtDataNascita(dipendente.getDataNascita().toString());
            setTxtCellulare(dipendente.getCellulare());
            setTxtIndirizzo(dipendente.getIndirizzo());
            setTxtID(dipendente.getId().toString());
        }


    }

}
