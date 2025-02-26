package it.unipv.ingsfw.treninordovest.controller;

import it.unipv.ingsfw.treninordovest.dao.implementations.utenti.ClienteDAOImpl;
import it.unipv.ingsfw.treninordovest.dao.implementations.utenti.DipendenteDAOImpl;
import it.unipv.ingsfw.treninordovest.model.utenti.Cliente;
import it.unipv.ingsfw.treninordovest.model.utenti.Dipendente;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JCustomerMainFrame;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JEmployeeMainFrame;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JMainMenuFrame;
import it.unipv.ingsfw.treninordovest.view.panels.users.CustomerProfilePanel;
import it.unipv.ingsfw.treninordovest.view.panels.users.EmployeeProfilePanel;

import java.sql.SQLException;

public class EmployeeProfileController {

    private EmployeeProfilePanel view;
    private JEmployeeMainFrame mainFrame;
    private DipendenteDAOImpl dipendenteDAO;
    private javax.swing.JOptionPane JOptionPane;
    private String idUtenteLog;


    public EmployeeProfileController(EmployeeProfilePanel view, JEmployeeMainFrame mainFrame) {
        this.view = view;
        this.mainFrame= mainFrame;
        initController();
    }


    private void initController() {
        // Carica i dati dell'utente dalla sessione

       view.getBtnAggiornaPassword().addActionListener(e -> aggiornaPassword());
        view.getBtnAggionaProfilo().addActionListener(e -> {
            try {
                mostraDatiProfilo();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        view.getBtnEsci().addActionListener(e -> { esci();});



    }


    private void mostraDatiProfilo() throws SQLException {
        dipendenteDAO = new DipendenteDAOImpl();

        idUtenteLog = SessionManager.getInstance().getCurrentUser().getId();
       Dipendente dipendente = dipendenteDAO.get(idUtenteLog);

        view.setTxtNome(dipendente.getNome());
        view.setTxtCognome(dipendente.getCognome());
        view.setTxtSesso(dipendente.getSesso());
        view.setTxtLuogoNascita(dipendente.getLuogoNascita());
        view.setTxtDataNascita(dipendente.getDataNascita().toString());
        view.setTxtCellulare(dipendente.getCellulare());
        view.setTxtID(dipendente.getId());
        view.setTxtIndirizzo(dipendente.getIndirizzo());
        double stipendio = dipendente.getStipendio();
        String stipendioString = String.format("%.2f", stipendio);
        view.setTxtStipendio(stipendioString);
        view.setTxtRuolo(dipendente.getRuolo());


    }

    private void esci(){
        SessionManager.getInstance().setCurrentUser(null);
        this.mainFrame.dispose();
        this.mainFrame.setVisible(false);
        JMainMenuFrame mainMenuFrame = new JMainMenuFrame();
        mainMenuFrame.setVisible(true);

    }

    private void aggiornaPassword (){
        dipendenteDAO = new DipendenteDAOImpl();
        idUtenteLog = SessionManager.getInstance().getCurrentUser().getId();
        String nuovapassword = view.getTxtPassword().getText();

        try {
            if (dipendenteDAO.updatePassword(idUtenteLog, nuovapassword)) {
                JOptionPane.showMessageDialog(view, "Password Aggiornata: ", "Aggiornamento password", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(view, "Errore durante l'aggiornamento della password: ", "Errore", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }



}
