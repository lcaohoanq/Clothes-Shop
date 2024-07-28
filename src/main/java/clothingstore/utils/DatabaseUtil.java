package clothingstore.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtil {
    public Connection getConnection() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        String url = EnvUtil.get("DB_URL");
        String user = EnvUtil.get("DB_USER");
        String password = EnvUtil.get("DB_PASSWORD");
        return DriverManager.getConnection(url, user, password);
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
