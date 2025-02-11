public abstract class Utente {

    /*Classe astratta padre per le utenze*/
    //Attributi
    private int id;
    private String userPassword;
    private String nome;
    private String cognome;
    private String luogo;
    private LocalDate dataNascita;
    private char sesso;
    private String cellulare;
    private String indirizzo;


    // Costruttore vuoto
    public Utente() {}

    // Costruttore completo
    public Utente(int id, String userPassword, String nome, String cognome, String luogo,
                  LocalDate dataNascita, char sesso, String cellulare, String indirizzo) {
        this.id = id;
        this.userPassword = userPassword;
        this.nome = nome;
        this.cognome = cognome;
        this.luogo = luogo;
        this.dataNascita = dataNascita;
        this.sesso = sesso;
        this.cellulare = cellulare;
        this.indirizzo = indirizzo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getLuogo() {
        return luogo;
    }

    public void setLuogo(String luogo) {
        this.luogo = luogo;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public char getSesso() {
        return sesso;
    }

    public void setSesso(char sesso) {
        this.sesso = sesso;
    }

    public String getCellulare() {
        return cellulare;
    }

    public void setCellulare(String cellulare) {
        this.cellulare = cellulare;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    //Gestione degli accessi utente
    public void login() {
        // Logica di login
        System.out.println("Utente " + nome + " " + cognome + " ha effettuato il login.");
    }

    public void logout() {
        // Logica di logout
        System.out.println("Utente " + nome + " " + cognome + " ha effettuato il logout.");
    }

    public void updateProfile() {
        // Logica per aggiorare il profilo
        System.out.println("Profilo utente aggiornato.");
    }



}