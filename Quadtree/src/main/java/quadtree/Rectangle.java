package quadtree;

/**
 * Represents a rectangle with position and dimensions.
 */
public class Rectangle {
    private double x, y, length, width;

    public Rectangle(double x, double y, double length, double width) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.width = width;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    @Override
    public String toString() {
        return "Rectangle at (" + x + ", " + y + "): " + length + "x" + width;
    }
}
