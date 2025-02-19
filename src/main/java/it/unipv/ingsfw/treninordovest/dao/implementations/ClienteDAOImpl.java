package it.unipv.ingsfw.treninordovest.dao.implementations;

import it.unipv.ingsfw.treninordovest.dao.database.Database;
import it.unipv.ingsfw.treninordovest.dao.interfaces.ClienteDAO;
import it.unipv.ingsfw.treninordovest.model.utenti.Cliente;
import it.unipv.ingsfw.treninordovest.model.utenti.Utente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class ClienteDAOImpl implements ClienteDAO {
    @Override
    public Cliente get(String id) throws SQLException {
        //Esempio
        Connection con=new Database().getConnection();
        Cliente cliente=null;
        String sql="select * from utente ut join cliente cl on ut.id=ut.IDCLiente  where =?";

        PreparedStatement ps=null;
        ps=con.prepareStatement(sql);
        //ps.setInt(1,id);
        ResultSet rs=ps.executeQuery();
        //id=rs.getString("ID");

        if(rs.next()){
            String nome=rs.getString("nome");
            String cognome=rs.getString("cognome");
            String email=rs.getString("email");
            String password=rs.getString("UserPassword");
            double bilancio=rs.getDouble("bilancio");
            String luogoNascita=rs.getString("luogoNascita");
            Date dataNascita=rs.getDate("dataNascita");
            String sesso=rs.getString("sesso");
            String cellulare=rs.getString("cellulare");
            String indirizzo=rs.getString("indirizzo");
            char sessoChar = sesso.charAt(0);

            cliente=new Cliente(id,nome,password,cognome,luogoNascita, sessoChar, dataNascita,cellulare,indirizzo,bilancio,email);
        }




        return cliente;
    }

    @Override
    public List<Cliente> getAll() throws SQLException {
        return List.of();
    }

    @Override
    public int save(Cliente cliente) throws SQLException {
        return 0;
    }

    @Override
    public int delete(int id) throws SQLException {
        return 0;
    }

    @Override
    public int update(Cliente cliente) throws SQLException {
        return 0;
    }

    @Override
    public int insert(Cliente cliente) throws SQLException {
        return 0;
    }
}
