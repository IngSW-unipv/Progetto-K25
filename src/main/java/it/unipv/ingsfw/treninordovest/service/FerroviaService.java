package it.unipv.ingsfw.treninordovest.service;

import it.unipv.ingsfw.treninordovest.model.ferrovia.fermata.Fermata;
import it.unipv.ingsfw.treninordovest.model.ferrovia.fermata.FermataDAOImpl;
import it.unipv.ingsfw.treninordovest.model.ferrovia.fermata.tratta.TrattaFermataDAOImpl;

public class FerroviaService {

    private TrattaFermataDAOImpl trattaFermataDAO;
    private FermataDAOImpl fermataDAO;

    public FerroviaService() {
        trattaFermataDAO = new TrattaFermataDAOImpl();
        fermataDAO = new FermataDAOImpl();
    }

    public Fermata getFermata(){
        Fermata fermata = new Fermata();

        return fermata;
    }



}
