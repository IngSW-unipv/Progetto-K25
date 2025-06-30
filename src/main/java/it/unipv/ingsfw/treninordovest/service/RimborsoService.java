package it.unipv.ingsfw.treninordovest.service;


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
        Biglietto biglietto;
        Cliente clienteLoggato = (Cliente) SessionManager.getInstance().getCurrentUser();

        if(clienteLoggato!=null) {

            try{
               biglietto = bigliettoDao.get(new Biglietto(idBiglietto));

               if(bigliettoDao !=null){
                   rimborso = new Rimborso(clienteLoggato.getId().toString(),idBiglietto);
                   rimborsoDao.insert(rimborso);
                   return true;
               }







            }catch (Exception e) {

                e.printStackTrace();
                return  false;
            }

        }






        return false;
    }



}
