package it.unipv.ingsfw.treninordovest.main;

import it.unipv.ingsfw.treninordovest.view.frames.login.JLoginFrame;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JMainMenuFrame;

import javax.swing.*;

public class AppStart {

    private static JMainMenuFrame mainFrame;

    public static void main(String[] args) {

       mainFrame = new JMainMenuFrame();
       mainFrame.setVisible(true);
       mainFrame.setLocationRelativeTo(null);


    }

}
