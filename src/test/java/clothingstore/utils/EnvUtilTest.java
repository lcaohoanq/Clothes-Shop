package clothingstore.utils;

import static org.junit.Assert.*;

import io.github.cdimascio.dotenv.Dotenv;
import org.junit.Before;
import org.junit.Test;

public class EnvUtilTest {
    private Dotenv dotenv;
    @Before
    public void setUp() throws Exception {
        dotenv = Dotenv.configure().load();
    }

    @Test
    public void get() {
        String key = "DB_URL_1";
        String expected = dotenv.get(key);
        String actual = EnvUtil.get(key);
        assertEquals(expected, actual);
    }
}