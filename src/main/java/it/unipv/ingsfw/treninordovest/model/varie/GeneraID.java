package it.unipv.ingsfw.treninordovest.model.varie;

import java.util.Random;

public class GeneraID {
    private String prefisso;

    public GeneraID(String prefisso) {
        this.prefisso = prefisso;
    }

    public String getID() {
        String id = prefisso;
        Random random = new Random();
        int numeroCasuale = 10000 + random.nextInt(90000);

        return id+numeroCasuale;
    }





}
