package clothingstore.utils;

import static org.junit.jupiter.api.Assertions.*;

import io.github.cdimascio.dotenv.Dotenv;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EnvUtilTest {

    private Dotenv env ;

    @BeforeEach
    void setUp() {
        env = Dotenv.configure().load();
    }

    @Test
    void get() {
        String key = "MY_SECRET_KEY";
        String value = env.get(key);
        assertNotNull(value);
    }
}