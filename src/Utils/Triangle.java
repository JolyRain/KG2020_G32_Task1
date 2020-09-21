package Utils;

import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

public class Triangle extends Path2D.Double {

    public Triangle(Point2D firstPoint, Point2D secondPoint, Point2D thirdPoint) {
        moveTo(firstPoint.getX(), firstPoint.getY());
        lineTo(secondPoint.getX(), secondPoint.getY());
        lineTo(thirdPoint.getX(), thirdPoint.getY());
        closePath();
    }
}

