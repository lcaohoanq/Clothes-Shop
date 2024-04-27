package clothingstore.utils;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DatabaseConnectionTest {

    private DatabaseConnection db = new DatabaseConnection();
    private Connection connection;

    @Before
    public void setUp() {
        try {
            connection  = db.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getConnection() {
        assertNotNull(connection);
    }

}