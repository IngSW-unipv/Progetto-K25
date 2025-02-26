package it.unipv.ingsfw.treninordovest.view.panels.miscellanous;

import it.unipv.ingsfw.treninordovest.model.ferrovia.Tratta;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class TableModelTratte extends AbstractTableModel {

    private List<Tratta> tratte=new ArrayList<Tratta>();
    private String[] columnNames = {"ID", "Nome tratta","Lunghezza"};

    public TableModelTratte() {

    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    public void setData(List<Tratta> tratte ){
        this.tratte = tratte;
    }


    @Override
    public int getRowCount() {
        return this.tratte.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tratta tratta = tratte.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return tratta.getIdTratta();
                case 1:
                    return tratta.getNome();
                    case 2:
                        return  tratta.toString();
        }

        return null;
    }


}
