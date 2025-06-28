package it.unipv.ingsfw.treninordovest.service;

import it.unipv.ingsfw.treninordovest.model.ferrovia.viaggio.Viaggio;
import it.unipv.ingsfw.treninordovest.model.ferrovia.viaggio.ViaggioDAOImpl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class ViaggioService {

    private ViaggioDAOImpl viaggioDAO;

    public ViaggioService() {
        this.viaggioDAO = new ViaggioDAOImpl();
    }

    public boolean cercaViaggio(LocalDate dataViaggio, LocalTime oraPartenza,LocalTime oraArrivo,String idPartenza,String idArrivo,String idTratta) {

        Viaggio viaggio;





       // viaggio = new Viaggio(String.valueOf(UUID.randomUUID()),dataViaggio,);

        /*if(viaggioDAO.insert()){

        }*/


        return false;

    }






}
