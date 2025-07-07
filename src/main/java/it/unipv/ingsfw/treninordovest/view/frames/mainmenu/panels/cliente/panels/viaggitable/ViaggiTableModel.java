package it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.panels.viaggitable;

import it.unipv.ingsfw.treninordovest.model.ferrovia.viaggio.Viaggio;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class ViaggiTableModel extends AbstractTableModel {

    private List<Viaggio> listaTratte = new ArrayList<>(); // Inizializzazione come lista vuota
    private final String[] columnNames = {"IDViaggio","Treno","Partenza","Destinazione","Ora Partenza","Ora Arrivo", "Data Viaggio"};

    public ViaggiTableModel() {
        // Il costruttore ora è pulito perché l'inizializzazione è fatta nella dichiarazione
    }

    public void setData(List<Viaggio> tratte) {
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
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Viaggio tratta = listaTratte.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tratta.getIdViaggio();
            case 1:
                return tratta.getTreno().getIdTreno();
            case 2:
                return tratta.getPartenza().getCitta();
                case 3:
                    return tratta.getDestinazione().getCitta();
                    case 4:
                        return tratta.getOraPartenza();
                        case 5:
                            return tratta.getOraArrivo();
                            case 6:
                                return tratta.getDataViaggio();
            default:
                return null;
        }
    }
}