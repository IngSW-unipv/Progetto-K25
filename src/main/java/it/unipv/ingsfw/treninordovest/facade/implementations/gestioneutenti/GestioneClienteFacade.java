//package it.unipv.ingsfw.treninordovest.facade.implementations.gestioneutenti;
//
//import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;
//import it.unipv.ingsfw.treninordovest.utils.metodipagamento.wallet.EUWallet;
//
//public class GestioneClienteFacade {
//
//
//
//}
//
//
//@Override
//public boolean aggiornaPassword(String password) {
//    String idUtenteLog = SessionManager.getInstance().getCurrentUser().getId();
//    try {
//        System.out.println("Aggiornamento password");
//        return clienteDAO.updatePassword(idUtenteLog, password);
//
//    } catch (Exception e) {
//        throw new RuntimeException(e);
//    }
//
//}
//
//
//
//    public Cliente mostraDati() {
//        String idUtenteLog = SessionManager.getInstance().getCurrentUser().getId();
//        try {
//            System.out.println("Mostrazione dati utente");
//            return clienteDAO.get(idUtenteLog);
//        }
//        catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//    }
//
//
//public void caricaDenaro(double importo){
//    String idUtenteLog = SessionManager.getInstance().getCurrentUser().getId();
//    EUWallet portafoglio = new EUWallet();
//
//    if (portafoglio.deposita(importo)){
//        try {
//            System.out.println("Carico denaro");
//            clienteDAO.updateBilancio(idUtenteLog,importo);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//}
