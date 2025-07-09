package it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.panels;

import javax.swing.*;
import java.awt.*;

public class WizardDialog extends JDialog {

    // Nomi univoci per ogni "carta" del nostro layout. Usare costanti è una buona pratica.
    private static final String PANEL_SCELTA = "Pannello di Scelta";
    private static final String PANEL_CARTA_CREDITO = "Pannello Carta di Credito";
    private static final String PANEL_PAYPAL = "Pannello PayPal";

    private CardLayout cardLayout;
    private JPanel pannelloContenitore; // Il "mazzo" di carte

    public WizardDialog(Frame owner) {
        super(owner, "Procedura di Pagamento", true);

        // 1. Creazione del layout e del pannello contenitore
        cardLayout = new CardLayout();
        pannelloContenitore = new JPanel(cardLayout);

        // 2. Creazione e aggiunta dei singoli pannelli ("carte")
        JPanel pannelloScelta = creaPannelloScelta();
        JPanel pannelloCarta = creaPannelloCartaCredito();
        JPanel pannelloPaypal = creaPannelloPaypal();

        pannelloContenitore.add(pannelloScelta, PANEL_SCELTA);
        pannelloContenitore.add(pannelloCarta, PANEL_CARTA_CREDITO);
        pannelloContenitore.add(pannelloPaypal, PANEL_PAYPAL);

        // Imposta il layout principale del dialogo e aggiunge il contenitore delle carte
        setLayout(new BorderLayout());
        add(pannelloContenitore, BorderLayout.CENTER);

        // Mostra la prima carta all'avvio
        cardLayout.show(pannelloContenitore, PANEL_SCELTA);

        setSize(450, 250);
        setLocationRelativeTo(owner);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
    }

    /**
     * Crea il pannello iniziale per la scelta del metodo di pagamento.
     */
    private JPanel creaPannelloScelta() {
        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel titolo = new JLabel("Seleziona un metodo di pagamento:", SwingConstants.CENTER);
        JButton btnCarta = new JButton("Procedi con Carta di Credito");
        JButton btnPaypal = new JButton("Procedi con PayPal");

        // ActionListener per mostrare il pannello della carta di credito
        btnCarta.addActionListener(e -> cardLayout.show(pannelloContenitore, PANEL_CARTA_CREDITO));

        // ActionListener per mostrare il pannello di PayPal
        btnPaypal.addActionListener(e -> cardLayout.show(pannelloContenitore, PANEL_PAYPAL));

        panel.add(titolo);
        panel.add(btnCarta);
        panel.add(btnPaypal);
        return panel;
    }

    /**
     * Crea il pannello per l'inserimento dei dati della carta di credito.
     */
    private JPanel creaPannelloCartaCredito() {
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Pagamento con Carta di Credito", SwingConstants.CENTER), BorderLayout.NORTH);

        // Pannello per i campi di input
        JPanel formPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        formPanel.add(new JLabel("Numero Carta:"));
        formPanel.add(new JTextField());
        formPanel.add(new JLabel("CVV:"));
        formPanel.add(new JTextField());
        panel.add(formPanel, BorderLayout.CENTER);

        // Pannello per i bottoni di navigazione
        JPanel navPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnIndietro = new JButton("Indietro");
        JButton btnConferma = new JButton("Conferma Pagamento");

        btnIndietro.addActionListener(e -> cardLayout.show(pannelloContenitore, PANEL_SCELTA));
        btnConferma.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Pagamento con Carta effettuato!");
            dispose();
        });

        navPanel.add(btnIndietro);
        navPanel.add(btnConferma);
        panel.add(navPanel, BorderLayout.SOUTH);

        return panel;
    }

    /**
     * Crea il pannello per il login di PayPal.
     */
    private JPanel creaPannelloPaypal() {
        // La struttura è simile a quella per la carta di credito
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panel.add(new JLabel("Login PayPal", SwingConstants.CENTER), BorderLayout.NORTH);

        JPanel formPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        formPanel.add(new JLabel("Email PayPal:"));
        formPanel.add(new JTextField());
        formPanel.add(new JLabel("Password:"));
        formPanel.add(new JPasswordField());
        panel.add(formPanel, BorderLayout.CENTER);

        JPanel navPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JButton btnIndietro = new JButton("Indietro");
        JButton btnConferma = new JButton("Paga Ora");

        btnIndietro.addActionListener(e -> cardLayout.show(pannelloContenitore, PANEL_SCELTA));
        btnConferma.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, "Pagamento con PayPal effettuato!");
            dispose();
        });

        navPanel.add(btnIndietro);
        navPanel.add(btnConferma);
        panel.add(navPanel, BorderLayout.SOUTH);

        return panel;
    }

    public void showDialog() {
        this.setVisible(true);
    }
}