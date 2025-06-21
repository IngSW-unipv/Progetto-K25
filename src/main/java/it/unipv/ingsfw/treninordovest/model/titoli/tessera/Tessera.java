package it.unipv.ingsfw.treninordovest.model.titoli.tessera;

import java.time.LocalDate;
import java.util.UUID;

public class Tessera {
    //Attributi
    private UUID idTessera;
    private LocalDate emissione;
    private LocalDate Scadenza;

    //Costruttore vuoto
    public Tessera() {}

    //Costruttore completo
    public Tessera(UUID idTessera, LocalDate emissione, LocalDate scadenza) {
        this.idTessera = idTessera;
        this.emissione = emissione;
        Scadenza = scadenza;
    }

    public Tessera(UUID idTessera) {
        this.idTessera =idTessera;
        this.emissione = LocalDate.now().minusDays(5);
        this.Scadenza = LocalDate.now();
    }


    //Getters Setters
    public String getIdTessera() {
        return idTessera.toString();
    }

    public LocalDate getEmissione() {
        return emissione;
    }

    public LocalDate getScadenza() {
        return Scadenza;
    }
}
