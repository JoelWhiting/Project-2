package quadtree;

/**
 * Abstract base class for nodes in the Quadtree.
 * Represents a rectangular region in 2D space that can contain rectangles or child nodes.
 */
public abstract class Node {
    /** The minimum x-coordinate of the region covered by this node. */
    protected double xMin;

    /** The minimum y-coordinate of the region covered by this node. */
    protected double yMin;

    /** The maximum x-coordinate of the region covered by this node. */
    protected double xMax;

    /** The maximum y-coordinate of the region covered by this node. */
    protected double yMax;

    /**
     * Constructor for a node.
     *
     * @param xMin The minimum x-coordinate.
     * @param yMin The minimum y-coordinate.
     * @param xMax The maximum x-coordinate.
     * @param yMax The maximum y-coordinate.
     */
    public Node(double xMin, double yMin, double xMax, double yMax) {
        this.xMin = xMin;
        this.yMin = yMin;
        this.xMax = xMax;
        this.yMax = yMax;
    }

    /**
     * Inserts a rectangle into this node.
     *
     * @param rect The rectangle to insert.
     */
    public abstract void insert(Rectangle rect);

    /**
     * Deletes a rectangle from this node.
     *
     * @param rect The rectangle to delete.
     */
    public abstract void delete(Rectangle rect);

    /**
     * Finds a rectangle at the specified coordinates.
     *
     * @param x The x-coordinate of the rectangle.
     * @param y The y-coordinate of the rectangle.
     * @return The rectangle at the specified coordinates, or null if not found.
     */
    public abstract Rectangle find(double x, double y);

    /**
     * Dumps the structure and content of this node.
     *
     * @param sb    The StringBuilder to append the output to.
     * @param level The depth level of the node in the tree (for indentation).
     */
    public abstract void dump(StringBuilder sb, int level);
}
