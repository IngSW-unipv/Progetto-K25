package it.unipv.ingsfw.treninordovest.controller.misc;

import it.unipv.ingsfw.treninordovest.dao.implementations.utenti.ClienteDAOImpl;
import it.unipv.ingsfw.treninordovest.dao.implementations.utenti.DipendenteDAOImpl;
import it.unipv.ingsfw.treninordovest.factory.UtenteDAOFactory;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;
import it.unipv.ingsfw.treninordovest.view.frames.login.JLoginFrame;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JCustomerMainFrame;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JEmployeeMainFrame;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JMainMenuFrame;
import it.unipv.ingsfw.treninordovest.view.panels.miscellanous.LoginPanel;


import javax.swing.*;


/*Controller del Login, effettua verifiche sulle credenziali e crea i frame dei rispettivi utenti. Con ciò si unifica e si semplifica l'accesso al sistema */

public class LoginController {
    private final LoginPanel view;
    private final JLoginFrame frame;
    //private Ruolo ruolo; // CLIENTE o DIPENDENTE

    public LoginController(LoginPanel view, JLoginFrame loginFrame) {
        this.view = view;
        this.frame = loginFrame;
        initController();
    }

    private void initController() {
        view.getBottoneAccesso().addActionListener(e -> doLogin());
        view.getBottoneIndietro().addActionListener(e-> tornaAlMenu());
    }

    private void doLogin() {
        String username = view.getCampoUtente().getText();
        String password = view.getCampoPassword().getText();
        String ruolo = view.getComboRuolo();
        UtenteDAOFactory utenteDAOFactory= new UtenteDAOFactory();

        try {
            /*Uso del pattern Factory per unificare il login del cliente e del dipendente*/
            ClienteDAOImpl clienteDAO;
            DipendenteDAOImpl dipendenteDAO;

            //Verifica del ruolo della combobox in cui si istanziano i rispettivi DAO a secondo della scelta adottata.
            if (ruolo.equals("Cliente")) {
                clienteDAO = (ClienteDAOImpl) utenteDAOFactory.getUtenteDao(ruolo);

                if(clienteDAO.autenticate(username,password)!=null){
                    //Imposto l'utente loggato
                    SessionManager.getInstance().setCurrentUser(clienteDAO.autenticate(username,password));

                    System.out.println(SessionManager.getInstance().getCurrentUser()); //Riga di debug

                    JCustomerMainFrame customerMainFrame = new JCustomerMainFrame();

                    customerMainFrame.setVisible(true);
                    frame.setVisible(false);
                }else {
                    JOptionPane.showMessageDialog(view, "Credenziali errate !!!");
                }

            }else if (ruolo.equals("Dipendente")) {
                  dipendenteDAO= (DipendenteDAOImpl) utenteDAOFactory.getUtenteDao(ruolo);

                  if(dipendenteDAO.autenticate(username,password)!=null){
                      //Imposto l'utente loggato
                      SessionManager.getInstance().setCurrentUser(dipendenteDAO.autenticate(username,password));

                      System.out.println(SessionManager.getInstance().getCurrentUser());

                      JEmployeeMainFrame employeeFrame = new JEmployeeMainFrame();
                      employeeFrame.setVisible(true);
                      frame.setVisible(false);
                  }
                  else {
                      JOptionPane.showMessageDialog(view, "Credenziali errate !!!");
                  }

            }

        } catch (Exception ex) {
            ex.getMessage();
            ex.printStackTrace();
            JOptionPane.showMessageDialog(view, "Errore", "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void tornaAlMenu(){
        //Pulsante di ritorno al menù principale
        frame.setVisible(false);
        JMainMenuFrame newFrame = new JMainMenuFrame();
        newFrame.setVisible(true);
    }
}

