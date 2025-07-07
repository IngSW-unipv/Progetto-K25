package it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.dipendente.panels; // Ho cambiato il package per riflettere che è un pannello

import javax.swing.*;
import java.awt.*;

// 1. La classe ora estende JPanel
public class EmployeeMainPanel extends JPanel {

    private final JTabbedPane tabbedPane = new JTabbedPane();
    private final TravelDocCheckPanel travelDocCheckPanel = new TravelDocCheckPanel();
    private final EmployeeProfilePanel profilePanel = new EmployeeProfilePanel();



    public EmployeeMainPanel() {
        // 2. Rimosse tutte le impostazioni della finestra.
        // Imposta il layout per questo pannello.
        this.setLayout(new BorderLayout());

        // 3. Il metodo per inizializzare i componenti interni rimane.
        initComponents();
    }

    private void initComponents() {
        // Aggiungi le schede al tabbed pane
        tabbedPane.addTab("Controllo titoli", travelDocCheckPanel);
        tabbedPane.addTab("Profilo", profilePanel);

        // Aggiungi il JTabbedPane a questo pannello (JPanel)
        add(tabbedPane, BorderLayout.CENTER);
    }

    // 4. Getter per permettere ai controller esterni di accedere ai sotto-pannelli
    public TravelDocCheckPanel getTravelDocCheckPanel() {
        return travelDocCheckPanel;
    }

    public EmployeeProfilePanel getProfilePanel() {
        return profilePanel;
    }
}


