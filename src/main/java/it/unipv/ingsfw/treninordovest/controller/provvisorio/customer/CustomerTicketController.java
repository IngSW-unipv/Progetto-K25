package it.unipv.ingsfw.treninordovest.controller.provvisorio.customer;

//public class CustomerTicketController {
//
//    private TratteTablePanel tratteTablePanel;
//    private JCustomerMainFrame customerMainFrame;
//    private TicketPurchasePanel ticketPurchasePanel;
//    private TrattaDAOImpl trattaDAO;
//    private BigliettoDAOImpl bigliettoDAO;
//    private GeneraID generaID;
//    private Cliente clienteLoggato;
//
//    public CustomerTicketController(JCustomerMainFrame frame, TratteTablePanel tratteTablePanel,TicketPurchasePanel ticketPurchasePanel) {
//        this.customerMainFrame = frame;
//        this.tratteTablePanel = tratteTablePanel;
//        this.ticketPurchasePanel = ticketPurchasePanel;
//        init();
//
//    }
//
//
//    private void init() {
//        ticketPurchasePanel.getButtonAcquista().addActionListener(e -> {acquistoBiglietto();});
//    }
//
//    public List<Tratta> getTratte() {
//        trattaDAO = new TrattaDAOImpl();
//        List<Tratta> tratte;
//        try {
//           tratte = trattaDAO.getAll();
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//            throw new RuntimeException(e);
//        }
//        return tratte;
//    }
//
//    private void acquistoBiglietto ()  {
//
//        PagamentoDAOImpl pagamentoDAO = new PagamentoDAOImpl();
//        BigliettoDAOImpl bigliettoDAO = new BigliettoDAOImpl();
//        ViaggioDAOImpl viaggioDAO = new ViaggioDAOImpl();
//        TrattaFermataDAOImpl trattaDAO = new TrattaFermataDAOImpl();
//
//        Pagamento pagamento = creaPagamento(2);
//        Biglietto biglietto = creaBiglietto(pagamento.getIdPagamento());
//
//
//        String idTratta = ticketPurchasePanel.getTextFieldTratta().getText();
//        TrattaFermata stazionePartenza ;
//        TrattaFermata stazioneArrivo ;
//
//        stazionePartenza=trattaDAO.getPartenza(idTratta);
//        stazioneArrivo=trattaDAO.getArrivo(idTratta);
//
//        String idPart= stazionePartenza.getIdFermata();
//        String idArr = stazioneArrivo.getIdFermata();
//        String idBiglietto = biglietto.getId();
//
//        System.out.println("Debug:"+"IDBIGLIETTO :  "+idBiglietto+"  IDARR: "+idArr+" IDPART: "+idPart+"    IDTRATTA:"+idTratta);
//
//        Viaggio viaggio = creaViaggio(idBiglietto,idPart,idArr,idTratta);
//
//        double totaleScalato= clienteLoggato.getBilancio()-pagamento.getTotale();
//
//        if (clienteLoggato.getBilancio()<=0){
//            JOptionPane.showMessageDialog(ticketPurchasePanel,"Credito Insufficiente" ,"Errore",JOptionPane.ERROR_MESSAGE);
//            return;
//        }
//        else  JOptionPane.showMessageDialog(ticketPurchasePanel,"Biglietto acquistato:   " +totaleScalato+ "    Codice Titolo:  "+ idBiglietto);
//
//
//
//        ClienteDAOImpl clienteDAO = new ClienteDAOImpl();
//        clienteDAO.updateBilancio(clienteLoggato.getId(),totaleScalato);
//        clienteLoggato.setBilancio(totaleScalato);
//
//        //Inserimento nel DB
//        pagamentoDAO.insert(pagamento);
//        bigliettoDAO.insert(biglietto);
//        viaggioDAO.insert(viaggio);
//
//    }
//
//    private Biglietto creaBiglietto(String idPagamento){
//
//        Biglietto bigliettoCreato;
//        generaID = new GeneraID("BG");
//        double prezzoBiglietto = 2;
//        //Pagamento pagamento = creaPagamento(prezzoBiglietto);
//        LocalDate dataEmissioneValidazione = LocalDate.now();
//        LocalDate dataRitorno;
//        Boolean validazione =true;
//        Boolean checkRitorno = ticketPurchasePanel.getCheckBoxRitorno().isSelected();
//        Boolean ritorno=false;
//
//        if (checkRitorno){
//            dataRitorno= ticketPurchasePanel.getDataRitorno().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//        }else {
//            dataRitorno=null;
//        }
//
//        bigliettoCreato = new Biglietto(generaID.getID(),idPagamento,dataEmissioneValidazione,prezzoBiglietto,checkRitorno,validazione,dataRitorno,dataEmissioneValidazione);
//
//    return bigliettoCreato;
//    }
//
//    private Viaggio creaViaggio (String idBiglietto,String idPartenza,String idArrivo,String idTratta)  {
//        generaID = new GeneraID("VG");
//        LocalDate dataViaggio = LocalDate.now();
//        Viaggio viaggioCreato;
//        LocalTime oraPartenza;
//        LocalTime oraArrivo;
//
//        TrattaFermataDAOImpl trattaFermataDAO = new TrattaFermataDAOImpl();
//
//        TrattaFermata trattaPartenzaViaggio = trattaFermataDAO.get(idTratta,idPartenza);
//        TrattaFermata trattaArrivoViaggio = trattaFermataDAO.get(idTratta,idArrivo);
//
//        oraArrivo = trattaArrivoViaggio.getOraArrivo();
//        oraPartenza = trattaPartenzaViaggio.getOraPartenza();
//        String idViaggio=generaID.getID();
//
//
//
//
//        viaggioCreato = new Viaggio(idViaggio,idTratta,idPartenza,idArrivo,dataViaggio,oraPartenza,oraArrivo,idBiglietto);
//
//
//        return viaggioCreato;
//    }
//
//   private Pagamento creaPagamento(double totale) {
//        //Dichiarazione classi
//        Pagamento pagamento;
//        String tipoPagamento;
//        LocalDate dataPagamento;
//        //Generazione dell'ID del Pagamento
//        GeneraID idGen = new GeneraID("PG");
//        String IDPagamento = idGen.getID();
//
//        //Acquisizione del tipo di pagamento
//        tipoPagamento = "Digitale";
//        dataPagamento = LocalDate.now();
//
//        //Acquisizione del utente loggato
//        clienteLoggato = (Cliente) SessionManager.getInstance().getCurrentUser();
//        String idCliente = clienteLoggato.getId();
//
//        pagamento = new Pagamento(IDPagamento,idCliente,totale,tipoPagamento,dataPagamento);
//
//        return pagamento;
//
//    }
//
//
//
//}

