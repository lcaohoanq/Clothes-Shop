package clothingstore.utils;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import clothingstore.service.DatabaseService;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DatabaseServiceTest {

    private static final DatabaseService db = new DatabaseService();
    private static Connection connection;

    @BeforeAll
    public static void setUp() {
        try {
            connection  = db.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterAll
    public static void tearDown() {
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