package quadtree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Check if exactly one argument is passed (the filename).
        if (args.length != 1) {
            System.out.println("Usage: java Main <filename>");
            return;  // Exit if the wrong number of arguments is provided.
        }

        // Create a new instance of Quadtree
        Quadtree quadTree = new Quadtree();
        String filename = args[0];  // Filename is the first argument

        // Try with resources to ensure that the BufferedReader is properly closed.
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;

            // Read the input file line by line.
            while ((line = br.readLine()) != null) {
                // Remove semicolon at the end (if present) and split the line into parts by spaces.
                String[] parts = line.replace(";", "").split(" ");

                // The first element in the split parts will be the command (insert, find, delete, etc.).
                switch (parts[0]) {
                    // Case for inserting a rectangle into the quadtree.
                    case "insert":
                        // Parse coordinates and dimensions from the command arguments
                        double x = Double.parseDouble(parts[1]);
                        double y = Double.parseDouble(parts[2]);
                        double length = Double.parseDouble(parts[3]);
                        double width = Double.parseDouble(parts[4]);

                        // Call the insert method of Quadtree.
                        quadTree.insert(x, y, length, width);
                        break;


                    // Case for finding a rectangle at the given coordinates.
                    case "find":
                        // Parse coordinates from the command arguments.
                        x = Double.parseDouble(parts[1]);
                        y = Double.parseDouble(parts[2]);
                        // Find the rectangle in the quadtree at the specified location.
                        Rectangle found = quadTree.find(x, y);
                        // If a rectangle is found, print it, otherwise print a message.
                        if (found != null) {
                            System.out.println(found);
                        } else {
                            System.out.println("Nothing is at " + x + ", " + y);
                        }
                        break;


                    // Case for deleting a rectangle at the given coordinates.
                    case "delete":
                        // Parse coordinates from the command arguments.
                        x = Double.parseDouble(parts[1]);
                        y = Double.parseDouble(parts[2]);

                        // Call the delete method to remove the rectangle at the specified location.
                        quadTree.delete(x, y);
                        break;


                    // Case for updating an existing rectangle at the given coordinates.
                    case "update":
                        // Parse coordinates and new dimensions from the command arguments.
                        x = Double.parseDouble(parts[1]);
                        y = Double.parseDouble(parts[2]);
                        length = Double.parseDouble(parts[3]);
                        width = Double.parseDouble(parts[4]);

                        // Call the update method to modify the rectangle's dimensions.
                        quadTree.update(x, y, length, width);
                        break;


                    // Case for dumping the current state of the quadtree.
                    case "dump":
                        // Call the dump method to print the current state of the quadtree.
                        quadTree.dump();
                        break;


                    // Handle unknown commands by printing an error message.
                    default:
                        System.out.println("Unknown command: " + parts[0]);
                }
            }
        } catch (IOException e) {
            // Catch and print any IOException that occurs while reading the file.
            e.printStackTrace();
        }
    }
}
