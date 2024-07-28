package clothingstore.dao;

import clothingstore.constant.DatabaseQueries;
import clothingstore.utils.DatabaseUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import clothingstore.model.PaymentDTO;

@Deprecated
public class PaymentDAO extends DatabaseUtil {

    public PaymentDTO getPaymentById(int id) throws SQLException {
        PaymentDTO result = null;
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DatabaseQueries.GET_PAYMENTNAME_BYID);
                ptm.setInt(1, id);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    String method = rs.getString("payment_method");
                    result = new PaymentDTO(id, method);
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
        return result;
    }

    public List<PaymentDTO> getPaymentData() throws SQLException {
        List<PaymentDTO> result = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DatabaseQueries.GET_PAYMENTNAME_DATA);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int id = rs.getInt("paymentid");
                    String method = rs.getString("payment_method");
                    PaymentDTO payment = new PaymentDTO(id, method);
                    result.add(payment);
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
        return result;
    }
    
//    public static void main(String[] args) throws SQLException {
//        PaymentDAO dao = new PaymentDAO();
//        List<PaymentDTO> pms = dao.getPaymentData();
//        for (PaymentDTO pm : pms) {
//            System.out.println(pm.getPaymentMethod());
//
//        }
//
//    }
}
