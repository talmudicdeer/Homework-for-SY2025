import java.io.*;
import java.util.*;

public class UniqueLines {

    public static void printUniqueLines(BufferedReader reader) throws IOException {
        Set<String> seenLines = new HashSet<>();
        String line;

        while ((line = reader.readLine()) != null) {
            if (!seenLines.contains(line)) {
                System.out.println(line);
                seenLines.add(line);
            }
        }
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            String filename = args[0];
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                printUniqueLines(reader);
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        } else {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                System.out.println("Enter lines of text (Ctrl+D to end):");
                printUniqueLines(reader);
            } catch (IOException e) {
                System.out.println("Error reading input: " + e.getMessage());
            }
        }
    }
}
