
public class Main {

    public static void main(String[] args) {
        MediaConversionFacade converter =
                new MediaConversionFacade();

        try {
            String outputFile = converter.convert(
                    "song.wav", "mp3"
            );

            System.out.println(
                    "\nFinal result: " + outputFile
            );
        } catch (IllegalArgumentException e) {
            System.out.println("Conversion error: " + e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("System error: " + e.getMessage());
        }
    }
}
