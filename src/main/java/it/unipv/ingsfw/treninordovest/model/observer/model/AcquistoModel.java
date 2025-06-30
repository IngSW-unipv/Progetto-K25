package it.unipv.ingsfw.treninordovest.model.observer.model;

import it.unipv.ingsfw.treninordovest.facade.acquisto.AcquistoFacade;
import it.unipv.ingsfw.treninordovest.model.observer.Observer;
import it.unipv.ingsfw.treninordovest.model.observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class AcquistoModel implements Subject {

    private final List<Observer> observers = new ArrayList<>();
    private final AcquistoFacade facade = new AcquistoFacade();


    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers(Object arg) {
        for (Observer o : observers) {
            o.update(arg);
        }

    }







}
