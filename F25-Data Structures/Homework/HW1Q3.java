import java.io.*;
import java.util.*;

public class ReverseChunks {

    public static void reverseChunks(BufferedReader reader) throws IOException {
        String line;
        Stack<String> stack = new Stack<>();
        int count = 0;

        while ((line = reader.readLine()) != null) {
            stack.push(line);
            count++;

            if (count == 50) {
                printReversed(stack);
                stack.clear();
                count = 0;
            }
        }

        if (!stack.isEmpty()) {
            printReversed(stack);
        }
    }

    private static void printReversed(Stack<String> stack) {
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            String filename = args[0];
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                reverseChunks(reader);
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        } else {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                System.out.println("Enter lines of text (Ctrl+D to end):");
                reverseChunks(reader);
            } catch (IOException e) {
                System.out.println("Error reading input: " + e.getMessage());
            }
        }
    }
}
