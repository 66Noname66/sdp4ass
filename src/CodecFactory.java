
import java.util.Set;

public class CodecFactory {

    private static final Set<String> SUPPORTED_FORMATS =
            Set.of("mp3", "wav", "ogg");

    public String getCodec(String format) {
        if (!SUPPORTED_FORMATS.contains(format.toLowerCase())) {
            throw new IllegalArgumentException(
                    "Unsupported format: " + format
            );
        }

        String codec = switch (format.toLowerCase()) {
            case "mp3" -> "MP3 Codec";
            case "wav" -> "WAV Codec";
            case "ogg" -> "OGG Codec";
            default -> throw new IllegalArgumentException(
                    "Unsupported format: " + format
            );
        };

        System.out.println("CodecFactory: Selected " + codec);
        return codec;
    }
}
