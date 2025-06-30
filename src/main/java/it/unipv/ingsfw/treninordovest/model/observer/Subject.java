package it.unipv.ingsfw.treninordovest.model.observer;

public interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers(Object arg);

}
