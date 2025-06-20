package it.unipv.ingsfw.treninordovest.model.ferrovia.treno.tratta;


//public class TrenoTrattaDAOImpl implements TrenoTrattaDAO {
//
//    @Override
//    public TrenoTratta getTT(String id1, String id2) {
//        TrenoTratta trenoTratta = null;
//        PreparedStatement ps;
//        try (Connection con = Database.getConnection()) {
//            trenoTratta = null;
//            //Query effettuata su una vista creata nel DB per semplificare l'estrazione dei dati
//            String sql = "select idTreno, idTratta, numTreno from trenoTratta where idTreno=? AND idTratta=?";
//
//            //Estrazione dei dati dal DB
//            ps = con.prepareStatement(sql);
//            ps.setString(1,id1);
//            ps.setString(1,id2);
//
//            ResultSet rs=ps.executeQuery();
//
//            if(rs.next()){
//                String idTreno = rs.getString("idTreno");
//                String idTratta = rs.getString("idTratta");
//                int numTreno = rs.getInt("numTreno");
//
//                trenoTratta=new TrenoTratta(idTratta, idTreno, numTreno);
//            }
//            Database.closeConnection(con);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return trenoTratta;
//    }
//
//    @Override
//    public TrenoTratta get(TrenoTratta oggetto) {
//        return null;
//    }
//
//    @Override
//    public List<TrenoTratta> getAll()  {
//        return List.of();
//    }
//
//    @Override
//    public void delete(TrenoTratta trenoTratta) {
//
//    }
//
//    @Override
//    public void delete(String id)  {
//
//    }
//
//    @Override
//    public void update(TrenoTratta trenoTratta)  {
//
//    }
//
//    @Override
//    public void insert(TrenoTratta trenoTratta)  {
//
//    }
//
//}
