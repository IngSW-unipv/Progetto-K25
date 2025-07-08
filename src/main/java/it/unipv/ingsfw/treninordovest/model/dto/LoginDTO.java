package it.unipv.ingsfw.treninordovest.model.dto;

public class LoginDTO {
    private String id;
    private String password;
    private String tipoUtente;

    public LoginDTO(String id, String password, String tipoUtente) {
        this.id = id;
        this.password = password;
        this.tipoUtente = tipoUtente;
    }

    public String getId() {
        return id;
    }

    public String getTipoUtente() {
        return tipoUtente;
    }

    public String getPassword() {
        return password;
    }
}
