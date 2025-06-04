package it.unipv.ingsfw.treninordovest.utils.metodipagamento;

import java.time.LocalDate;

public class CartaCredito implements IMetodoPagamento {
    private String numeroCarta;
    private LocalDate dataScadenza;
    private String cvv;

    public CartaCredito() {}

    public CartaCredito(String numeroCarta, LocalDate dataScadenza, String cvv) {
        this.numeroCarta = numeroCarta;
        this.dataScadenza = dataScadenza;
        this.cvv = cvv;
    }

    @Override
    public boolean valida() {

        /**
         * Carta di credito semplificata, implementata interfaccia per espandibilità
         * */

        if (numeroCarta == null || dataScadenza == null || cvv == null) {
            return false;
        } if (numeroCarta.length() != 10) {
            return false;
        } if (dataScadenza.isBefore(LocalDate.now())) {
            return false;
        }

        // Implementa le verifiche di base, ad esempio l'algoritmo di Luhn
        return true; // Simulazione
    }

    @Override
    public boolean processaPagamento(double importo) {
        // Simula l'elaborazione del pagamento
        System.out.println("Pagamento di " + importo + "€ effettuato con carta di credito.");
        return true; // Simulazione
    }

    @Override
    public boolean verificaSufficienzaCredito() {
        return true;
    }
}
