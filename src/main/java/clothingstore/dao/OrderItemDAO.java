package clothingstore.dao;

import clothingstore.constant.DatabaseQueries;
import clothingstore.utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import clothingstore.model.CartItem;
import clothingstore.model.OrderDTO;
import clothingstore.model.OrderItemDTO;
import clothingstore.model.ProductDTO;

public class OrderItemDAO extends DatabaseConnection {

    private ProductDAO pDao = new ProductDAO();



    public List<OrderItemDTO> getOrderItemByOrderId(int id) {
        List<OrderItemDTO> list = new ArrayList<>();
        Connection con = null;
        ResultSet rs = null;
        PreparedStatement ptm = null;
        try {
            con = getConnection();
            if (con != null) {
                ptm = con.prepareStatement(DatabaseQueries.GET_ORDER_ITEM_BY_ORDER_ID);
                ptm.setInt(1, id);
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int quantity = rs.getInt("quantity");
                    double price = rs.getDouble("price");
                    int productID = rs.getInt("product_id");
                    ProductDTO product = pDao.getProductByID(productID);
                    int orderID = rs.getInt("order_id");
                    OrderItemDTO order = new OrderItemDTO(orderID,quantity, price, product);
                    list.add(order);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
    public boolean createNewOrderDetail(CartItem item, OrderDTO order) throws SQLException {
        Connection conn = null;
        PreparedStatement ptm = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement(DatabaseQueries.CREATE_NEW_ORDER_ITEM);
                ptm.setInt(1,item.getQuantity());
                ptm.setDouble(2,item.getProduct().getSalePrice());
                ptm.setInt(3, item.getProduct().getId());
                ptm.setInt(4,order.getOrderID());
                ptm.executeUpdate();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (ptm != null) {
                ptm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return false;
    }

    public List<OrderItemDTO> getOrderedItemByOrderID (String orderID) throws SQLException {
        List<OrderItemDTO> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ptm = null;
        ResultSet rs = null;
        try {
            conn = getConnection();
            if (conn != null) {
                ptm = conn.prepareStatement("SELECT * FROM OrderItem WHERE order_id = '" + orderID + "'");
                rs = ptm.executeQuery();
                while (rs.next()) {
                    int orderItemID = rs.getInt("order_item_id");
                    int quantity = rs.getInt("quantity");
                    double price = rs.getDouble("price");
                    OrderItemDTO orderItem = new OrderItemDTO(orderItemID, quantity, price);
                    list.add(orderItem);
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

    public static void main(String[] args) {
        OrderItemDAO dao = new OrderItemDAO();
        List<OrderItemDTO> list = dao.getOrderItemByOrderId(1);
        for (OrderItemDTO orderItemDTO : list) {
            System.out.println(orderItemDTO.getProduct().getName());
        }
    }

}
