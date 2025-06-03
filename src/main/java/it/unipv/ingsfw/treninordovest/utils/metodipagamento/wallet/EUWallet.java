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
            return false;
        }
        val -= importo;
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

}