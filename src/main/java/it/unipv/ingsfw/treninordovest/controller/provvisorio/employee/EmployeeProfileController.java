package it.unipv.ingsfw.treninordovest.controller.provvisorio.employee;

//public class EmployeeProfileController {
//
//    private EmployeeProfilePanel view;
//    private JEmployeeMainFrame mainFrame;
//    private DipendenteDAOImpl dipendenteDAO;
//    private javax.swing.JOptionPane JOptionPane;
//    private String idUtenteLog;
//
//
//    public EmployeeProfileController(EmployeeProfilePanel view, JEmployeeMainFrame mainFrame) {
//        this.view = view;
//        this.mainFrame= mainFrame;
//        init();
//    }
//
//
//    private void init() {
//        // Carica i dati dell'utente dalla sessione
//       view.getBtnAggiornaPassword().addActionListener(e -> aggiornaPassword());
//        view.getBtnAggionaProfilo().addActionListener(e -> {mostraDatiProfilo();});
//        view.getBtnEsci().addActionListener(e -> { esci();});
//    }
//
//
//    private void mostraDatiProfilo() {
//        dipendenteDAO = new DipendenteDAOImpl();
//
//        idUtenteLog = SessionManager.getInstance().getCurrentUser().getId();
//       Dipendente dipendente = dipendenteDAO.get(idUtenteLog);
//
//        view.setTxtNome(dipendente.getNome());
//        view.setTxtCognome(dipendente.getCognome());
//        view.setTxtSesso(dipendente.getSesso());
//        view.setTxtLuogoNascita(dipendente.getLuogoNascita());
//        view.setTxtDataNascita(dipendente.getDataNascita().toString());
//        view.setTxtCellulare(dipendente.getCellulare());
//        view.setTxtID(dipendente.getId());
//        view.setTxtIndirizzo(dipendente.getIndirizzo());
//        double stipendio = dipendente.getStipendio();
//        String stipendioString = String.format("%.2f", stipendio);
//        view.setTxtStipendio(stipendioString);
//        view.setTxtRuolo(dipendente.getRuolo());
//
//
//    }
//
//    private void esci(){
//        SessionManager.getInstance().setCurrentUser(null);
//        this.mainFrame.dispose();
//        this.mainFrame.setVisible(false);
//        JMainMenuFrame mainMenuFrame = new JMainMenuFrame();
//        mainMenuFrame.setVisible(true);
//
//    }
//
//    private void aggiornaPassword (){
//        dipendenteDAO = new DipendenteDAOImpl();
//        idUtenteLog = SessionManager.getInstance().getCurrentUser().getId();
//        String nuovapassword = view.getTxtPassword().getText();
//
//        try {
//            if (dipendenteDAO.updatePassword(idUtenteLog, nuovapassword)) {
//                showMessageDialog(view, "Password Aggiornata: ", "Aggiornamento password", INFORMATION_MESSAGE);
//            }
//            else {
//                showMessageDialog(view, "Errore durante l'aggiornamento della password: ", "Errore",ERROR_MESSAGE);
//            }
//
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//


//}
