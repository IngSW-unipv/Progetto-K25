package it.unipv.ingsfw.treninordovest.model.titoli.biglietto;

import it.unipv.ingsfw.treninordovest.model.ferrovia.viaggio.Viaggio;
import it.unipv.ingsfw.treninordovest.model.titoli.pagamento.Pagamento;
import it.unipv.ingsfw.treninordovest.model.titoli.titoloviaggio.TitoloViaggio;

import java.time.LocalDate;
import java.util.UUID;


public class Biglietto extends TitoloViaggio {
    //Attributi
    private boolean validato;
    private LocalDate dataValidazione;
    private String tipoBiglietto;
    private Viaggio viaggio;

    //Costruttore vuoto
    public Biglietto() {}

    public Biglietto (String id){
        setId(id);
    }



    //Costruttore completo


    public Biglietto(UUID id,Pagamento pagamento, LocalDate emissione,double prezzo, boolean validato, LocalDate dataValidazione, Viaggio viaggio, String tipoBiglietto) {
        super(id, emissione, prezzo);
        setPagamento(pagamento);
        this.dataValidazione = dataValidazione;
        this.tipoBiglietto = tipoBiglietto;
        this.viaggio = viaggio;
        this.validato = validato;
    }

    public Biglietto(UUID uuid, LocalDate dataEmissione, double v, boolean validazione, String tipoBiglietto) {
        super(uuid, dataEmissione, v);
      this.validato = validazione;
        this.tipoBiglietto = tipoBiglietto;
        this.viaggio = null;
        this.dataValidazione = null;
    }

    //Getters e setters
    public boolean isValidato() {
        return validato;
    }

    public void setValidato(boolean validato) {
        this.validato = validato;
    }

    public LocalDate getDataValidazione() {
        return dataValidazione;
    }

    public void setDataValidazione(LocalDate dataValidazione) {
        this.dataValidazione = dataValidazione;
    }

    public void setViaggio(Viaggio viaggio) {
        this.viaggio = viaggio;
    }

    public void setTipoBiglietto(String tipoBiglietto) {
        this.tipoBiglietto = tipoBiglietto;
    }

    public Viaggio getViaggio() {
        return viaggio;
    }

    public String getTipoBiglietto() {
        return tipoBiglietto;
    }
}
