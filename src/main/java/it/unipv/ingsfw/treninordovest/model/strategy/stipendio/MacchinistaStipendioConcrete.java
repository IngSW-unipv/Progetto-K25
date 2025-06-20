package it.unipv.ingsfw.treninordovest.model.strategy.stipendio;

public class MacchinistaStipendioConcrete implements IStipendioStrategy {
    @Override
    public double calcolaStipendio() {
        return 1800;
    }
}
