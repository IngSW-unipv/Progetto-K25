package it.unipv.ingsfw.treninordovest.model.service;


import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.Biglietto;
import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.BigliettoDAOImpl;
import it.unipv.ingsfw.treninordovest.model.titoli.rimborso.Rimborso;
import it.unipv.ingsfw.treninordovest.model.titoli.rimborso.RimborsoDAOImpl;
import it.unipv.ingsfw.treninordovest.model.utenti.cliente.Cliente;
import it.unipv.ingsfw.treninordovest.model.varie.SessionManager;

public class RimborsoService {

    private BigliettoDAOImpl bigliettoDao;
    private RimborsoDAOImpl rimborsoDao;

    public RimborsoService() {
        rimborsoDao = new RimborsoDAOImpl();
        bigliettoDao = new BigliettoDAOImpl();
    }

    public boolean effettuaRimborso(String idBiglietto) {
        Rimborso rimborso;
        Biglietto bigliettoDB;
        Cliente clienteLoggato = (Cliente) SessionManager.getInstance().getCurrentUser();


        if (clienteLoggato == null) {
            System.out.println("Utente non loggato");
            return false;
        }

        if(clienteLoggato!=null) {

                Biglietto biglietto = new Biglietto(idBiglietto);

                bigliettoDB = bigliettoDao.get(biglietto);
                Cliente richiedente = (Cliente) SessionManager.getInstance().getCurrentUser();

                if (bigliettoDB != null && !rimborsoDao.exists(new Rimborso(richiedente, bigliettoDB))) {
                    System.out.println("Biglietto trovato");
                    rimborso = new Rimborso(richiedente, bigliettoDB);
                    rimborsoDao.insert(rimborso);

                    return true;
                }
                else
                    System.out.println("Rimborso già effettuato o biglietto non trovato");

        }



        return false;
    }



}
