package com.runets.trainingproject.creator;

import com.runets.trainingproject.entity.Point;
import com.runets.trainingproject.entity.Triangle;
import com.runets.trainingproject.exception.ValidationException;
import com.runets.trainingproject.validation.TriangleValidation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleCreator extends AbstractCreator {
    private static Logger Logger = LogManager.getLogger(TriangleCreator.class);

    public Triangle createTriangle(int id, double[] coordinates) throws ValidationException {
        Point point1 = new Point(coordinates[0], coordinates[1]);
        Point point2 = new Point(coordinates[2], coordinates[3]);
        Point point3 = new Point(coordinates[4], coordinates[5]);

        if (!TriangleValidation.getInstance().isTriangle(point1, point2, point3)) {
            throw new ValidationException("The wrong values  of points, to create a triangle.");
        }
        Logger.info("Triangle id is " + id);
        return new Triangle(id, point1, point2, point3);
    }
}
