package it.unipv.ingsfw.treninordovest.utils.metodipagamento.wallet;

import it.unipv.ingsfw.treninordovest.utils.metodipagamento.IMetodoPagamento;

public class EUWallet implements IValuable , IMetodoPagamento {

    private double val;



    public EUWallet(double val) {
        super();
        this.val = val;
    }

    public EUWallet() {}



    public void setVal(double val) {
        this.val = val;
    }

    @Override
    public double getValue() {
        // TODO Auto-generated method stub
        return val;
    }

    public boolean preleva(double importo) {
        if (importo > val || importo <= 0) {
            System.out.println("Credito insufficiente o importo non valido");
            return false;
        }
        val -= importo;
        System.out.println("Denaro scalato val: " + val);
        return true;
    }
    
    public boolean deposita(double importo) {
        if (importo > 0) {
            val += importo;
            return true;
        }
        return false;
    }

    @Override
    public boolean valida() {
        return false;
    }

    @Override
    public boolean processaPagamento(double importo) {
        return preleva(importo);
    }

    @Override
    public boolean verificaSufficienzaCredito() {
        
        if (val <= 0) {
            System.out.println("DEBUG: Credito insufficiente");
            return false;
        }
        if (val > 0) {
            System.out.println("DEBUG: Credito positivo");
            return true;
        }

        return false;
    }
}