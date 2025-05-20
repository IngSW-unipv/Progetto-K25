package it.unipv.ingsfw.treninordovest.facade.implementations;

import it.unipv.ingsfw.treninordovest.dao.implementations.utenti.ClienteDAOImpl;
import it.unipv.ingsfw.treninordovest.facade.interfaces.IUserManagementFacade;
import it.unipv.ingsfw.treninordovest.model.utenti.Cliente;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;
import it.unipv.ingsfw.treninordovest.model.varie.wallet.EUWallet;


public class CustomerManagementFacade implements IUserManagementFacade<Cliente> {

    private static CustomerManagementFacade instance;

    public static CustomerManagementFacade getInstance() {
        if (instance == null) {
            instance = new CustomerManagementFacade();
        }
        return instance;
    }


    @Override
    public Cliente mostraDati() {
        ClienteDAOImpl clienteDAO = new ClienteDAOImpl();
        String idUtenteLog = SessionManager.getInstance().getCurrentUser().getId();
        try {
            System.out.println("Mostrazione dati utente");
            return clienteDAO.get(idUtenteLog);
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public boolean aggiornaPassword(String password) {
       ClienteDAOImpl clienteDAO = new ClienteDAOImpl();
       String idUtenteLog = SessionManager.getInstance().getCurrentUser().getId();
        try {
            System.out.println("Aggiornamento password");
            return clienteDAO.updatePassword(idUtenteLog, password);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public boolean caricaDenaro(double importo){

        ClienteDAOImpl clienteDAO = new ClienteDAOImpl();
        String idUtenteLog = SessionManager.getInstance().getCurrentUser().getId();
        EUWallet portafoglio = new EUWallet();

       if (portafoglio.deposita(importo)){
           try {
               System.out.println("Carico denaro");
               clienteDAO.updateBilancio(idUtenteLog,importo);
               return true;
           } catch (Exception e) {
               throw new RuntimeException(e);
           }
       }

        return false;
    }
}
