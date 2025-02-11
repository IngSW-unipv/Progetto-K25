import java.math.BigDecimal;
import java.time.LocalDate;

public class Cliente extends Utente {
    private int idCliente;
    private BigDecimal bilancio;
    private String email;

    // Costruttore vuoto
    public Cliente() {
        super();
    }

    // Costruttore completo
    public Cliente(int id, String userPassword, String nome, String cognome, String luogo,
                   LocalDate dataNascita, char sesso, String cellulare, String indirizzo,
                   int idCliente, BigDecimal bilancio, String email) {
        super(id, userPassword, nome, cognome, luogo, dataNascita, sesso, cellulare, indirizzo);
        this.idCliente = idCliente;
        this.bilancio = bilancio;
        this.email = email;
    }

    // Getters e Setters
    public int getIdCliente() {
        return idCliente;
    }
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    public BigDecimal getBilancio() {
        return bilancio;
    }
    public void setBilancio(BigDecimal bilancio) {
        this.bilancio = bilancio;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    // Metodi specifici per il Cliente
    public void acquistaBiglietto() {
        // Logica di acquisto del biglietto
        System.out.println("Il cliente " + getNome() + " sta acquistando un biglietto.");
    }

    public void visualizzaStoricoAcquisti() {
        // Logica per visualizzare lo storico degli acquisti
        System.out.println("Visualizzazione storico acquisti per il cliente " + getNome());
    }
}
