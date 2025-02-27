package it.unipv.ingsfw.treninordovest.controller.users;


import it.unipv.ingsfw.treninordovest.dao.implementations.utenti.ClienteDAOImpl;
import it.unipv.ingsfw.treninordovest.model.utenti.Cliente;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JCustomerMainFrame;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JMainMenuFrame;
import it.unipv.ingsfw.treninordovest.view.panels.users.CustomerProfilePanel;

import java.sql.SQLException;

public class CustomerProfileController {
    private CustomerProfilePanel view;
    private JCustomerMainFrame mainFrame;
    private ClienteDAOImpl clienteDAO;
    private javax.swing.JOptionPane JOptionPane;
    private String idUtenteLog;

    public CustomerProfileController(CustomerProfilePanel view, JCustomerMainFrame mainFrame) {
        this.view = view;
        this.mainFrame = mainFrame;
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

        view.getBtnConfermaDenaro().addActionListener(e -> {
            try {
                caricaDenaro();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });


    }



    private void aggiornaPassword (){
        clienteDAO = new ClienteDAOImpl();
        idUtenteLog = SessionManager.getInstance().getCurrentUser().getId();
        String nuovapassword = view.getTxtPassword().getText();

        try {
            if (clienteDAO.updatePassword(idUtenteLog, nuovapassword)) {
                JOptionPane.showMessageDialog(view, "Password Aggiornata: ", "Aggiornamento password", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JOptionPane.showMessageDialog(view, "Errore durante l'aggiornamento della password: ", "Errore", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    private void esci(){
        SessionManager.getInstance().setCurrentUser(null);
        this.mainFrame.dispose();
        this.mainFrame.setVisible(false);
        JMainMenuFrame mainMenuFrame = new JMainMenuFrame();
        mainMenuFrame.setVisible(true);

    }

    private void mostraDatiProfilo() throws SQLException {
        clienteDAO = new ClienteDAOImpl();

        idUtenteLog = SessionManager.getInstance().getCurrentUser().getId();
        Cliente clienteEstratto = clienteDAO.get(idUtenteLog);

        view.setTxtNome(clienteEstratto.getNome());
        view.setTxtCognome(clienteEstratto.getCognome());
        view.setTxtSesso(clienteEstratto.getSesso());
        view.setTxtLuogoNascita(clienteEstratto.getLuogoNascita());
        view.setTxtDataNascita(clienteEstratto.getDataNascita().toString());
        view.setTxtEmail(clienteEstratto.getEmail());
       view.setTxtCellulare(clienteEstratto.getCellulare());
       view.setTxtID(clienteEstratto.getId());
       view.setTxtIndirizzo(clienteEstratto.getIndirizzo());
       double bilancio = clienteEstratto.getBilancio();
       String bilancioString = String.format("%.2f", bilancio);
       view.setTxtBilancio(bilancioString);


    }

    private void caricaDenaro () throws SQLException {
        clienteDAO = new ClienteDAOImpl();
        idUtenteLog = SessionManager.getInstance().getCurrentUser().getId();
        Cliente clienteAttuale = clienteDAO.get(idUtenteLog);
        double nuovoBilancio;

        try {
            if (view.getTxtDenaro() == 0.0 || view.getTxtDenaro() < 0.0) {
                JOptionPane.showMessageDialog(view, "Accredito fallito ", "Errore", JOptionPane.ERROR_MESSAGE);
                return;
            }

            nuovoBilancio = clienteAttuale.getBilancio() +  view.getTxtDenaro();

            if (clienteDAO.updateBilancio(idUtenteLog,nuovoBilancio)){
                JOptionPane.showMessageDialog(view, "Dennaro accreditato: "+ nuovoBilancio, "Aggiornamento bilancio", JOptionPane.INFORMATION_MESSAGE);
                return;
            }else
                JOptionPane.showMessageDialog(view, "Accredito fallito ", "Errore", JOptionPane.ERROR_MESSAGE);

        }catch (Exception e) {
           System.out.println(e.getMessage());
            throw new RuntimeException(e);

        }





    }

}

