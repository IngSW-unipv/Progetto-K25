package it.unipv.ingsfw.treninordovest.controller.provvisorio.customer;

//public class TicketRefundController  {
//    private JCustomerMainFrame frame;
//    private RefundPanel view;
//
//
//    public TicketRefundController(JCustomerMainFrame frame, RefundPanel view) {
//        this.frame = frame;
//        this.view = view;
//        init();
//    }
//
//
//    private void init() {
//        view.getButtonRimborso().addActionListener(e -> {creaRimborso();});
//    }
//
//
//    private void creaRimborso ()  {
//
//        BigliettoDAOImpl bigliettoDAO = new BigliettoDAOImpl();
//        String idBiglietto=view.getTextIDBiglietto().getText();
//
//        Biglietto biglietto = bigliettoDAO.get(idBiglietto);
//
//        if (biglietto == null) {
//            JOptionPane.showMessageDialog(view, "ID Biglietto non valido riprovare", "Errore", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//
//        RimborsoDAOImpl rimborsoDAO = new RimborsoDAOImpl();
//        Rimborso rimborso ;
//        String id = new GeneraID("RM").getID();
//
//        String richiedente = SessionManager.getInstance().getCurrentUser().getId();
//        double totale = 2;
//        LocalDate dataRimborso=LocalDate.now();
//
//        rimborso =new Rimborso(id,dataRimborso,totale,idBiglietto,richiedente);
//
//        rimborsoDAO.insert(rimborso);
//
//
//    }
//
//}
