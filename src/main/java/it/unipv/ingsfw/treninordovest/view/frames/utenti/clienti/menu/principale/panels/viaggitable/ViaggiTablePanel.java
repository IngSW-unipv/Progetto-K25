package it.unipv.ingsfw.treninordovest.view.frames.utenti.clienti.menu.principale.panels.viaggitable;


import it.unipv.ingsfw.treninordovest.model.ferrovia.viaggio.Viaggio;


import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ViaggiTablePanel extends JPanel {

    private final ViaggiTableModel tableModelTratte;

    public ViaggiTablePanel() {

        tableModelTratte = new ViaggiTableModel();
        JTable table = new JTable(tableModelTratte);

        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);


    }

    public void setData(List<Viaggio> listaTratte ){
        tableModelTratte.setData(listaTratte);
    }

    public void aggiornaTratta() {
        tableModelTratte.fireTableDataChanged();
    }

}
