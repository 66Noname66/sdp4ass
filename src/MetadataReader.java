
public class MetadataReader {

    public String readFormat(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');

        if (dotIndex == -1 || dotIndex == fileName.length() - 1) {
            throw new IllegalArgumentException(
                    "File must have an extension."
            );
        }

        String format = fileName.substring(dotIndex + 1)
                .toLowerCase();

        if (!format.matches("[a-z0-9]+")) {
            throw new IllegalArgumentException(
                    "Invalid file format."
            );
        }

        System.out.println("MetadataReader: Detected format: " + format);
        return format;
    }

    public String readMetadata(String fileName) {
        String metadata = "Title: " + fileName
                + ", Duration: 180 seconds";

        System.out.println("MetadataReader: " + metadata);
        return metadata;
    }
}
