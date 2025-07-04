package it.unipv.ingsfw.treninordovest.model.service;

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

    public boolean cercaViaggio(String idViaggio) {

        Viaggio viaggio;
        viaggio = viaggioDAO.get(new Viaggio(idViaggio));

        return false;

    }






}
