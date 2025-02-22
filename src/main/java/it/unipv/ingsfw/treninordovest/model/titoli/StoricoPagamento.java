package it.unipv.ingsfw.treninordovest.model.titoli;

import java.time.Instant;
import java.time.LocalDate;

public class Pagamento {

    //Attributi
    private String idStorico;
    private String statoPagamento;
    private String idPagamento;

    //Costruttori
    public StoricoPagamento() {}

    public StoricoPagamento(String idStorico, String idPagamento, String statoPagamento) {
        this.idStorico=idStorico;
        this.statoPagamento=statoPagamento;
        this.idPagamento=idPagamento;

    }

    //Getters e setters

    public String getIdStorico() {
        return idStorico;
    }
    public void setIdStorico(String idStorico) {
        this.idStorico = idStorico;
    }
    public String getStatoPagamento() {
        return statoPagamento;
    }
    public void setStatoPagamento(String statoPagamento) {
        this.statoPagamento = statoPagamento;
    }
    public String getIdPagamento() {
        return idPagamento;
    }
    public void setIdPagamento(String idPagamento) {
        this.idPagamento = idPagamento;
    }

}
