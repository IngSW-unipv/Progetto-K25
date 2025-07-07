package it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.panels.titolitable;

import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.Abbonamento;
import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.Biglietto;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class TitoliViaggioTablePanel extends JPanel implements PropertyChangeListener {

    // Nomi delle "carte" per il CardLayout
    public static final String ABBONAMENTI_CARD = "AbbonamentiCard";
    public static final String BIGLIETTI_CARD = "BigliettiCard";
    public static final String SHOW_BIGLIETTI = "ShowBiglietti";
    public static final String SHOW_ABBONAMENTI = "ShowAbbonamenti";

    private final AbbonamentiAcquistatiTableModel tableAbbonamentiModel;
    private final BigliettiAcquistatiTableModel tableBigliettiModel;

    private final JTable tableAbbonamenti;
    private final JTable tableBiglietti;

    private final JPanel cardsPanel; // Il pannello che userà il CardLayout
    private final CardLayout cardLayout; // Il layout manager

    private JButton btnShowAbbonamenti;
    private JButton btnShowBiglietti;

    public TitoliViaggioTablePanel() {
        // Imposta il layout principale del pannello TitoliViaggioTablePanel
        // Useremo un BorderLayout per posizionare i bottoni in alto e il cardsPanel al centro
        setLayout(new BorderLayout());

        // 1. Inizializza i TableModel
        tableAbbonamentiModel = new AbbonamentiAcquistatiTableModel();
        tableBigliettiModel = new BigliettiAcquistatiTableModel();

        // 2. Crea le JTable usando i TableModel
        tableAbbonamenti = new JTable(tableAbbonamentiModel);
        tableBiglietti = new JTable(tableBigliettiModel);

        // Aggiungi gli scroll pane per le tabelle
        JScrollPane scrollPaneAbbonamenti = new JScrollPane(tableAbbonamenti);
        JScrollPane scrollPaneBiglietti = new JScrollPane(tableBiglietti);

        // 3. Inizializza il CardLayout e il pannello che lo userà
        cardLayout = new CardLayout();
        cardsPanel = new JPanel(cardLayout); // Questo pannello conterrà le "carte"

        // 4. Aggiungi i pannelli (JScrollPane delle tabelle) come "carte"
        // Ogni "carta" ha un nome stringa unico per identificarla
        cardsPanel.add(scrollPaneAbbonamenti, ABBONAMENTI_CARD);
        cardsPanel.add(scrollPaneBiglietti, BIGLIETTI_CARD);

        // 5. Crea i bottoni per cambiare la "carta"
        btnShowAbbonamenti = new JButton("Mostra Abbonamenti");
        btnShowBiglietti = new JButton("Mostra Biglietti");

        // Crea un pannello per i bottoni e aggiungili
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(btnShowAbbonamenti);
        buttonPanel.add(btnShowBiglietti);

        // 6. Aggiungi i pannelli al TitoliViaggioTablePanel
        add(buttonPanel, BorderLayout.NORTH); // Bottoni in alto
        add(cardsPanel, BorderLayout.CENTER); // Pannello delle carte al centro

        // Inizialmente mostra la carta degli abbonamenti
        cardLayout.show(cardsPanel, ABBONAMENTI_CARD);

        btnShowAbbonamenti.setActionCommand(SHOW_ABBONAMENTI);
        btnShowBiglietti.setActionCommand(SHOW_BIGLIETTI);

    }

    // --- Metodi per impostare i dati (usati dal Controller) ---
    public void setDataBiglietti(List<Biglietto> listaTitoli) {
        tableBigliettiModel.setData(listaTitoli);
        // tableBigliettiModel.fireTableDataChanged(); // Già chiamato da setData se implementato correttamente
    }

    public void setDataAbbonamenti(List<Abbonamento> listaTitoli) {
        tableAbbonamentiModel.setData(listaTitoli);
        // tableAbbonamentiModel.fireTableDataChanged(); // Già chiamato da setData se implementato correttamente
    }

    // --- Metodi per aggiornare la visualizzazione (usati dal Controller) ---
    // Questi metodi possono essere utili se il TableModel non notifica automaticamente i cambiamenti alla tabella
    public void aggiornaTabellaAbbonamenti() {
        tableAbbonamentiModel.fireTableDataChanged();
    }

    public void aggiornaTabellaBiglietti() {
        tableBigliettiModel.fireTableDataChanged();
    }

    // --- Metodi per mostrare una specifica "carta" (usati dal Controller) ---
    public void showAbbonamentiCard() {
        cardLayout.show(cardsPanel, ABBONAMENTI_CARD);
    }

    public void showBigliettiCard() {
        cardLayout.show(cardsPanel, BIGLIETTI_CARD);
    }

    // --- Getters per i bottoni (usati dal Controller per aggiungere ActionListeners) ---
    public JButton getBtnShowAbbonamenti() {
        return btnShowAbbonamenti;
    }

    public JButton getBtnShowBiglietti() {
        return btnShowBiglietti;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

        if ("get_titoliBiglietti_acq".equals(evt.getPropertyName()) && evt.getNewValue() != null){
            tableBigliettiModel.setData((List<Biglietto>) evt.getNewValue());

        }
        if("get_titoliAbbonamenti_acq".equals(evt.getPropertyName()) && evt.getNewValue() != null){
            tableAbbonamentiModel.setData((List<Abbonamento>) evt.getNewValue());
        }

    }
}
