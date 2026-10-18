import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class BitrateReader {

    public byte[] read(String fileName) {
        byte[] data = (
                "SIMULATED_AUDIO_DATA_FROM_" + fileName
        ).getBytes(StandardCharsets.UTF_8);

        System.out.println(
                "BitrateReader: Read " + data.length + " bytes."
        );

        return data;
    }

    public byte[] process(byte[] data, String codec) {
        byte[] processed = Arrays.copyOf(data, data.length);

        for (int i = 0; i < processed.length; i++) {
            processed[i] = (byte) (processed[i] ^ 1);
        }

        System.out.println(
                "BitrateReader: Processed audio using " + codec
        );

        return processed;
    }
}
