package it.unipv.ingsfw.treninordovest.model.ferrovia.viaggio;

import it.unipv.ingsfw.treninordovest.model.ferrovia.fermata.Fermata;
import it.unipv.ingsfw.treninordovest.model.ferrovia.tratta.Tratta;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class Viaggio {
    public Viaggio() {
    }

    private UUID idViaggio;
    private LocalDate DataViaggio;
    private LocalTime OraPartenza;
    private LocalTime OraArrivo;
    private Fermata partenza;
    private Fermata arrivo;
    private Tratta tratta;


    public Viaggio(String idViaggio, LocalDate DataViaggio, LocalTime OraPartenza, LocalTime OraArrivo) {
        this.idViaggio = UUID.fromString(idViaggio);
        this.DataViaggio = DataViaggio;
        this.OraPartenza = OraPartenza;
        this.OraArrivo = OraArrivo;
    }

    //Costuttore per incapsulare gli spostamenti delle chiavi esterne
    public Viaggio(String idViaggio){
        this.idViaggio = UUID.fromString(idViaggio);
    }



    public String getIdViaggio() {
        return idViaggio.toString();
    }

    public void setIdViaggio(String idViaggio) {
        this.idViaggio = UUID.fromString(idViaggio);
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

    public Fermata getPartenza() {
        return partenza;
    }

    public Fermata getArrivo() {
        return arrivo;
    }

    public Tratta getTratta() {
        return tratta;
    }
}

