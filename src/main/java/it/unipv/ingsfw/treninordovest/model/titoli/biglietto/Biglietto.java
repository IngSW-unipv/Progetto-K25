package it.unipv.ingsfw.treninordovest.model.titoli.biglietto;

import it.unipv.ingsfw.treninordovest.model.ferrovia.viaggio.Viaggio;
import it.unipv.ingsfw.treninordovest.model.titoli.pagamento.Pagamento;
import it.unipv.ingsfw.treninordovest.model.titoli.titoloviaggio.TitoloViaggio;

import java.time.LocalDate;
import java.util.UUID;


public class Biglietto extends TitoloViaggio {
    //Attributi
    private boolean validato;
    private String tipoBiglietto;
    private Viaggio viaggio;

    //Costruttore vuoto
    public Biglietto() {
    }

    public Biglietto(String id) {
        setId(id);
    }


    //Costruttore completo


    public Biglietto(UUID id, Pagamento pagamento, LocalDate emissione, double prezzo, boolean validato, Viaggio viaggio, String tipoBiglietto) {
        super(id, emissione, prezzo);
        setPagamento(pagamento);
        this.tipoBiglietto = tipoBiglietto;
        this.viaggio = viaggio;
        this.validato = validato;
    }

    public Biglietto(UUID uuid, LocalDate dataEmissione, double prezzo, boolean validazione, String tipoBiglietto) {
        super(uuid, dataEmissione, prezzo);
        this.validato = validazione;
        this.tipoBiglietto = tipoBiglietto;
    }

    public Biglietto(UUID uuid, LocalDate localDate, Double prezzo, Boolean validato, String tipo) {
        super(uuid, localDate, prezzo);
        this.validato = validato;
        this.tipoBiglietto = tipo;
    }


    //Getters e setters
    public boolean isValidato() {
        return validato;
    }

    public void setValidato(boolean validato) {
        this.validato = validato;
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

    @Override
    public boolean isValido() {
        if (this.validato) {
            // Logica per controllare se è scaduto dopo l'obliterazione
            System.out.println("CONTROLLO: Biglietto già validato.");
            return true; // Semplificato per l'esempio
        }else

           return false; // Modifica lo stato
    }


}
