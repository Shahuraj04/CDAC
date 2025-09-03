package com.developers.geometry;

public class Point2D {
    private int x, y;

    public Point2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String show() {
        return "(" + x + ", " + y + ")";
    }

    public boolean isEqual(Point2D obj) {
        return this.x == obj.x && this.y == obj.y;
    }

    public double calculateDistance(Point2D obj) {
        int xDistance = this.x - obj.x;
        int yDistance = this.y - obj.y;
        return Math.sqrt(xDistance * xDistance + yDistance * yDistance);
    }
}
