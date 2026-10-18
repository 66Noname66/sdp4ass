
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class MediaConversionFacade {

    private final MetadataReader metadataReader;
    private final CodecFactory codecFactory;
    private final BitrateReader bitrateReader;
    private final AudioMixer audioMixer;

    public MediaConversionFacade() {
        this.metadataReader = new MetadataReader();
        this.codecFactory = new CodecFactory();
        this.bitrateReader = new BitrateReader();
        this.audioMixer = new AudioMixer();
    }

    public String convert(String fileName, String targetFormat) {
        String sourceFormat = metadataReader.readFormat(fileName);

        if (sourceFormat.equalsIgnoreCase(targetFormat)) {
            throw new IllegalArgumentException(
                    "Source and target formats must be different."
            );
        }

        String metadata = metadataReader.readMetadata(fileName);

        String sourceCodec = codecFactory.getCodec(sourceFormat);
        String targetCodec = codecFactory.getCodec(targetFormat);

        byte[] audioData = bitrateReader.read(fileName);
        byte[] processedData = bitrateReader.process(
                audioData, sourceCodec
        );

        byte[] convertedData = audioMixer.mix(
                processedData, targetFormat
        );

        String outputFileName = getOutputFileName(
                fileName, targetFormat
        );

        try {
            Files.write(Path.of(outputFileName), convertedData);
        } catch (IOException e) {
            throw new RuntimeException(
                    "Could not save converted file.", e
            );
        }

        System.out.println("Conversion completed successfully.");
        System.out.println("Metadata preserved: " + metadata);
        System.out.println("Target codec: " + targetCodec);
        System.out.println("Output file: " + outputFileName);
        System.out.println(
                "Output size: " + convertedData.length + " bytes"
        );

        return outputFileName;
    }

    private String getOutputFileName(
            String fileName, String targetFormat) {

        int dotIndex = fileName.lastIndexOf('.');
        String baseName = fileName.substring(0, dotIndex);

        return baseName + "_converted." + targetFormat.toLowerCase();
    }
}
