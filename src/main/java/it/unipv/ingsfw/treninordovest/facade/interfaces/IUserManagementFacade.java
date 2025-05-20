package it.unipv.ingsfw.treninordovest.facade.interfaces;

public interface IUserManagementFacade<T> {

 T mostraDati();
 boolean aggiornaPassword(String password);


}
