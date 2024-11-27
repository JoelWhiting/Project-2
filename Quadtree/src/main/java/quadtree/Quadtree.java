package quadtree;

/**
 * Represents the Quadtree structure.
 */
public class Quadtree {
    private Node root;

    public Quadtree() {
        root = new LeafNode(-50, -50, 50, 50); // Root node starts as a LeafNode
    }

    /**
     * Inserts a rectangle into the quadtree.
     *
     * @param rect The rectangle to insert.
     */
    public void insert(Rectangle rect) {
        try {
            root.insert(rect);
        } catch (IllegalStateException e) {
            if (root instanceof LeafNode) {
                root = split((LeafNode) root);
                root.insert(rect);
            }
        }
    }

    /**
     * Deletes a rectangle from the quadtree.
     *
     * @param rect The rectangle to delete.
     */
    public void delete(Rectangle rect) {
        root.delete(rect);
    }

    /**
     * Finds a rectangle at the specified coordinates.
     *
     * @param x The x-coordinate of the rectangle.
     * @param y The y-coordinate of the rectangle.
     * @return The rectangle at the specified coordinates, or null if not found.
     */
    public Rectangle find(double x, double y) {
        return root.find(x, y);
    }

    /**
     * Splits a leaf node into an internal node.
     *
     * @param leaf The leaf node to split.
     * @return The new internal node.
     */
    private Node split(LeafNode leaf) {
        return new InternalNode(leaf.xMin, leaf.yMin, leaf.xMax, leaf.yMax);
    }

    /**
     * Dumps the entire quadtree structure.
     */
    public void dump() {
        StringBuilder sb = new StringBuilder();
        root.dump(sb, 0); // Start dumping from the root node at level 0
        System.out.print(sb.toString());
    }
}
