import java.math.BigDecimal;
import java.time.LocalDate;

public class Dipendente extends Utente {
    private int idDipendente;
    private int idTreno;       // Può essere un riferimento all'oggetto Treno se necessario
    private BigDecimal stipendio;
    private String ruolo;

    // Costruttore vuoto
    public Dipendente() {
        super();
    }

    // Costruttore completo
    public Dipendente(int id, String userPassword, String nome, String cognome, String luogo,
                      LocalDate dataNascita, char sesso, String cellulare, String indirizzo,
                      int idDipendente, int idTreno, BigDecimal stipendio, String ruolo) {
        super(id, userPassword, nome, cognome, luogo, dataNascita, sesso, cellulare, indirizzo);
        this.idDipendente = idDipendente;
        this.idTreno = idTreno;
        this.stipendio = stipendio;
        this.ruolo = ruolo;
    }

    // Getters e Setters
    public int getIdDipendente() {
        return idDipendente;
    }
    public void setIdDipendente(int idDipendente) {
        this.idDipendente = idDipendente;
    }
    public int getIdTreno() {
        return idTreno;
    }
    public void setIdTreno(int idTreno) {
        this.idTreno = idTreno;
    }
    public BigDecimal getStipendio() {
        return stipendio;
    }
    public void setStipendio(BigDecimal stipendio) {
        this.stipendio = stipendio;
    }
    public String getRuolo() {
        return ruolo;
    }
    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    // Metodi specifici per il Dipendente
    public void controllaBiglietto() {
        // Logica per il controllo dei biglietti
        System.out.println("Il dipendente " + getNome() + " sta controllando un biglietto.");
    }

    public void gestisciTreno() {
        // Logica per la gestione del treno
        System.out.println("Il dipendente " + getNome() + " sta gestendo il treno assegnato.");
    }
}
