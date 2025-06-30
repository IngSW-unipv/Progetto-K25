package it.unipv.ingsfw.treninordovest.model.titoli.rimborso;

import it.unipv.ingsfw.treninordovest.model.titoli.biglietto.Biglietto;
import it.unipv.ingsfw.treninordovest.model.utenti.cliente.Cliente;

import java.time.LocalDate;
import java.util.UUID;

public class Rimborso {

    //Attributi
    private UUID idRimborso;
    private LocalDate dataRimborso;
    private double totale;
    private Biglietto biglietto;
    private Cliente cliente;

    //Costruttori
    public Rimborso() {

    }

    //Costruttore per generazione rimborsi
    public Rimborso(String idRichiedente,String idBiglietto) {
       this.idRimborso =UUID.randomUUID() ;
       this.dataRimborso = LocalDate.now();
       this.totale= biglietto.getPrezzo();
    }

    //Estrazione dati dal DB
    public Rimborso(UUID uuid, LocalDate dataRimborso, double totale) {
        this.idRimborso = uuid;
        this.dataRimborso = dataRimborso;
        this.totale = totale;
    }

    //Getters e Setters
    public UUID getIdRimborso() {
        return idRimborso;
    }

    public void setIdRimborso(UUID idRimborso) {
        this.idRimborso = idRimborso;
    }

    public LocalDate getDataRimborso() {
        return dataRimborso;
    }

    public void setDataRimborso(LocalDate dataRimborso) {
        this.dataRimborso = dataRimborso;
    }

    public double getTotale() {
        return totale;
    }

    public void setTotale(double totale) {
        this.totale = totale;
    }


}
