import java.io.*;
import java.util.*;

public class lineReverser {

    public static void reverseInputLines(BufferedReader reader) throws IOException {
        Stack<String> lines = new Stack<>();
        String line;

        while ((line = reader.readLine()) != null) {
            lines.push(line);
        }

        while (!lines.isEmpty()) {
            System.out.println(lines.pop());
        }
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            String filename = args[0];
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                reverseInputLines(reader);
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        } else {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                System.out.println("Enter lines of text (Ctrl+D to end):");
                reverseInputLines(reader);
            } catch (IOException e) {
                System.out.println("Error reading input: " + e.getMessage());
            }
        }
    }
}