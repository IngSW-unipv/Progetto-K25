package it.unipv.ingsfw.treninordovest.view.frames.mainmenu.panels.cliente.panels.viaggitable;


import it.unipv.ingsfw.treninordovest.model.ferrovia.viaggio.Viaggio;


import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class ViaggiTablePanel extends JPanel implements PropertyChangeListener {

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

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if("ottieni_viaggi_disponibili".equals(evt.getPropertyName())){
            if(evt.getNewValue() == null){
                JOptionPane.showMessageDialog(this, "Nessun viaggio disponibile");
            } else{
                this.setData((List<Viaggio>) evt.getNewValue());
                JOptionPane.showMessageDialog(this, "Viaggi disponibili");
            }

        }
    }
}
