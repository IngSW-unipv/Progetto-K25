package it.unipv.ingsfw.treninordovest.facade.implementations.gestioneutenti;

import it.unipv.ingsfw.treninordovest.dao.implementations.utenti.TesseraDAOImpl;
import it.unipv.ingsfw.treninordovest.model.utenti.Cliente;
import it.unipv.ingsfw.treninordovest.model.utenti.Tessera;
import it.unipv.ingsfw.treninordovest.model.varie.GeneraID;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class CustomerManagementFacadeTest {

   @Test
    void login() {

    }

    @Test
    void logout() {
    }

    @Test
    void acquistaTessera(){


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