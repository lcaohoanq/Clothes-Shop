package clothingstore.utils;

import clothingstore.dao.OrderDAO;
import clothingstore.model.OrderDTO;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public Connection getConnection() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = EnvUtil.get("DB_URL");
        String user = EnvUtil.get("DB_USER");
        String password = EnvUtil.get("DB_PASSWORD");
        Connection con = DriverManager.getConnection(url, user, password);
        return con;
    }

    //Test connection
    public static void main(String[] args) throws Exception {
        try {
            Connection connection = new DatabaseConnection().getConnection();
            if (connection != null) {
                System.out.println("Connect successfully");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
