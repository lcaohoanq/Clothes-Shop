package clothingstore.module.crypto;

import com.github.luben.zstd.Zstd;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ZstdJni {
    public static void main(String[] args) {
        String originalString = "This is a string to compress and decompress using zstd.";

        byte[] data = originalString.getBytes();
        byte[] compressed = Zstd.compress(data);

        System.out.println("Original string: " + originalString);
        System.out.println("Compressed string: " + new String(compressed));

        byte[] decompressed = Zstd.decompress(compressed, originalString.length());
        System.out.println("Decompressed string: " + new String(decompressed));

    }

    public static class ImageCompression {

        public static void main(String[] args) {
            String originalImagePath = "src/main/resources/dontopenthis.png";
            String compressedImagePath = "src/main/resources/compression/image.zst";
            String decompressedImagePath = "src/main/resources/decompression/image.jpg";

            try {
                // Read the original image
                byte[] originalData = Files.readAllBytes(Paths.get(originalImagePath));

                // Compress the image data
                byte[] compressedData = Zstd.compress(originalData);
                Files.write(Paths.get(compressedImagePath), compressedData);

                // Decompress the image data
                byte[] decompressedData = Zstd.decompress(compressedData, originalData.length);
                Files.write(Paths.get(decompressedImagePath), decompressedData);

                System.out.println("Compression and decompression completed.");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
