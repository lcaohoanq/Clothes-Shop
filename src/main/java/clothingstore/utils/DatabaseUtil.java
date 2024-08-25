package clothingstore.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

public class DatabaseUtil {

    @Getter
    @ToString
    @AllArgsConstructor
    public class DatabaseConnection {
        private String url;
        private String user;
        private String password;
    }

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
