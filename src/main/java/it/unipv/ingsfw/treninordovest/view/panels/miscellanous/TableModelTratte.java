package it.unipv.ingsfw.treninordovest.view.panels.miscellanous;

import it.unipv.ingsfw.treninordovest.model.ferrovia.Tratta;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TableModelTratte extends AbstractTableModel {

    private List<Tratta> listaTratte = new ArrayList<>(); // Inizializzazione come lista vuota
    private final String[] columnNames = {"ID", "Nome tratta","Lunghezza"};

    public TableModelTratte() {
        // Il costruttore ora è pulito perché l'inizializzazione è fatta nella dichiarazione
    }

    public void setData(List<Tratta> tratte) {
        this.listaTratte = tratte != null ? tratte : new ArrayList<>();
        // Notifica alla JTable che il modello è cambiato
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        return listaTratte.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tratta tratta = listaTratte.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tratta.getIdTratta();
            case 1:
                return tratta.getNome();
            case 2:
                return tratta.getLunghezza();
            default:
                return null;
        }
    }
}