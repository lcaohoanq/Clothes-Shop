package clothingstore.dao;

import clothingstore.constant.DatabaseQueries;
import clothingstore.service.DatabaseService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import clothingstore.model.SupplierDTO;

@Deprecated
public class SupplierDAO extends DatabaseService {

    public List<SupplierDTO> getData() throws SQLException {
        List<SupplierDTO> suppliers = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DatabaseQueries.GETDATASUPPLIER);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int supplierId = rs.getInt("supplierid");
                    String supplierName = rs.getString("suppliername");
                    String supplierImage = rs.getString("supplierimage");
                    suppliers.add(new SupplierDTO(supplierId, supplierName, supplierImage));
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
        return suppliers;
    }

    public SupplierDTO getSupplierById(int id) throws SQLException {
        SupplierDTO supplier = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DatabaseQueries.GETSUPPLIERBYID);
                ptm.setInt(1, id);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int supplierId = rs.getInt("supplierId");
                    String supplierName = rs.getString("suppliername");
                    String supplierImage = rs.getString("supplierimage");
                    supplier = new SupplierDTO(supplierId, supplierName,supplierImage );
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
        return supplier;
    }

//    public static void main(String[] args) throws SQLException {
//        SupplierDAO dao = new SupplierDAO();
//        List<SupplierDTO> list = dao.getData();
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i).getName());
//        }
//    }
}
