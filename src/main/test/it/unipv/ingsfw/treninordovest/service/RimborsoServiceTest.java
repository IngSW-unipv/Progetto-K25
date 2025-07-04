package it.unipv.ingsfw.treninordovest.service;

import it.unipv.ingsfw.treninordovest.model.service.RimborsoService;
import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.Biglietto;
import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.BigliettoDAOImpl;
import it.unipv.ingsfw.treninordovest.model.titoli.rimborso.Rimborso;
import it.unipv.ingsfw.treninordovest.model.titoli.rimborso.RimborsoDAOImpl;
import it.unipv.ingsfw.treninordovest.model.utenti.cliente.Cliente;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;
import org.junit.jupiter.api.Test;

public class RimborsoServiceTest {

    @Test
    void creaRimborsoTest() {

        try {
            RimborsoDAOImpl rimborsoDAO = new RimborsoDAOImpl();
            Rimborso rimborso ;

            BigliettoDAOImpl bigliettoDAO = new BigliettoDAOImpl();
            String idBiglietto= "09387ec3-fed9-4ffa-923f-5a55a2e1d372";
            Biglietto biglietto = new Biglietto(idBiglietto);

            Biglietto bigliettoDB = bigliettoDAO.get(biglietto);

            SessionManager.getInstance().setCurrentUser(new Cliente("cd9714b9-d9a2-4b8f-b062-9a8056c25f0e"));
            Cliente richiedente = (Cliente) SessionManager.getInstance().getCurrentUser();
            //view.getTextIDBiglietto().getText();



            if (bigliettoDB != null) {
                System.out.println("Biglietto trovato");
                // JOptionPane.showMessageDialog(view, "ID Biglietto non valido riprovare", "Errore", JOptionPane.ERROR_MESSAGE);
                rimborso =new Rimborso(richiedente,bigliettoDB);

                rimborsoDAO.insert(rimborso);
            }


        }catch (Exception e) {
            e.printStackTrace();

        }








    }

    @Test
    void testMethod() {

        String idBiglietto= "9ff7c796-2bb5-4eac-ba90-1b98482880c6";
        SessionManager.getInstance().setCurrentUser(new Cliente("cd9714b9-d9a2-4b8f-b062-9a8056c25f0e"));

        RimborsoService rimborsoService = new RimborsoService();

        if(rimborsoService.effettuaRimborso(idBiglietto)){
            System.out.println("Rimborso effettuato");

        }



    }
}
