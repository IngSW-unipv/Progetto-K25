package it.unipv.ingsfw.treninordovest.view.panels.users;

import javax.swing.*;
import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDate;


public class CustomerRegistrationPanel extends JPanel {
    //private JTextField txtUsername;
    private final JPasswordField txtPassword;
    private final JTextField txtNome;
    private final JTextField txtCognome;
    private final JTextField txtCellulare;
    private final JTextField txtEmail;
    private final JTextField txtIndirizzo;
    private final JButton btnRegister;
    private final JButton btnMenuPrincipal;
    private final JComboBox<String> comboSesso;
    private final JDateChooser dateChooser;
    private final JTextField txtLuogoNascita;
    private Color colorePannello;

    public static final String CMD_Register = "register";
    public static final String CMD_Back = "back";



    public CustomerRegistrationPanel() {
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
        String sesso[]= {"-","M", "F"};
        comboSesso = new JComboBox(sesso);

        JLabel lblcellulare = new JLabel("Cellulare:");
        txtCellulare = new JTextField(15);

        JLabel lblemail = new JLabel("Email:");
        txtEmail = new JTextField(15);


        JLabel lblindirizzo = new JLabel("Indirizzo:");
        txtIndirizzo = new JTextField(15);


        btnRegister = new JButton("Registrati");
        btnMenuPrincipal = new JButton("Menu Principale");

        JLabel lbldataNascita= new JLabel("Data di nascita:");
        dateChooser= new JDateChooser();
        dateChooser.setDateFormatString("yyyy-MM-dd");

        JLabel lblLuogoNascita = new JLabel("Luogo di nascita:");
        txtLuogoNascita = new JTextField(15);


        //Assegnazione dei comandi
        btnRegister.setActionCommand(CMD_Register);
        btnMenuPrincipal.setActionCommand(CMD_Back);

        //Username
        /*
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(lblUsername, gbc);
        gbc.gridx = 1;
        add(txtUsername, gbc);*/

        //Email
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(lblemail, gbc);
        gbc.gridx = 1;
        add(txtEmail, gbc);

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

        //Bottone di registrazione
        gbc.gridx = 0;
        gbc.gridy = 10;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(btnRegister, gbc);
        //Bottone che torna al menu
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(btnMenuPrincipal, gbc);



    }

    // Getters per il Controller
    //public JTextField getTxtUsername() { return txtUsername; }
    public JPasswordField getTxtPassword() { return txtPassword; }
    public JTextField getTxtNome() { return txtNome; }
    public JTextField getTxtCognome() { return txtCognome; }
    public JTextField getTxtEmail() { return txtEmail; }
    public JButton getBtnRegister() { return btnRegister; }
    public JTextField getTxtCellulare() {
        return txtCellulare;
    }
    public JTextField getTxtIndirizzo() {
        return txtIndirizzo;
    }
    public String getComboSesso() {
        return (String) comboSesso.getSelectedItem();
    }
    public JDateChooser getDataNascita() {
        return dateChooser;
    }
    public JTextField getTxtLuogoNascita() {
        return txtLuogoNascita;
    }
    public JButton getBtnMenuPrincipal() {return btnMenuPrincipal; }

    public void addActionListener(ActionListener listener) {
        btnRegister.addActionListener(listener);
        btnMenuPrincipal.addActionListener(listener);
    }
}