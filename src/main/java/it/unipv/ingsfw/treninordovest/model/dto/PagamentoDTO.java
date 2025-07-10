package it.unipv.ingsfw.treninordovest.model.dto;

public class PagamentoDTO {
   private String tipoPagamento;
   private int quantita;
    private double prezzo;

    public PagamentoDTO(String tipoPagamento, int quantita, double prezzo) {
        this.tipoPagamento = tipoPagamento;
        this.quantita = quantita;
        this.prezzo = prezzo;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public int getQuantita() {
        return quantita;
    }
}
