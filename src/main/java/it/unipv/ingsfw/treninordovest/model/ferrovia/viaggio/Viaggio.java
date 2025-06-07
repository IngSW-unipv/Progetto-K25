package it.unipv.ingsfw.treninordovest.model.ferrovia.viaggio;

import java.time.LocalDate;
import java.time.LocalTime;

public class Viaggio {
    public Viaggio() {
    }

    private String idViaggio;
    private LocalDate DataViaggio;
    private LocalTime OraPartenza;
    private LocalTime OraArrivo;


    public Viaggio(String idViaggio, LocalDate DataViaggio, LocalTime OraPartenza, LocalTime OraArrivo) {
        this.idViaggio = idViaggio;
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

