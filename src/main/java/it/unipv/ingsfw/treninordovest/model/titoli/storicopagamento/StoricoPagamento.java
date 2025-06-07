package it.unipv.ingsfw.treninordovest.model.titoli.storicopagamento;

public class StoricoPagamento {

    //Attributi
    private String idStorico;
    private String statoPagamento;

    //Costruttori
    public StoricoPagamento() {}

    public StoricoPagamento(String idStorico, String idPagamento, String statoPagamento) {
        this.idStorico=idStorico;
        this.statoPagamento=statoPagamento;

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
