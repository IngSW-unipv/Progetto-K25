package it.unipv.ingsfw.treninordovest.view.panels.miscellanous;

import it.unipv.ingsfw.treninordovest.model.ferrovia.Tratta;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class TableModelTratte extends AbstractTableModel {

    private List<Tratta> listaTratte;//=new ArrayList<Tratta>();
    private final String[] columnNames = {"ID", "Nome tratta","Lunghezza"};

    public TableModelTratte() {

    }

    public void setData(List<Tratta> tratte ){
        this.listaTratte = tratte;
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
                        return  tratta.getLunghezza();
        }

        return null;
    }


}
