package quadtree;

public class InternalNode extends Node {
    // Array of child nodes (LeafNode or InternalNode).
    private Node[] children;


    /**
     * Constructs an InternalNode with four quadrants.
     * 
     * @param x      The x-coordinate of the node's bottom-left corner.
     * @param y      The y-coordinate of the node's bottom-left corner.
     * @param width  The width of the node.
     * @param height The height of the node.
     */
    public InternalNode(double x, double y, double width, double height) {
        super(x, y, width, height);

        // Create 4 child nodes to represent the four quadrants of the space.
        children = new Node[4]; // Children represent: Top-left, Top-right, Bottom-left, Bottom-right quadrants

        // Divide the current node's width and height in half to allocate space for each quadrant
        double halfWidth = width / 2;
        double halfHeight = height / 2;

        // Initialize each child node with the appropriate coordinates and dimensions.
        // Top-left Quadrant
        children[0] = new LeafNode(x, y + halfHeight, halfWidth, halfHeight);
        // Top-right Quadrant
        children[1] = new LeafNode(x + halfWidth, y + halfHeight, halfWidth, halfHeight);
        // Bottom-left Quadrant
        children[2] = new LeafNode(x, y, halfWidth, halfHeight);
        // Bottom-right Quadrant
        children[3] = new LeafNode(x + halfWidth, y, halfWidth, halfHeight);
    }



    /**
     * Inserts a rectangle into the quadtree.
     * 
     * @param rectangle The rectangle to insert.
     */
    @Override
    public void insert(Rectangle rectangle) {
        // Iterate over each child node to find where the rectangle fits
        for (Node child : children) {
            // Check if the child contains the coordinates of the rectangle's top-left corner
            if (child.contains(rectangle.getX(), rectangle.getY())) {
                // If the rectangle fits in this child, insert it into that node
                child.insert(rectangle);
                return; // Exit once the rectangle is inserted
            }
        }
    }



    /**
     * Deletes a rectangle based on its coordinates.
     * 
     * @param x The x-coordinate of the rectangle.
     * @param y The y-coordinate of the rectangle.
     */
    @Override
    public void delete(double x, double y) {
        // Iterate over each child node to find which one contains the given coordinates
        for (Node child : children) {
            if (child.contains(x, y)) {
                // Sends the delete operation to the appropriate child node
                child.delete(x, y);
                return; // Exit once the rectangle is deleted
            }
        }
    }




    /**
     * Finds and returns a rectangle at the given coordinates.
     * 
     * @param x The x-coordinate of the rectangle.
     * @param y The y-coordinate of the rectangle.
     * @return The rectangle found or null if not found.
     */
    @Override
    public Rectangle find(double x, double y) {
        // Search through each child node to see if it contains the given coordinates
        for (Node child : children) {
            if (child.contains(x, y)) {
                // Delegate the find operation to the appropriate child node and return the found rectangle
                return child.find(x, y);
            }
        }
        // Return null if no rectangle is found at the given coordinates
        return null;
    }


    


    /**
     * Prints the structure of the node and its children.
     * 
     * @param level The depth level of the node in the quadtree.
     */
    @Override
    public void dump(int level) {
        // Print the details of this internal node, with indentation to show its level in the quadtree
        System.out.println("\t".repeat(level) + "Internal Node - Rectangle at (" + x + ", " + y + "): " + width + "x" + height);
        
        // Recursively call dump on each child node, increasing the level to represent deeper nodes
        for (Node child : children) {
            child.dump(level + 1); // Recursively print each child node at a deeper level
        }
    }
}
