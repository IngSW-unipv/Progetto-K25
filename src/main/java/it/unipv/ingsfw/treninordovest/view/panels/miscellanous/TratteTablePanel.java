package it.unipv.ingsfw.treninordovest.view.panels.miscellanous;

import it.unipv.ingsfw.treninordovest.model.ferrovia.Tratta;


import javax.swing.*;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.util.*;
import java.util.List;

public class TratteTablePanel extends JPanel {

    private JTable table;
    private TableModelTratte tableModelTratte;

    public TratteTablePanel() {

        tableModelTratte = new TableModelTratte();
        table = new JTable(tableModelTratte);

        setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);


    }

    public void setData(List<Tratta> tratte ){
        tableModelTratte.setData(tratte);
    }

    public void aggiornaTratta() {
        tableModelTratte.fireTableDataChanged();
    }

}
