package it.unipv.ingsfw.treninordovest.controller;


import it.unipv.ingsfw.treninordovest.dao.implementations.utenti.ClienteDAOImpl;
import it.unipv.ingsfw.treninordovest.model.utenti.Cliente;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;
import it.unipv.ingsfw.treninordovest.view.frames.miscellanous.JCustomerMainFrame;
import it.unipv.ingsfw.treninordovest.view.panels.miscellanous.CustomerProfilePanel;
import it.unipv.ingsfw.treninordovest.view.panels.users.CustomerRegistrationPanel;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;

public class CustomerProfileController {
    private CustomerProfilePanel view;
    private JCustomerMainFrame mainFrame;
    private ClienteDAOImpl clienteDAO;

    public CustomerProfileController(CustomerProfilePanel view, JCustomerMainFrame mainFrame) {
        this.view = view;
        this.mainFrame = mainFrame;
        initController();
    }

    private void initController() {
        // Carica i dati dell'utente dalla sessione

        view.getBtnAggiornaPassword().addActionListener(e -> aggiornaPassword());

    }

    /*
    private void aggiornaProfilo() {
        String nome = view.getTxtNome().getText();
        String cognome = view.getTxtCognome().getText();
        String email = view.getTxtEmail().getText();

        Cliente currentUser = SessionManager.getInstance().getCurrentUser();
        if (currentUser == null) {
            JOptionPane.showMessageDialog(view, "Nessun utente loggato!", "Errore", JOptionPane.ERROR_MESSAGE);
            return;
        }
        // Aggiorna il modello
        currentUser.setNome(nome);
        currentUser.setCognome(cognome);
        currentUser.setEmail(email);

        try {
            boolean updated = utenteDAO.updateUtente(currentUser);
            if (updated) {
                JOptionPane.showMessageDialog(view, "Profilo aggiornato con successo!");
            } else {
                JOptionPane.showMessageDialog(view, "Aggiornamento fallito!", "Errore", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(view, "Errore nel database: " + ex.getMessage(), "Errore", JOptionPane.ERROR_MESSAGE);
        }
    }*/

    private void aggiornaPassword (){
        clienteDAO = new ClienteDAOImpl();
        String idUtenteLog = SessionManager.getInstance().getCurrentUser().getId();
        String nuovapassword = view.getTxtPassword().getText();

        if (clienteDAO.updatePassword(idUtenteLog, nuovapassword)) {

        }







    }
}

