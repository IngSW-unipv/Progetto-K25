package it.unipv.ingsfw.treninordovest.model.ferrovia;

import java.time.LocalDate;
import java.time.LocalTime;

public class Viaggio {
    public Viaggio() {
    }

    private String idViaggio;
    private String IDTratta;
    private String IDPartenza;
    private String IDArrivo;
    private LocalDate DataViaggio;
    private LocalTime OraPartenza;
    private LocalTime OraArrivo;


    public Viaggio(String idViaggio, String IDTratta, String IDPartenza, String IDArrivo, LocalDate DataViaggio, LocalTime OraPartenza, LocalTime OraArrivo) {
        this.idViaggio = idViaggio;
        this.IDTratta = IDTratta;
        this.IDPartenza = IDPartenza;
        this.IDArrivo = IDArrivo;
        this.DataViaggio = DataViaggio;
        this.OraPartenza = OraPartenza;
        this.OraArrivo = OraArrivo;
    }

    public String getIdViaggio() {
        return idViaggio;
    }

    public void setIdViaggio(String idViaggio) {
        this.idViaggio = idViaggio;
    }

    public String getIDTratta() {
        return IDTratta;
    }

    public void setIDTratta(String IDTratta) {
        this.IDTratta = IDTratta;
    }

    public String getIDPartenza() {
        return IDPartenza;
    }

    public void setIDPartenza(String IDPartenza) {
        this.IDPartenza = IDPartenza;
    }

    public String getIDArrivo() {
        return IDArrivo;
    }

    public void setIDArrivo(String IDArrivo) {
        this.IDArrivo = IDArrivo;
    }

    public LocalDate getDataViaggio() {
        return DataViaggio;
    }

    public void setDataViaggio(LocalDate dataViaggio) {
        DataViaggio = dataViaggio;
    }

    public LocalTime getOraPartenza() {
        return OraPartenza;
    }

    public void setOraPartenza(LocalTime oraPartenza) {
        OraPartenza = oraPartenza;
    }

    public LocalTime getOraArrivo() {
        return OraArrivo;
    }

    public void setOraArrivo(LocalTime oraArrivo) {
        OraArrivo = oraArrivo;
    }
}

