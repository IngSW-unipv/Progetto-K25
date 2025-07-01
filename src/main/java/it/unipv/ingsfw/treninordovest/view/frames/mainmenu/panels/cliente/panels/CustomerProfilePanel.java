package it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.panels;

import javax.swing.*;
import java.awt.*;

public class CustomerProfilePanel extends JPanel {
    // Campi per i dati del profilo (read-only)
    private JTextField txtNome;
    private  JTextField txtCognome;
    private  JTextField txtEmail;
    private  JTextField txtSesso;
    private  JTextField txtID;
    private  JTextField txtLuogoNascita;
    private JTextField txtDataNascita;
    private  JTextField txtCellulare;
    private  JTextField txtBilancio;
    private  JTextField txtIndirizzo;

    // Campi per l'aggiornamento della password
    private  JPasswordField txtPassword;

    // Bottoni
    private JButton btnAggiornaPassword;
    private JButton btnAggiornaProfilo; // Corretto il nome
    private  JButton btnEsci;

    // Campi per la gestione del denaro (sezione aggiunta)
    private JTextField txtDenaro;
    private JButton btnConfermaDenaro;


    public CustomerProfilePanel() {
        // Impostazioni generali del pannello
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8); // Aumentato il padding per migliore estetica
        setBackground(new Color(131, 168, 195)); // Colore di sfondo

        // Intestazione del pannello
        JLabel lblIntestazione = new JLabel("Dati Profilo Utente");
        lblIntestazione.setFont(new Font("Arial", Font.BOLD, 18)); // Stile per l'intestazione
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4; // Occupa più colonne
        gbc.anchor = GridBagConstraints.CENTER; // Centra l'intestazione
        add(lblIntestazione, gbc);

        // Reset gridwidth e anchor per i componenti successivi
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        // --- Sezione Dati Profilo ---
        // Utilizziamo un pannello separato per organizzare meglio i dati del profilo
        JPanel profileDataPanel = new JPanel(new GridBagLayout());
        profileDataPanel.setBackground(getBackground()); // Stesso sfondo del pannello principale
        profileDataPanel.setBorder(BorderFactory.createTitledBorder("Informazioni Personali")); // Bordo con titolo

        GridBagConstraints profileGbc = new GridBagConstraints();
        profileGbc.insets = new Insets(5, 5, 5, 5);
        profileGbc.fill = GridBagConstraints.HORIZONTAL;

        int row = 0;

        txtNome = createReadOnlyTextField();
        addLabeledField(profileDataPanel, "Nome:", txtNome, profileGbc, row++);

        txtCognome = createReadOnlyTextField();
        addLabeledField(profileDataPanel, "Cognome:", txtCognome, profileGbc, row++);

        txtSesso = createReadOnlyTextField();
        addLabeledField(profileDataPanel, "Sesso:", txtSesso, profileGbc, row++);

        txtLuogoNascita = createReadOnlyTextField();
        addLabeledField(profileDataPanel, "Luogo di Nascita:", txtLuogoNascita, profileGbc, row++);

        txtDataNascita = createReadOnlyTextField();
        addLabeledField(profileDataPanel, "Data di Nascita:", txtDataNascita, profileGbc, row++);

        txtCellulare = createReadOnlyTextField();
        addLabeledField(profileDataPanel, "Cellulare:", txtCellulare, profileGbc, row++);

        txtIndirizzo = createReadOnlyTextField();
        addLabeledField(profileDataPanel, "Indirizzo:", txtIndirizzo, profileGbc, row++);

        txtEmail = createReadOnlyTextField();
        addLabeledField(profileDataPanel, "Email:", txtEmail, profileGbc, row++);

        txtBilancio = createReadOnlyTextField();
        addLabeledField(profileDataPanel, "Bilancio:", txtBilancio, profileGbc, row++);

        txtID = createReadOnlyTextField();
        addLabeledField(profileDataPanel, "ID Cliente:", txtID, profileGbc, row++);

        // Aggiungi il pannello dei dati del profilo al pannello principale
        gbc.gridx = 2; // Posiziona a destra
        gbc.gridy = 1;
        gbc.gridheight = 10; // Occupa più righe
        gbc.fill = GridBagConstraints.BOTH; // Riempie lo spazio
        gbc.weightx = 1.0; // Espansione orizzontale
        gbc.weighty = 1.0; // Espansione verticale
        add(profileDataPanel, gbc);

        // Bottone per aggiornare il profilo (sotto i dati del profilo)
        gbc.gridx = 2;
        gbc.gridy = 11;
        gbc.gridheight = 1; // Reset gridheight
        gbc.gridwidth = 2; // Occupa due colonne
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 0; // Reset weightx
        gbc.weighty = 0; // Reset weighty
        btnAggiornaProfilo = new JButton("Aggiorna Profilo");
        add(btnAggiornaProfilo, gbc);


        // --- Sezione Aggiornamento Password ---
        JPanel passwordPanel = new JPanel(new GridBagLayout());
        passwordPanel.setBackground(getBackground());
        passwordPanel.setBorder(BorderFactory.createTitledBorder("Aggiorna Password"));

        GridBagConstraints pwdGbc = new GridBagConstraints();
        pwdGbc.insets = new Insets(5, 5, 5, 5);
        pwdGbc.fill = GridBagConstraints.HORIZONTAL;

        txtPassword = new JPasswordField(15);
        addLabeledField(passwordPanel, "Nuova Password:", txtPassword, pwdGbc, 0);

        btnAggiornaPassword = new JButton("Cambia Password");
        pwdGbc.gridx = 0;
        pwdGbc.gridy = 1;
        pwdGbc.gridwidth = 2;
        passwordPanel.add(btnAggiornaPassword, pwdGbc);

        // Aggiungi il pannello della password al pannello principale
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 3; // Occupa più righe
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 0.5; // Espansione orizzontale
        gbc.weighty = 0.5; // Espansione verticale
        add(passwordPanel, gbc);

        // --- Sezione Aggiunta Denaro (esempio) ---
        JPanel denaroPanel = new JPanel(new GridBagLayout());
        denaroPanel.setBackground(getBackground());
        denaroPanel.setBorder(BorderFactory.createTitledBorder("Aggiungi Denaro"));

        GridBagConstraints denaroGbc = new GridBagConstraints();
        denaroGbc.insets = new Insets(5, 5, 5, 5);
        denaroGbc.fill = GridBagConstraints.HORIZONTAL;

        txtDenaro = new JTextField(10); // Campo per importo denaro
        addLabeledField(denaroPanel, "Importo:", txtDenaro, denaroGbc, 0);

        btnConfermaDenaro = new JButton("Aggiungi");
        denaroGbc.gridx = 0;
        denaroGbc.gridy = 1;
        denaroGbc.gridwidth = 2;
        denaroPanel.add(btnConfermaDenaro, denaroGbc);

        // Aggiungi il pannello denaro al pannello principale

        // --- Bottone Esci (in basso a sinistra) ---
        gbc.gridx = 0;
        gbc.gridy = 11;
        gbc.gridheight = 1;
        gbc.gridwidth = 2; // Occupa due colonne
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.SOUTHWEST; // Allineato in basso a sinistra
        btnEsci = new JButton("Esci");
        add(btnEsci, gbc);
    }

    /**
     * Metodo helper per creare un JTextField read-only con un colore di sfondo specifico.
     * @return Il JTextField configurato.
     */
    private JTextField createReadOnlyTextField() {
        JTextField textField = new JTextField(15);
        textField.setEditable(false);
        textField.setBackground(new Color(255, 255, 200)); // Giallo tenue per leggerezza
        return textField;
    }

    /**
     * Metodo helper per aggiungere una label e un campo di testo a un pannello.
     * @param panel Il pannello a cui aggiungere i componenti.
     * @param labelText Il testo della label.
     * @param textField Il campo di testo da aggiungere.
     * @param gbc Le GridBagConstraints da utilizzare.
     * @param row La riga in cui posizionare i componenti.
     */
    private void addLabeledField(JPanel panel, String labelText, JTextField textField, GridBagConstraints gbc, int row) {
        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.WEST; // Allinea le label a sinistra
        panel.add(new JLabel(labelText), gbc);
        gbc.gridx = 1;
        gbc.gridy = row;
        gbc.anchor = GridBagConstraints.EAST; // Allinea i campi di testo a destra
        panel.add(textField, gbc);
    }

    // --- Getters per il controller ---

    public JButton getBtnAggiornaPassword() {
        return btnAggiornaPassword;
    }

    public JButton getBtnAggiornaProfilo() {
        return btnAggiornaProfilo;
    }

    public JPasswordField getTxtPassword() {
        return txtPassword;
    }

    public void setTxtNome(String nome) {
        this.txtNome.setText(nome);
    }

    public void setTxtCognome(String cognome) {
        this.txtCognome.setText(cognome);
    }

    public void setTxtEmail(String email) {
        this.txtEmail.setText(email);
    }

    public void setTxtSesso(String sesso) {
        this.txtSesso.setText(sesso);
    }

    public void setTxtID(String id) {
        this.txtID.setText(id);
    }

    public void setTxtLuogoNascita(String luogoNascita) {
        this.txtLuogoNascita.setText(luogoNascita);
    }

    public void setTxtDataNascita(String dataNascita) {
        this.txtDataNascita.setText(dataNascita);
    }

    public void setTxtCellulare(String cellulare) {
        this.txtCellulare.setText(cellulare);
    }

    public void setTxtBilancio(String bilancio) {
        this.txtBilancio.setText(bilancio);
    }

    public void setTxtIndirizzo(String indirizzo) {
        this.txtIndirizzo.setText(indirizzo);
    }

    public JButton getBtnEsci() {
        return btnEsci;
    }

    public JButton getBtnConfermaDenaro() {
        return btnConfermaDenaro;
    }


}
