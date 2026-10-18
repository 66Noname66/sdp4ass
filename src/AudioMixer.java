
import java.nio.charset.StandardCharsets;

public class AudioMixer {

    public byte[] mix(byte[] audioData, String targetFormat) {
        byte[] header = (
                "FORMAT=" + targetFormat.toUpperCase() + ";"
        ).getBytes(StandardCharsets.UTF_8);

        byte[] result = new byte[header.length + audioData.length];

        System.arraycopy(
                header, 0, result, 0, header.length
        );

        System.arraycopy(
                audioData, 0, result, header.length, audioData.length
        );

        System.out.println(
                "AudioMixer: Prepared output for "
                        + targetFormat.toUpperCase()
        );

        return result;
    }
}
