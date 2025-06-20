package it.unipv.ingsfw.treninordovest.model.strategy.stipendio;

public class ImpiegatoStipendioConcrete implements IStipendioStrategy {
    @Override
    public double calcolaStipendio() {
        return 1000;
    }
}
