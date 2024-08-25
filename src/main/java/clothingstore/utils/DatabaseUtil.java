package clothingstore.utils;

import clothingstore.dto.DatabaseConnection;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtil {
    public Connection getConnection() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        DatabaseConnection  databaseConnection = new DatabaseConnection(EnvUtil.get("DB_URL"), EnvUtil.get("DB_USER"), EnvUtil.get("DB_PASSWORD"));
        System.out.println("Database connection: " + databaseConnection);
        return DriverManager.getConnection(
            databaseConnection.getUrl(),
            databaseConnection.getUser(),
            databaseConnection.getPassword());
    }

    //Test connection
    public static void main(String[] args) throws Exception {
        try {
            Connection connection = new DatabaseUtil().getConnection();
            if (connection != null) {
                System.out.println("Connect successfully");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
