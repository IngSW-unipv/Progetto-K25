package it.unipv.ingsfw.treninordovest.model.titoli.titoloviaggio;

import it.unipv.ingsfw.treninordovest.model.titoli.pagamento.Pagamento;

import java.time.LocalDate;
import java.util.UUID;

public abstract class TitoloViaggio {
    private UUID id;
    private LocalDate emissione;
    private double prezzo;
    private Pagamento pagamento;

    //Costruttore vuoto
    public TitoloViaggio() {}

    public TitoloViaggio (String uuid){
        this.id = UUID.fromString(uuid);
    }

    //Costruttore completo
    public TitoloViaggio(UUID id, LocalDate emissione, double prezzo) {
        this.id = id;
        this.emissione = emissione;
        this.prezzo = prezzo;
    }

    //Getters e Setters
    public UUID getId() {
        return id;
    }

    public void setId(String id) {
        this.id = UUID.fromString(id);
    }

    public LocalDate getEmissione() {
        return emissione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public boolean isValido(){
        return emissione.isBefore(LocalDate.now()) && emissione.isAfter(LocalDate.now().minusYears(5));
    }


}
