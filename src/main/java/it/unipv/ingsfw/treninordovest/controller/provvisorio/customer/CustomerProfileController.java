//package it.unipv.ingsfw.treninordovest.controller.provvisorio.customer;
//
//
//
//public class CustomerProfileController  {
//    private CustomerProfilePanel view;
//    private JCustomerMainFrame mainFrame;
//    private JOptionPane JOptionPane;
//    private LoginFacade loginFacade;
//    private final CustomerManagementFacade customerManagementFacade ;
//
//    public CustomerProfileController(CustomerProfilePanel view, JCustomerMainFrame mainFrame) {
//        this.view = view;
//        this.mainFrame = mainFrame;
//        this.loginFacade = LoginFacade.getInstance();
//        this.customerManagementFacade = new CustomerManagementFacade();
//        init();
//
//
//    }
//
//
//    private void init() {
//
//        view.getBtnAggiornaPassword().addActionListener(e -> aggiornaPassword());
//        view.getBtnAggionaProfilo().addActionListener(e -> mostraDatiProfilo());
//        view.getBtnEsci().addActionListener(e ->  esci());
//        view.getBtnConfermaDenaro().addActionListener(e -> caricaDenaro());
//
//    }
//
//    private void aggiornaPassword() {
//        String nuovaPass = view.getTxtPassword().getText();
//
//        // Validazione della password
//        if (nuovaPass == null || nuovaPass.isEmpty()) {
//            showMessageDialog(view,
//                "La password non può essere vuota",
//                "Errore validazione",
//                ERROR_MESSAGE);
//            return;
//        }
//
//        // Verifica lunghezza minima
//        if (nuovaPass.length() < 8) {
//            showMessageDialog(view,
//                "La password deve essere di almeno 8 caratteri",
//                "Password troppo corta",
//                WARNING_MESSAGE);
//            return;
//        }
//
//        try {
//            if (customerManagementFacade.aggiornaPassword(nuovaPass)) {
//                showMessageDialog(view,
//                    "La password è stata aggiornata con successo",
//                    "Aggiornamento password",
//                    INFORMATION_MESSAGE);
//            } else {
//                showMessageDialog(view,
//                    "Non è stato possibile aggiornare la password",
//                    "Errore",
//                    ERROR_MESSAGE);
//            }
//        } catch (RuntimeException e) {
//            showMessageDialog(view,
//                "Si è verificato un errore: " + e.getMessage(),
//                "Errore",
//                ERROR_MESSAGE);
//        }
//    }
//
//    private void esci() {
//        try {
//            loginFacade.effettuaLogout();
//            mainFrame.hideFrame();
//
//        } catch (Exception e) {
//            // Gestione dell'eccezione
//            showMessageDialog(mainFrame, "Si è verificato un errore durante il logout", "Errore", ERROR_MESSAGE);
//        }
//    }
//
//    private void mostraDatiProfilo()  {
//
//        Cliente clienteEstratto = customerManagementFacade.mostraDati();
//
//        view.setTxtNome(clienteEstratto.getNome());
//        view.setTxtCognome(clienteEstratto.getCognome());
//        view.setTxtSesso(clienteEstratto.getSesso());
//        view.setTxtLuogoNascita(clienteEstratto.getLuogoNascita());
//        view.setTxtDataNascita(clienteEstratto.getDataNascita().toString());
//        view.setTxtEmail(clienteEstratto.getEmail());
//       view.setTxtCellulare(clienteEstratto.getCellulare());
//       view.setTxtID(clienteEstratto.getId());
//       view.setTxtIndirizzo(clienteEstratto.getIndirizzo());
//       double bilancio = clienteEstratto.getBilancio();
//       String bilancioString = String.format("%.2f", bilancio);
//       view.setTxtBilancio(bilancioString);
//
//
//    }
//
//    private void caricaDenaro (){
//
//        try {
//            if (view.getTxtDenaro() == 0.0 || view.getTxtDenaro() < 0.0) {
//                showMessageDialog(view, "Accredito fallito ", "Errore", ERROR_MESSAGE);
//                return;
//            }
//            if (view.getTxtDenaro() > 0.0) {
//                customerManagementFacade.caricaDenaro(view.getTxtDenaro());
//                showMessageDialog(view, "Dennaro accreditato: "+ view.getTxtDenaro(), "Aggiornamento bilancio", INFORMATION_MESSAGE);
//                return;
//            }else
//                showMessageDialog(view, "Accredito fallito ", "Errore", ERROR_MESSAGE);
//
//        }catch (Exception e) {
//           System.out.println(e.getMessage());
//            throw new RuntimeException(e);
//
//        }
//
//
//
//    }
//
//}