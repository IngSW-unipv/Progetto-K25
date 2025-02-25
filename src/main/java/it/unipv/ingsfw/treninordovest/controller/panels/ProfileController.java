//package it.unipv.ingsfw.treninordovest.controller.panels;


/*
public class ProfileController {
    private ProfilePanel view;
    private UtenteDAO utenteDAO;

    public ProfileController(ProfilePanel view, Connection connection) {
        this.view = view;
        this.utenteDAO = new UtenteDAO(connection);
        initController();
    }

    private void initController() {
        // Carica i dati dell'utente dalla sessione
        Cliente currentUser = SessionManager.getInstance().getCurrentUser();
        if (currentUser != null) {
            view.getTxtNome().setText(currentUser.getNome());
            view.getTxtCognome().setText(currentUser.getCognome());
            view.getTxtEmail().setText(currentUser.getEmail());
        }
        // Aggiunge l'ActionListener per aggiornare il profilo
        view.getBtnAggiorna().addActionListener(e -> aggiornaProfilo());
    }

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
    }
}
*/
