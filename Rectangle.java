package quadtree;

public class Rectangle {
    // Rectangle properties: bottom-left corner (x, y), length, and width
    private double x, y, length, width;

    // Constructor to initialize rectangle properties
    public Rectangle(double x, double y, double length, double width) {
        this.x = x;
        this.y = y;
        this.length = length;
        this.width = width;
    }

    // Getters for the rectangle's properties
    public double getX() { return x; }
    public double getY() { return y; }
    public double getLength() { return length; }
    public double getWidth() { return width; }

    // Returns rectangle details as a string
    @Override
    public String toString() {
        return String.format("Rectangle at (%.2f, %.2f): %.2fx%.2f", x, y, length, width);
    }

    // Checks if a point (px, py) is inside the rectangle
    public boolean containsPoint(double px, double py) {
        return px >= x && px <= (x + length) && py >= y && py <= (y + width);
    }
}

