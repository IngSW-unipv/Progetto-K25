package it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.panels.titolitable;

import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.Biglietto;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class BigliettiAcquistatiTableModel extends AbstractTableModel {

    private List<Biglietto> listaBiglietti = new ArrayList<>(); // Inizializzazione come lista vuota
    private final String[] columnNames = {"ID","Emissione","Validazione","Prezzo"};

    public BigliettiAcquistatiTableModel() {
    }

    public void setData(List<Biglietto> biglietti) {
        this.listaBiglietti = biglietti != null ? biglietti : new ArrayList<>();
        // Notifica alla JTable che il modello è cambiato
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getRowCount() {
        return listaBiglietti.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Biglietto biglietti = listaBiglietti.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return biglietti.getId();
            case 1:
                return biglietti.getEmissione();
            case 2:
                return biglietti.isValidato();
            case 3:
                return biglietti.getPrezzo();

            default:
                return null;
        }
    }

}
