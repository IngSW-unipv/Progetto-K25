package it.unipv.ingsfw.treninordovest.view.panels.miscellanous;
import javax.swing.*;
import java.awt.*;

public class StartMenuPanel extends JPanel {

    public StartMenuPanel() {
        // Imposta un layout adatto (ad es. GridBagLayout per una disposizione flessibile)
        setLayout(new GridBagLayout());

        // Esempio: aggiungi un pulsante "Avvia" al centro
        JButton startButton = new JButton("Avvia");
        startButton.addActionListener(e -> {
            // Logica per passare alla schermata successiva
            JOptionPane.showMessageDialog(this, "Avvio del sistema Treninordovest!");
        });

        add(startButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Sfondo blu
        g.setColor(new Color(131, 168, 195));
        g.fillRect(0, 0, getWidth(), getHeight());

        // Disegna il testo "treninordovest" al centro
        //g.setColor(Color.BLUE);
        g.setFont(new Font("Arial", Font.BOLD, 48));
        String text = "Treninordovest";
        FontMetrics fm = g.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(text)) / 2;
        int y = getHeight() / 2;
        g.drawString(text, x, y);
    }
}
