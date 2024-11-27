package quadtree;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a leaf node in the Quadtree.
 * Stores rectangles directly within the node until its capacity is exceeded.
 */
public class LeafNode extends Node {
    /** The maximum number of rectangles a leaf node can store. */
    private static final int CAPACITY = 5;

    /** The list of rectangles stored in this leaf node. */
    private List<Rectangle> rectangles;

    /**
     * Constructor for a leaf node.
     *
     * @param xMin The minimum x-coordinate of the region.
     * @param yMin The minimum y-coordinate of the region.
     * @param xMax The maximum x-coordinate of the region.
     * @param yMax The maximum y-coordinate of the region.
     */
    public LeafNode(double xMin, double yMin, double xMax, double yMax) {
        super(xMin, yMin, xMax, yMax);
        this.rectangles = new ArrayList<>();
    }

    @Override
    public void insert(Rectangle rect) {
        if (rectangles.size() < CAPACITY) {
            rectangles.add(rect);
        } else {
            throw new IllegalStateException("Capacity exceeded. Node needs to split.");
        }
    }

    @Override
    public void delete(Rectangle rect) {
        if (!rectangles.remove(rect)) {
            throw new IllegalArgumentException("Rectangle not found.");
        }
    }

    @Override
    public Rectangle find(double x, double y) {
        for (Rectangle rect : rectangles) {
            if (rect.getX() == x && rect.getY() == y) {
                return rect;
            }
        }
        return null;
    }

    @Override
    public void dump(StringBuilder sb, int level) {
        for (int i = 0; i < level; i++) sb.append("\t");
        sb.append("Leaf Node - Rectangle at (")
          .append(xMin).append(", ").append(yMin).append("): ")
          .append((xMax - xMin)).append("x").append((yMax - yMin)).append("\n");

        for (Rectangle rect : rectangles) {
            for (int i = 0; i < level + 1; i++) sb.append("\t");
            sb.append(rect).append("\n");
        }
    }
}
