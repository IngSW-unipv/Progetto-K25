package it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.panels.titolitable;

import it.unipv.ingsfw.treninordovest.model.ferrovia.viaggio.Viaggio;
import it.unipv.ingsfw.treninordovest.model.titoli.abbonamento.Abbonamento;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class AbbonamentiAcquistatiTableModel extends AbstractTableModel {

    private List<Abbonamento> listaAbbonamenti = new ArrayList<>(); // Inizializzazione come lista vuota
    private final String[] columnNames = {"ID","Tipo","Scadenza", "Prezzo"};

    public AbbonamentiAcquistatiTableModel() {
        // Il costruttore ora è pulito perché l'inizializzazione è fatta nella dichiarazione
    }

    public void setData(List<Abbonamento> abbonamenti) {
        this.listaAbbonamenti = abbonamenti != null ? abbonamenti : new ArrayList<>();
        // Notifica alla JTable che il modello è cambiato
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        return listaAbbonamenti.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Abbonamento abbonamenti = listaAbbonamenti.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return abbonamenti.getId();
                case 1:
                    return abbonamenti.getTipoAbbonamento();
                    case 2:
                        return abbonamenti.getScadenza();
            case 3:
                return abbonamenti.getPrezzo();


            default:
                return null;
        }
    }
}