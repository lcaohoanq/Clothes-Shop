package clothingstore.utils;

import java.util.Comparator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mockStatic;

class LogUtilTest {

    private Path tempDir;

    @BeforeEach
    void setUp() throws Exception {
        // Create a temporary directory to simulate the project root
        tempDir = Files.createTempDirectory("projectRoot");
    }

    @AfterEach
    void tearDown() throws Exception {
        // Clean up temporary directory
        Files.walk(tempDir)
            .sorted(Comparator.reverseOrder())
            .map(Path::toFile)
            .forEach(File::delete);
    }

    @Test
    void testEnsureLogsFolderExists() {
        // Ensure logs folder does not exist before the test
        File logsFolder = new File(tempDir.toString(), "logs");
        if (logsFolder.exists()) {
            logsFolder.delete();
        }

        // Run the method
        LogUtil.ensureLogsFolderExists(tempDir.toString());

        // Verify the logs folder was created
        assertTrue(logsFolder.exists());
        assertTrue(logsFolder.isDirectory());
    }
}
