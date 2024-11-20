package quadtree;

public class Quadtree {
    // Root node of the quadtree, which could be either a LeafNode or an InternalNode
    private Node root;



    // Constructor: Initializes the quadtree with a single root LeafNode that spans a 100x100 space.
    // The space is centered at (-50, -50) with width and height of 100 units.
    public Quadtree() {
        root = new LeafNode(-50, -50, 100, 100); // Initialize with 100x100 space
    }



    /**
     * Inserts a rectangle into the quadtree.
     * 
     * @param x      The x-coordinate of the rectangle.
     * @param y      The y-coordinate of the rectangle.
     * @param length The length of the rectangle.
     * @param width  The width of the rectangle.
     */
    public void insert(double x, double y, double length, double width) {
        // Create a new Rectangle object and pass it to the root node's insert method.
        root.insert(new Rectangle(x, y, length, width));
    }




    /**
     * Deletes a rectangle from the quadtree at the specified coordinates.
     * 
     * @param x The x-coordinate of the rectangle.
     * @param y The y-coordinate of the rectangle.
     */
    public void delete(double x, double y) {
        // Call the root node's delete method, passing the coordinates of the rectangle.
        root.delete(x, y);
    }




    
    /**
     * Finds and returns a rectangle in the quadtree at the specified coordinates.
     * 
     * @param x The x-coordinate of the rectangle.
     * @param y The y-coordinate of the rectangle.
     * @return The rectangle found or null if not found.
     */
    public Rectangle find(double x, double y) {
        // Call the root node's find method to search for the rectangle at the given coordinates.
        return root.find(x, y);
    }



    //Prints the structure of the quadtree for debugging purposes.
    public void dump() {
        // Call the root node's dump method, starting at level 0 (the root level).
        root.dump(0);
    }



     /**
     * Updates an existing rectangle with new dimensions.
     * 
     * @param x      The x-coordinate of the original rectangle.
     * @param y      The y-coordinate of the original rectangle.
     * @param length The new length of the rectangle.
     * @param width  The new width of the rectangle.
     */
    public void update(double x, double y, double length, double width) {

    // Step 1: Find the existing rectangle at the given coordinates (x, y)
    Rectangle existingRectangle = find(x, y);
    
    // Step 2: If the rectangle is found, delete the old one
    if (existingRectangle != null) {
        delete(x, y);  // Remove the old rectangle
        
        // Step 3: Insert the updated rectangle with new dimensions
        insert(x, y, length, width);
        
        System.out.println("Rectangle updated at (" + x + ", " + y + ")");
    } else {
        System.out.println("No rectangle found at (" + x + ", " + y + ") to update.");
        }

    }


}
