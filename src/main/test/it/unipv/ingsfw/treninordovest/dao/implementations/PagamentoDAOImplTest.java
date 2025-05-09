package it.unipv.ingsfw.treninordovest.dao.implementations;

import it.unipv.ingsfw.treninordovest.dao.database.Database;
import it.unipv.ingsfw.treninordovest.model.titoli.Pagamento;
import it.unipv.ingsfw.treninordovest.model.titoli.StoricoPagamento;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

class PagamentoDAOImplTest {

    Connection con = Database.getConnection();
    String id = "PG25834";

    @Test
    void insert()  {

        try  {
            PreparedStatement ps = con.prepareStatement("INSERT INTO pagamento (IDPagamento, IDCliente, Totale,tipopagamento ,DataPagamento) VALUES (?, ?, ?,?, ?)");
            ps.setString(1, id );
            ps.setDouble(2, 123.45);
            ps.setDate(3, java.sql.Date.valueOf(LocalDate.now()));
            ps.setString(4, "CLNTEST"); // Sostituisci con idCliente esistente se necessario
            ps.executeUpdate();
            ps.close();
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }




    }


    @Test
    void update()  {


    }
    
    
    @Test
     void delete()  {

        String id = "PG2583";
        try{

            PreparedStatement ps = con.prepareStatement("delete from pagamento where IDPagamento=?");
            ps.setString(1,id);

            ps.executeUpdate();

            //Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    
    
    
    
}









