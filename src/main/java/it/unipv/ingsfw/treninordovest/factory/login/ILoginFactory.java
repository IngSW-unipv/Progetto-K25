package it.unipv.ingsfw.treninordovest.factory.login;

public interface ILoginFactory<T>  {
    T login(T t);
    void showUserInterface();

}
