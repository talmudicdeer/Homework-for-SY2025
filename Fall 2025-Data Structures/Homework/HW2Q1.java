import java.io.*;
import java.util.*;

public class RemoveFirstOccurrenceWithLinkedList {

    public static void processFile(String filename) throws IOException {
        LinkedList<String> seenLines = new LinkedList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (seenLines.contains(line)) {
                    System.out.println(line);
                } else {
                    seenLines.add(line);
                }
            }
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java RemoveFirstOccurrenceWithLinkedList <filename>");
            return;
        }

        String filename = args[0];
        try {
            processFile(filename);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
