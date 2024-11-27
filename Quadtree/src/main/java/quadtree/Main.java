package quadtree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Main class for the Quadtree project.
 * This program processes commands from a command file to manipulate a Quadtree data structure.
 * Supported operations include insert, delete, find, update, and dump.
 */
public class Main {

    /**
     * Main method of the program. Reads a command file, processes each command, and manipulates the Quadtree.
     *
     * @param args Command-line arguments. The first argument must be the path to the command file.
     */
    public static void main(String[] args) {
        // Check if the correct number of arguments is provided
        if (args.length != 1) {
            System.out.println("Usage: java quadtree.Main <command-file>");
            return;
        }

        String commandFile = args[0]; // Path to the command file
        Quadtree quadtree = new Quadtree(); // Initialize the Quadtree

        // Try to read and process the command file
        try (BufferedReader reader = new BufferedReader(new FileReader(commandFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                processCommand(line, quadtree);
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

    /**
     * Processes a single command and performs the corresponding operation on the Quadtree.
     *
     * Supported commands:
     * - "insert x y length width": Inserts a rectangle into the Quadtree.
     * - "delete x y": Deletes a rectangle at the specified coordinates.
     * - "find x y": Finds and prints a rectangle at the specified coordinates.
     * - "update x y newLength newWidth": Updates the dimensions of a rectangle.
     * - "dump": Prints the structure of the entire Quadtree.
     *
     * @param command  The command to process.
     * @param quadtree The Quadtree to manipulate.
     */
    private static void processCommand(String command, Quadtree quadtree) {
        // Split the command into parts based on whitespace
        String[] parts = command.split("\\s+");

        try {
            // Parse and execute the command
            switch (parts[0].toLowerCase()) {
                case "insert":
                    double x = Double.parseDouble(parts[1]);
                    double y = Double.parseDouble(parts[2]);
                    double length = Double.parseDouble(parts[3]);
                    double width = Double.parseDouble(parts[4]);

                    // Check if a rectangle already exists at the position
                    if (quadtree.find(x, y) != null) {
                        System.out.println("You can not double insert at a position.");
                        System.exit(1);
                    }

                    // Insert the rectangle
                    Rectangle rect = new Rectangle(x, y, length, width);
                    quadtree.insert(rect);
                    System.out.println("Inserted: " + rect);
                    break;

                case "delete":
                    x = Double.parseDouble(parts[1]);
                    y = Double.parseDouble(parts[2]);

                    // Find and delete the rectangle
                    Rectangle toDelete = quadtree.find(x, y);
                    if (toDelete == null) {
                        System.out.println("Nothing to delete at [" + x + ", " + y + "].");
                        System.exit(1);
                    }
                    quadtree.delete(toDelete);
                    System.out.println("Deleted: " + toDelete);
                    break;

                case "find":
                    x = Double.parseDouble(parts[1]);
                    y = Double.parseDouble(parts[2]);

                    // Find and print the rectangle
                    Rectangle found = quadtree.find(x, y);
                    if (found == null) {
                        System.out.println("Nothing is at [" + x + ", " + y + "].");
                        System.exit(1);
                    } else {
                        System.out.println("Found: " + found);
                    }
                    break;

                case "update":
                    x = Double.parseDouble(parts[1]);
                    y = Double.parseDouble(parts[2]);
                    length = Double.parseDouble(parts[3]);
                    width = Double.parseDouble(parts[4]);

                    // Find and update the rectangle
                    Rectangle toUpdate = quadtree.find(x, y);
                    if (toUpdate == null) {
                        System.out.println("Nothing to update at [" + x + ", " + y + "].");
                        System.exit(1);
                    }

                    System.out.println("Updated: Rectangle at (" + x + ", " + y + ") from " 
                        + toUpdate.getLength() + "x" + toUpdate.getWidth() 
                        + " to " + length + "x" + width);

                    quadtree.delete(toUpdate); // Remove the old rectangle
                    quadtree.insert(new Rectangle(x, y, length, width)); // Insert the updated rectangle
                    break;

                case "dump":
                    // Print the structure of the Quadtree
                    System.out.println("Dumping Quadtree:");
                    quadtree.dump();
                    break;

                default:
                    // Handle unknown commands
                    System.out.println("Unknown command: " + command);
                    break;
            }
        } catch (Exception e) {
            // Handle exceptions during command processing
            System.err.println("Error processing command: " + command);
            System.err.println(e.getMessage());
        }
    }
}
