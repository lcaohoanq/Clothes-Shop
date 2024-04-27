package clothingstore.utils;

import clothingstore.dao.OrderDAO;
import clothingstore.model.OrderDTO;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {

    public Connection getConnection() throws Exception {
        //1. Load Driver(driver is available)
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        //2. Create Connection String
        String url = EnvUtil.get("DB_URL");
        String user = EnvUtil.get("DB_USER");
        String password = EnvUtil.get("DB_PASSWORD");
        //3. Open connection
        Connection con = DriverManager.getConnection(url, user, password);
        return con;
    }

    //Test connection
    public static void main(String[] args) throws Exception {
        DatabaseConnection db = new DatabaseConnection();

        Connection connection = db.getConnection();

        if(connection != null){
            System.out.println("Connected");
        }

        OrderDAO orderDAO = new OrderDAO();
        for(OrderDTO order: orderDAO.getAllOrders()){
            System.out.println(order);
        }
    }

}

//        //1.Get current context
//        Context currentContext = new InitialContext();
//        //2.Get tomcat context
//        Context tomcatContext = (Context) currentContext.lookup("java:comp/env");
//        //3.Access Data source
//        DataSource ds = (DataSource) tomcatContext.lookup("DBCon");
//        //4.Open connection
//        Connection con = ds.getConnection();
//        return con;