package clothingstore.dao;

import clothingstore.constant.DatabaseQueries;
import clothingstore.utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import clothingstore.model.TypeDTO;

public class TypeDAO extends DatabaseConnection {

    
    public TypeDTO getTypeById(int id) throws SQLException {
        TypeDTO type = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DatabaseQueries.GET_TYPE_BY_ID);
                ptm.setInt(1, id);
                rs = ptm.executeQuery();
                if (rs.next()) {
                    int typeid = rs.getInt("id");
                    String name = rs.getString("name");
                    type = new TypeDTO(typeid, name);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return type;
    }
    
    public List<TypeDTO> getAllType() throws SQLException {
        List<TypeDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DatabaseQueries.GET_ALL_TYPE);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int typeid = rs.getInt("id");
                    String name = rs.getString("name");
                    TypeDTO type = new TypeDTO(typeid, name);
                    list.add(type);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return list;
    }
    
//    public static void main(String[] args) throws SQLException {
//        TypeDAO dao = new TypeDAO();
////        TypeDTO list = dao.getTypeById(1);
////        System.out.println(list);
//        List<TypeDTO> list = dao.getAllType();
//        for (TypeDTO typeDTO : list) {
//            System.out.println(typeDTO.getName());
//        }
//    }
}
