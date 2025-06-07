package it.unipv.ingsfw.treninordovest.view.panels.miscellanous;

import it.unipv.ingsfw.treninordovest.model.ferrovia.tratta.Tratta;


import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TratteTablePanel extends JPanel {

    private final TableModelTratte tableModelTratte;

    public TratteTablePanel() {

        tableModelTratte = new TableModelTratte();
        JTable table = new JTable(tableModelTratte);

        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);


    }

    public void setData(List<Tratta> listaTratte ){
        tableModelTratte.setData(listaTratte);
    }

    public void aggiornaTratta() {
        tableModelTratte.fireTableDataChanged();
    }

}
