import java.io.*;
import java.util.*;

public class SortLinesByLengthWithLinkedList {

    public static void sortLines(BufferedReader reader) throws IOException {
        LinkedList<String> linesList = new LinkedList<>();

        String line;
        while ((line = reader.readLine()) != null) {
            if (!linesList.contains(line)) {
                linesList.add(line);
            }
        }

        Collections.sort(linesList, (a, b) -> {
            int lengthComparison = Integer.compare(a.length(), b.length());
            if (lengthComparison != 0) {
                return lengthComparison;
            }
            return a.compareTo(b);
        });

        for (String sortedLine : linesList) {
            System.out.println(sortedLine);
        }
    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java SortLinesByLengthWithLinkedList <filename>");
            return;
        }

        String filename = args[0];
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            sortLines(reader);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
