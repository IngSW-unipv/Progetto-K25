package it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.panels;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class CreditCardDialog extends JDialog {

    // Campi per l'input dell'utente
    private JTextField cardNumberField;
    private JTextField cardHolderNameField;
    private JComboBox<Integer> expiryMonthComboBox;
    private JComboBox<Integer> expiryYearComboBox;
    private JPasswordField cvcField;

    public final static String CMD_Confirm ="confirm";
    public final static String CMD_Cancel ="cancel";

    private JButton confirmButton;
    private JButton cancelButton;

    // Per memorizzare il risultato
    private CreditCardData cardData;

    /**
     * Costruttore del dialog
     * @param parent Il frame genitore a cui questo dialog appartiene
     */
    public CreditCardDialog(Frame parent) {
        super(parent, "Dati Carta di Credito", true); // true = modale

        // Impostazioni della finestra
        setSize(400, 250);
        setLocationRelativeTo(parent);
        setLayout(new BorderLayout());

        initComponents();
        initListeners();

        // Aggiunge il pannello principale al dialog
        add(createMainPanel(), BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.SOUTH);
    }

    private void initComponents() {
        cardNumberField = new JTextField(16);
        cardHolderNameField = new JTextField(20);
        cvcField = new JPasswordField(3);

        // ComboBox per il mese
        Integer[] months = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};
        expiryMonthComboBox = new JComboBox<>(months);

        // ComboBox per l'anno (es. prossimi 10 anni)
        Integer[] years = new Integer[10];
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 0; i < 10; i++) {
            years[i] = currentYear + i;
        }
        expiryYearComboBox = new JComboBox<>(years);

        confirmButton = new JButton("Conferma");
        cancelButton = new JButton("Annulla");
    }

    /**
     * Crea il pannello principale con i campi di input
     */
    private JPanel createMainPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Riga 0: Nome Titolare
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(new JLabel("Nome Titolare:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(cardHolderNameField, gbc);

        // Riga 1: Numero Carta
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(new JLabel("Numero Carta:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(cardNumberField, gbc);

        // Riga 2: Scadenza
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(new JLabel("Scadenza (MM/YY):"), gbc);

        JPanel expiryPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        expiryPanel.add(expiryMonthComboBox);
        expiryPanel.add(new JLabel(" / "));
        expiryPanel.add(expiryYearComboBox);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        panel.add(expiryPanel, gbc);

        // Riga 3: CVC
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        panel.add(new JLabel("CVC:"), gbc);
        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.NONE;
        cvcField.setColumns(4);
        panel.add(cvcField, gbc);



        confirmButton.setActionCommand(CMD_Confirm);
        cancelButton.setActionCommand(CMD_Cancel);


        return panel;
    }

    /**
     * Crea il pannello con i bottoni Conferma/Annulla
     */
    private JPanel createButtonPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.add(confirmButton);
        panel.add(cancelButton);
        return panel;
    }

    private void initListeners() {
        confirmButton.addActionListener(e -> onConfirm());
        cancelButton.addActionListener(e -> onCancel());
    }

    private void onConfirm() {
        // Qui dovresti aggiungere la validazione dei dati!
        // Esempio: verificare che i campi non siano vuoti, che il numero sia valido, ecc.

        // Raccoglie i dati in un oggetto
        this.cardData = new CreditCardData(
                cardNumberField.getText(),
                cardHolderNameField.getText(),
                (Integer) expiryMonthComboBox.getSelectedItem(),
                (Integer) expiryYearComboBox.getSelectedItem(),
                new String(cvcField.getPassword())
        );
        // Chiude il dialog
        dispose();
    }

    private void onCancel() {
        this.cardData = null; // Nessun dato se si annulla
        dispose(); // Chiude il dialog
    }

    /**
     * Metodo pubblico per mostrare il dialog e ottenere i dati inseriti.
     * @return L'oggetto CreditCardData se l'utente ha confermato, altrimenti null.
     */
    public CreditCardData showDialog() {
        setVisible(true);
        // Il codice qui si blocca finché il dialog non viene chiuso
        return this.cardData;
    }

    /**
     * Una semplice classe (record) per contenere i dati della carta.
     */
    public record CreditCardData(String cardNumber, String cardHolderName, int expiryMonth, int expiryYear, String cvc) {}


    public JButton getConfirmButton() {
        return confirmButton;
    }

    public JButton getCancelButton() {
        return cancelButton;
    }
}