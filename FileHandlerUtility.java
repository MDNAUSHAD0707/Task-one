import java.io.*;
import java.util.Scanner;

public class FileHandlerUtility {

    // Method to write data to a file
    public static void writeFile(String filename, String data) {
        try (FileWriter writer = new FileWriter(filename)) {
            writer.write(data);
            System.out.println("✅ File written successfully.");
        } catch (IOException e) {
            System.out.println("❌ Error writing to file: " + e.getMessage());
        }
    }

    // Method to read data from a file
    public static void readFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("📄 File Content:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("❌ Error reading file: " + e.getMessage());
        }
    }

    // Method to modify the content (replace word)
    public static void modifyFile(String filename, String oldWord, String newWord) {
        try {
            // Read original content
            StringBuilder content = new StringBuilder();
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line.replaceAll(oldWord, newWord)).append("\n");
            }
            reader.close();

            // Write modified content back to file
            FileWriter writer = new FileWriter(filename);
            writer.write(content.toString());
            writer.close();

            System.out.println("✅ File modified successfully.");
        } catch (IOException e) {
            System.out.println("❌ Error modifying file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String filename = "sample.txt";

        // Writing to file
        System.out.println("Enter text to write to the file:");
        String data = sc.nextLine();
        writeFile(filename, data);

        // Reading from file
        readFile(filename);

        // Modifying the file
        System.out.println("Enter word to replace:");
        String oldWord = sc.nextLine();
        System.out.println("Enter new word:");
        String newWord = sc.nextLine();
        modifyFile(filename, oldWord, newWord);

        // Reading modified file
        readFile(filename);

        sc.close();
    }
}