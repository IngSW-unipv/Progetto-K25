package it.unipv.ingsfw.treninordovest.view;

import it.unipv.ingsfw.treninordovest.view.panels.LogoPanel;
import it.unipv.ingsfw.treninordovest.view.panels.StartMenuPanel;

import javax.swing.*;

public class JMainFrame extends JFrame {

    /*Creazione menu principale dell'applicazione treninordovest*/

    private JMenuBar menuBar;
    private JPanel panel;


    public JMainFrame() {
        //Inizializzazione menu
        initialize();

        StartMenuPanel startMenuPanel = new StartMenuPanel();
        add(startMenuPanel);
        LogoPanel logoPanel = new LogoPanel();
        add(logoPanel);

    }

    public void initialize (){
        setTitle("Treninordovest - Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(null);
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        setVisible(true);
        setSize(450, 300);

    }




}
