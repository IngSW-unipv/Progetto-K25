package it.unipv.ingsfw.treninordovest.model.ferrovia.viaggio;

import it.unipv.ingsfw.treninordovest.model.ferrovia.fermata.Fermata;
import it.unipv.ingsfw.treninordovest.model.ferrovia.tratta.Tratta;
import it.unipv.ingsfw.treninordovest.model.ferrovia.treno.Treno;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class Viaggio {
    public Viaggio() {
    }

    private String idViaggio;
    private LocalDate DataViaggio;
    private LocalTime oraPartenza;
    private LocalTime oraArrivo;
    private Fermata partenza;
    private Fermata destinazione;
    private Tratta tratta;
    private Treno treno;


    public Viaggio(String idViaggio, LocalDate DataViaggio, LocalTime OraPartenza, LocalTime OraArrivo) {
        this.idViaggio = idViaggio;
        this.DataViaggio = DataViaggio;
        this.oraPartenza = OraPartenza;
        this.oraArrivo = OraArrivo;
    }

    //Costuttore per incapsulare gli spostamenti delle chiavi esterne
    public Viaggio(String idViaggio){
        this.idViaggio = idViaggio;
    }

    public Viaggio(String idViaggio, Tratta tratta,Treno treno, Fermata partenza, Fermata destinazione, LocalTime oraPartenza,LocalTime oraArrivo,LocalDate DataViaggio) {
        this.idViaggio = idViaggio;
        this.treno = treno;
        this.partenza = partenza;
        this.destinazione = destinazione;
        this.oraArrivo = oraArrivo;
        this.oraPartenza = oraPartenza;
        this.DataViaggio = DataViaggio;
        this.tratta = tratta;
    }

    public String getIdViaggio() {
        return idViaggio;
    }

    public LocalDate getDataViaggio() {
        return DataViaggio;
    }

    public LocalTime getOraPartenza() {
        return oraPartenza;
    }

    public LocalTime getOraArrivo() {
        return oraArrivo;
    }

    public Fermata getPartenza() {
        return partenza;
    }

    public Tratta getTratta() {
        return tratta;
    }

    public Treno getTreno() {
        return treno;
    }

    public Fermata getDestinazione() {
        return destinazione;
    }


}

