package quadtree;

public abstract class Node {
    // The x and y coordinates of the bottom-left corner of the node's bounding box.
    protected double x, y;
    // The width and height define the size of the node's bounding box.
    protected double width, height;


    /**
     * Constructs a Node with a specified position and size.
     * 
     * @param x The x-coordinate of the node's bottom-left corner.
     * @param y The y-coordinate of the node's bottom-left corner.
     * @param width The width of the node's bounding box.
     * @param height The height of the node's bounding box.
     */
    public Node(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }



    /**
     * Inserts a rectangle into the node.
     * 
     * @param rectangle The rectangle to insert.
     */
    public abstract void insert(Rectangle rectangle);



    /**
     * Deletes a rectangle from the node based on coordinates.
     * 
     * @param x The x-coordinate of the rectangle's bottom-left corner.
     * @param y The y-coordinate of the rectangle's bottom-left corner.
     */
    public abstract void delete(double x, double y);



    /**
     * Finds a rectangle in the node that contains the given point.
     * 
     * @param x The x-coordinate of the search point.
     * @param y The y-coordinate of the search point.
     * @return The rectangle found, or null if no rectangle contains the point.
     */
    public abstract Rectangle find(double x, double y);



    /**
     * Dumps the structure of the node for debugging purposes.
     * 
     * @param level The depth level of the node in the quadtree.
     */
    public abstract void dump(int level);



    /**
     * Checks if a point is contained within the node's bounding box.
     * 
     * @param x2 The x-coordinate of the point.
     * @param y2 The y-coordinate of the point.
     * @return true if the point is within the node's bounding box, false otherwise.
     */
    public boolean contains(double x2, double y2) {
        return false;
    }
}
