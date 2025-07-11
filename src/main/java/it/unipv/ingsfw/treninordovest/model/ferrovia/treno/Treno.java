package it.unipv.ingsfw.treninordovest.model.ferrovia.treno;

import java.util.List;
import java.util.Random;

public class Treno {
    private String idTreno;
    private String modello;
    private int kw;
    private int numPosti;

    //Costruttori

    public Treno (){}

    public Treno(String idTreno, String modello, int kw, int numPosti) {
        this.idTreno = idTreno;
        this.modello = modello;
        this.kw = kw;
        this.numPosti = numPosti;
    }

    public Treno(String idTreno) {
        this.idTreno = idTreno;
    }

    public String getIdTreno() {
        return idTreno;
    }

    public void setIdTreno(String idTreno) {
        this.idTreno = idTreno;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public int getKw() {
        return kw;
    }

    public void setKw(int kw) {
        this.kw = kw;
    }

    public int getNumPosti() {
        return numPosti;
    }

    public void setNumPosti(int numPosti) {
        this.numPosti = numPosti;
    }

    public static String getRandomTreno() {
        try {
            List<Treno> treni = new TrenoDAOImpl().getAll();
            if (treni.isEmpty()) {
                System.out.println("Treno non treno");
                return "";
            }

            Random random = new Random();
            int indiceCasuale = random.nextInt(treni.size());
            return treni.get(indiceCasuale).getIdTreno();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "";
        }
    }

}
