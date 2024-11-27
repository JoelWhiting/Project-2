package quadtree;

/**
 * Represents an internal node in the Quadtree.
 * Manages four child nodes corresponding to quadrants of the current region.
 */
public class InternalNode extends Node {
    /** The top-left child node. */
    private Node topLeft;

    /** The top-right child node. */
    private Node topRight;

    /** The bottom-left child node. */
    private Node bottomLeft;

    /** The bottom-right child node. */
    private Node bottomRight;

    /**
     * Constructor for an internal node.
     *
     * @param xMin The minimum x-coordinate of the region.
     * @param yMin The minimum y-coordinate of the region.
     * @param xMax The maximum x-coordinate of the region.
     * @param yMax The maximum y-coordinate of the region.
     */
    public InternalNode(double xMin, double yMin, double xMax, double yMax) {
        super(xMin, yMin, xMax, yMax);
        double midX = (xMin + xMax) / 2;
        double midY = (yMin + yMax) / 2;

        // Initialize child nodes as empty LeafNodes
        topLeft = new LeafNode(xMin, midY, midX, yMax);
        topRight = new LeafNode(midX, midY, xMax, yMax);
        bottomLeft = new LeafNode(xMin, yMin, midX, midY);
        bottomRight = new LeafNode(midX, yMin, xMax, midY);
    }

    @Override
    public void insert(Rectangle rect) {
        getChildNode(rect.getX(), rect.getY()).insert(rect);
    }

    @Override
    public void delete(Rectangle rect) {
        getChildNode(rect.getX(), rect.getY()).delete(rect);
    }

    @Override
    public Rectangle find(double x, double y) {
        return getChildNode(x, y).find(x, y);
    }

    @Override
    public void dump(StringBuilder sb, int level) {
        for (int i = 0; i < level; i++) sb.append("\t");
        sb.append("Internal Node - Rectangle at (")
          .append(xMin).append(", ").append(yMin).append("): ")
          .append((xMax - xMin)).append("x").append((yMax - yMin)).append("\n");

        topLeft.dump(sb, level + 1);
        topRight.dump(sb, level + 1);
        bottomLeft.dump(sb, level + 1);
        bottomRight.dump(sb, level + 1);
    }

    /**
     * Determines the appropriate child node for a given point.
     *
     * @param x The x-coordinate.
     * @param y The y-coordinate.
     * @return The child node that contains the point.
     */
    private Node getChildNode(double x, double y) {
        double midX = (xMin + xMax) / 2;
        double midY = (yMin + yMax) / 2;

        if (x < midX && y >= midY) return topLeft;
        if (x >= midX && y >= midY) return topRight;
        if (x < midX && y < midY) return bottomLeft;
        return bottomRight;
    }
}
