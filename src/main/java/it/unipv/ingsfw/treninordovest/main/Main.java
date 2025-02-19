package it.unipv.ingsfw.treninordovest.main;

import it.unipv.ingsfw.treninordovest.dao.database.Database;
import it.unipv.ingsfw.treninordovest.dao.implementations.ClienteDAOImpl;
import it.unipv.ingsfw.treninordovest.dao.interfaces.ClienteDAO;
import it.unipv.ingsfw.treninordovest.dao.interfaces.UtenteDAO;
import it.unipv.ingsfw.treninordovest.model.utenti.Cliente;
import it.unipv.ingsfw.treninordovest.model.utenti.Utente;

import java.sql.*;

public class Main {

    //Classe di prova -- Verrà rimossa in futuro
    public static void main(String[] args) throws SQLException {

        /*
        try {
            Connection conn=Database.getConnection();
            if (conn==null){
                System.out.println("Connessione fallita");
            }


        }catch(SQLException e){
            e.printStackTrace();
        }*/

        ClienteDAO clienteDAO = new ClienteDAOImpl();
        String id="US001";

        Cliente cliente = clienteDAO.get(id);

        System.out.println(cliente.getNome());








    }
}
