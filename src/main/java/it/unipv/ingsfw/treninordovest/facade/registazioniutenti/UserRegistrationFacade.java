package it.unipv.ingsfw.treninordovest.facade.registazioniutenti;


import it.unipv.ingsfw.treninordovest.model.ferrovia.treno.TrenoDAOImpl;
import it.unipv.ingsfw.treninordovest.model.utenti.cliente.Cliente;
import it.unipv.ingsfw.treninordovest.model.utenti.cliente.ClienteDAOImpl;
import it.unipv.ingsfw.treninordovest.model.utenti.dipendente.Dipendente;
import it.unipv.ingsfw.treninordovest.model.ferrovia.treno.Treno;
import it.unipv.ingsfw.treninordovest.model.utenti.dipendente.DipendenteDAOImpl;
import it.unipv.ingsfw.treninordovest.view.panels.users.CustomerRegistrationPanel;
import it.unipv.ingsfw.treninordovest.view.panels.users.EmployeeRegistrationPanel;
import it.unipv.ingsfw.treninordovest.model.varie.GeneraID;


import javax.swing.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;

public class UserRegistrationFacade implements IUserRegistrationFacade {


    private ClienteDAOImpl clienteDAO;
    private DipendenteDAOImpl dipendenteDAO;

    /**
     * Costruttore privato per implementare il Singleton
     */
    public UserRegistrationFacade() {
        clienteDAO = new ClienteDAOImpl();
        dipendenteDAO = new DipendenteDAOImpl();
    }

    @Override
    public boolean registraCliente(Cliente cliente) {

        try {
            clienteDAO.insert(cliente);
            return true;

        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean registraDipendente(Dipendente dipendente) {

        try {
            dipendenteDAO.insert(dipendente);
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }



}