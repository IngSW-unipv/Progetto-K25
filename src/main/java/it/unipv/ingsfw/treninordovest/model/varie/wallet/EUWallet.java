package it.unipv.ingsfw.treninordovest.model.varie.wallet;

public class EUWallet implements IValuable {

    private double val;

    public EUWallet(double val) {
        super();
        this.val = val;
    }

    public void setVal(double val) {
        this.val = val;
    }

    @Override
    public double getValue() {
        // TODO Auto-generated method stub
        return val;
    }
}