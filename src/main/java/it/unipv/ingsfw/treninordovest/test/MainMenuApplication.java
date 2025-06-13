package it.unipv.ingsfw.treninordovest.test;

import it.unipv.ingsfw.treninordovest.view.frames.utenti.clienti.menu.principale.JCustomerMainFrame;
import it.unipv.ingsfw.treninordovest.view.frames.utenti.clienti.menu.registrazione.JCustomerRegFrame;
import it.unipv.ingsfw.treninordovest.view.frames.utenti.dipendenti.menu.principale.JEmployeeMainFrame;
import it.unipv.ingsfw.treninordovest.view.frames.utenti.dipendenti.menu.registrazione.JEmployeeRegFrame;
import it.unipv.ingsfw.treninordovest.view.frames.login.JLoginFrame;
import it.unipv.ingsfw.treninordovest.view.frames.mainmenu.JMainMenuFrame;

public class MainMenuApplication {

        public static void main(String[] args) {



                        JCustomerMainFrame frame = new JCustomerMainFrame();
                        frame.setVisible(true);




                        JCustomerRegFrame frame1 = new JCustomerRegFrame();
                        frame1.setVisible(true);




                        JLoginFrame frame2 = new JLoginFrame();
                        frame2.setVisible(true);


                        JEmployeeMainFrame frame3 = new JEmployeeMainFrame();
                        frame3.setVisible(true);

                        JEmployeeRegFrame frame4 = new JEmployeeRegFrame();
                        frame4.setVisible(true);


                        JMainMenuFrame frame5 = new JMainMenuFrame();
                        frame5.setVisible(true);


        }

}
