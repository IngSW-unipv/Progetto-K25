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

    @Test
    void insert()  {



    }


    @Test
    void update()  {


    }
    
    
    @Test
     void delete()  {

        String id = "PG2583";
        try{
            Connection con = Database.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from pagamento where IDPagamento=?");
            ps.setString(1,id);

            ps.executeUpdate();

            Database.closeConnection(con);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    
    
    
    
}









