package it.unipv.ingsfw.treninordovest.model.varie;

import java.util.Random;

public class GeneraID {
    private final String prefisso;

    public GeneraID(String prefisso) {
        this.prefisso = prefisso;
    }

    public String getID() {
        Random random = new Random();
        int numeroCasuale = 10000 + random.nextInt(90000);

        return prefisso +numeroCasuale;
    }





}
