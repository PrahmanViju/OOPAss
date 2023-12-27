package models;

import java.util.LinkedList;
import java.util.List;

public class Shape {
    List<Point> points = new LinkedList<>();



    public void addPoint(Point newPoint) {
        if (points.isEmpty()) {
            points.add(newPoint);
            return;
        }

        int closestIndex = 0;
        double closestDistance = Double.POSITIVE_INFINITY;
        int size = points.size();
        for (int i = 0; i < size; i++) {
            double distance = newPoint.getDistanceTo(points.get(i)) + newPoint.getDistanceTo(points.get((i + 1) % size));
            if (distance < closestDistance) {
                closestDistance = distance;
                closestIndex = i;
            }
        }

        points.add(closestIndex + 1, newPoint);
    }



    public double calcPerimeter() {
        int sides = points.size();
        double perimeter = 0;
        for (int i = 0; i < sides; i++)
            perimeter += points.get(i).getDistanceTo(points.get((i + 1) % sides));
        return perimeter;
    }


    public double getAverageSide() {
        int sides = points.size();
        if (sides <= 1) return 0;
        if (sides == 2) return calcPerimeter();
        return calcPerimeter() / sides;
    }

    public double getLongestSide() {
        double t = 0;
        int size = points.size();
        for (int i = 0; i < size; i++)
            t = Math.max(points.get(i).getDistanceTo(points.get((i + 1) % size)), mx);
        return t;
    }
}