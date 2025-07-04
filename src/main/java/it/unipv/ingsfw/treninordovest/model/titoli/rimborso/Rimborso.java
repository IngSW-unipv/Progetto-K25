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
    public Rimborso(Cliente richiedente,Biglietto biglietto) {
       this.idRimborso =UUID.randomUUID() ;
       this.dataRimborso = LocalDate.now();
       this.totale= totaleMenoTasse(biglietto.getPrezzo());
       this.cliente = richiedente;
       this.biglietto=biglietto;
    }

    //Estrazione dati dal DB
    public Rimborso(String uuid, LocalDate dataRimborso, double totale,Biglietto biglietto,Cliente cliente) {
        this.idRimborso = UUID.fromString(uuid) ;
        this.dataRimborso = dataRimborso;
        this.totale = totale;
        this.cliente = cliente;
        this.biglietto = biglietto;
    }

    //Getters e Setters
    public UUID getIdRimborso() {
        return idRimborso;
    }

    public LocalDate getDataRimborso() {
        return dataRimborso;
    }

    public double getTotale() {
        return totale;
    }

    public Biglietto getBiglietto() {
        return biglietto;
    }
    public Cliente getCliente() {
        return cliente;
    }


    private double totaleMenoTasse(double importo){
        double tasse = 0.22;
       return importo-importo*tasse;
    }

}
