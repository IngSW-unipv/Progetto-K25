package it.unipv.ingsfw.treninordovest.model.varie.wallet;

public class EUWallet implements IValuable {

    private double val;

    public EUWallet(double val) {
        super();
        this.val = val;
    }

    public EUWallet() {

    }

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

}