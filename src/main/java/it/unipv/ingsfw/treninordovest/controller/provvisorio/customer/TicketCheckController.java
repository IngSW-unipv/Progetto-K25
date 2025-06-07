package it.unipv.ingsfw.treninordovest.controller.provvisorio.customer;


//
//public class TicketCheckController {
//    private JEmployeeMainFrame frame;
//    private TravelDocCheckPanel view;
//
//
//    public TicketCheckController(JEmployeeMainFrame frame, TravelDocCheckPanel view) {
//        this.frame = frame;
//        this.view = view;
//        init();
//
//    }
//
//
//    private void init() {
//        view.getVerificaButton().addActionListener(e -> {verficaTitolo();});
//
//    }
//
//    private void verficaTitolo () {
//        BigliettoDAOImpl bigliettoDAO = new BigliettoDAOImpl();
//        AbbonamentoDAOimpl abbonamentoDAOimpl  = new AbbonamentoDAOimpl();
//
//        if (bigliettoDAO.get(view.getTextFieldIdTitolo().getText())!=null || abbonamentoDAOimpl.get(view.getTextFieldIdTitolo().getText())!=null) {
//            JOptionPane.showMessageDialog(view,"Titolo di viaggio valido");
//
//        }else{
//            JOptionPane.showMessageDialog(view, "Titolo di viaggio inesistente", "Errore", JOptionPane.ERROR_MESSAGE);
//        }
//
//
//    }
//
//}
