package clothingstore.dao;

import clothingstore.constant.DatabaseQueries;
import clothingstore.services.TypeService;
import clothingstore.utils.DatabaseUtil;
import clothingstore.services.IType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import clothingstore.dto.CategoryDTO;
import clothingstore.dto.TypeDTO;

public class CategoryDAO extends DatabaseUtil {

    public List<CategoryDTO> getData() throws SQLException {
        List<CategoryDTO> categories = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DatabaseQueries.GETDATA);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    IType dao = new TypeService();
                    TypeDTO type = dao.getTypeById(rs.getInt("type_id"));
                    int categoryId = rs.getInt("categoryid");
                    String categoryName = rs.getString("categoryname");
                    int typeid = rs.getInt("type_id");
                    categories.add(new CategoryDTO(categoryId, categoryName, type));
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
        return categories;
    }

    public CategoryDTO getCategoryById(int id) throws SQLException {
        CategoryDTO category = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DatabaseQueries.GET_CATEGORY_BYID);
                ptm.setInt(1, id);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    IType dao = new TypeService();
                    TypeDTO type = dao.getTypeById(rs.getInt("type_id"));
                    int categoryId = rs.getInt("categoryid");
                    String categoryName = rs.getString("categoryname");
                    int typeid = rs.getInt("type_id");
                    category = new CategoryDTO(categoryId, categoryName, type);
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
        return category;
    }

    public boolean insertCategory(String categoryName, String typeId) {
        Connection con = null;
        PreparedStatement ptm = null;
        try {
            con = getConnection();
            if (con != null) {
                ptm = con.prepareStatement(DatabaseQueries.INSERT_CATEGORY);
                ptm.setString(1, categoryName);
                ptm.setString(2, typeId);
                ptm.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return false;
    }

    public void deleteCategory(String cid) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DatabaseQueries.DELETE_CATEGORY);
                ptm.setString(1, cid);
                ptm.executeUpdate();
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
    }

    public void editCategory(String name, String tId, String id) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DatabaseQueries.UPDATE_CATEGORY);
                ptm.setString(1, name);
                ptm.setString(2, tId);
                ptm.setString(3, id);
                ptm.executeUpdate();
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
    }

//    public static void main(String[] args) throws SQLException {
//        CategoryDAO dao = new CategoryDAO();
//        dao.editCategory("mimo", "1", "1");
//        List<CategoryDTO> list = dao.getData();
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).getName());
//        }
////
////        if(dao.insertCategory("ao da")) {
////            System.out.println("OK");
////        }else {
////            System.out.println("FAIL");
////        }
////    List<CategoryDTO> list = dao.getCategoriesByTypeId(1);
//        for (CategoryDTO categoryDTO : list) {
//            System.out.println(categoryDTO.getName());
//        }
//
//        int quantity = dao.getQuantityByName("T-shirt");
//        System.out.println(quantity);
//
//    }
}
