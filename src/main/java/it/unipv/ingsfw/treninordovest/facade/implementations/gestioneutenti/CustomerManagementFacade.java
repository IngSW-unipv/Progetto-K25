package it.unipv.ingsfw.treninordovest.facade.implementations.gestioneutenti;

import it.unipv.ingsfw.treninordovest.dao.implementations.utenti.ClienteDAOImpl;
import it.unipv.ingsfw.treninordovest.dao.implementations.utenti.TesseraDAOImpl;
import it.unipv.ingsfw.treninordovest.facade.interfaces.IUserManagementFacade;
import it.unipv.ingsfw.treninordovest.model.utenti.Cliente;
import it.unipv.ingsfw.treninordovest.model.utenti.Tessera;
import it.unipv.ingsfw.treninordovest.model.varie.GeneraID;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;
import it.unipv.ingsfw.treninordovest.model.varie.wallet.EUWallet;

import java.time.LocalDate;


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

    public void caricaDenaro(double importo){

        ClienteDAOImpl clienteDAO = new ClienteDAOImpl();
        String idUtenteLog = SessionManager.getInstance().getCurrentUser().getId();
        EUWallet portafoglio = new EUWallet();

       if (portafoglio.deposita(importo)){
           try {
               System.out.println("Carico denaro");
               clienteDAO.updateBilancio(idUtenteLog,importo);
           } catch (Exception e) {
               throw new RuntimeException(e);
           }
       }

    }


    public void acquistaTessera(){

        TesseraDAOImpl tDAO = new TesseraDAOImpl();
        Cliente clienteLoggato = (Cliente) SessionManager.getInstance().getCurrentUser();

        if(SessionManager.getInstance().getCurrentUser() !=null){
            clienteLoggato = (Cliente) SessionManager.getInstance().getCurrentUser();
        }

        try {
            if (!tDAO.exists(clienteLoggato.getId())){

                    LocalDate dataEmissione = LocalDate.now();
                    LocalDate dataScadenza = LocalDate.now().plusYears(5);
                    //Generazione dell'ID
                    GeneraID idGen = new GeneraID("TS");
                    String idTessera = idGen.getID();

                    Tessera tessera = new Tessera(idTessera,dataEmissione,dataScadenza,clienteLoggato.getId());

                    tDAO.insert(tessera);


            }



        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }





}
