package clothingstore.utils;

import io.github.cdimascio.dotenv.Dotenv;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EnvUtil {
    private static Dotenv dotenv;

    static {
        try {
            dotenv = Dotenv.configure().load();
        } catch (Exception e) {
            log.error("Read environment variables failed");
            throw new Error("Error initializing EnvUtils: " + e.getMessage());
        }
    }

    public static String get(String key) {
        try {
            return dotenv.get(key);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null; // Return null or a default value in case of error
        }
    }

}
