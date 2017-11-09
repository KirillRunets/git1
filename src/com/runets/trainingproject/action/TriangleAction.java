package com.runets.trainingproject.action;

import com.runets.trainingproject.entity.Point;
import com.runets.trainingproject.entity.Triangle;
import com.runets.trainingproject.exception.TriangleException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TriangleAction {
    private static Logger Logger = LogManager.getLogger(TriangleAction.class);
    private final static TriangleAction INSTANCE = new TriangleAction();

    private TriangleAction(){}

    public static TriangleAction getInstance(){
        return INSTANCE;
    }

    public double square(Triangle triangle) throws TriangleException {
        double square = 0.0d;

        if (triangle != null || checkPointsInLine(triangle)){
            square = 0.5 * (((triangle.getA().getX() - triangle.getC().getX()) * (triangle.getB().getY() - triangle.getC().getY())) -
                    ((triangle.getB().getX() - triangle.getC().getX()) * (triangle.getA().getY() - triangle.getC().getY())));
        }

        Logger.info("The result of square is: " + Math.abs(square));
        return Math.abs(square);
    }

    private double sideCalculation(Point firstPoint, Point secondPoint){
        return Math.hypot((secondPoint.getX() - firstPoint.getX()), (secondPoint.getY() - firstPoint.getY()));
    }

    public double perimeter(Triangle triangle) throws TriangleException {
        double ab = 0.0d, bc = 0.0d, ac = 0.0d;

        if (triangle != null || checkPointsInLine(triangle)){
            ab = sideCalculation(triangle.getA(), triangle.getB());
            bc = sideCalculation(triangle.getB(), triangle.getC());
            ac = sideCalculation(triangle.getA(), triangle.getC());
        }

        Logger.info("The result of perimeter is: " + ab + bc + ac);
        return ab + bc + ac;
    }

    public boolean checkPointsInLine(Triangle triangle) throws TriangleException {
        if (triangle.getA().getX() == triangle.getB().getX() && triangle.getB().getX() == triangle.getC().getX())
            throw new TriangleException("Wrong location of points on X line");
        if (triangle.getA().getY() == triangle.getB().getY() && triangle.getB().getY() == triangle.getC().getY())
            throw new TriangleException("Wrong location of points on Y line");
        return true;
    }

    public boolean isRightTriangle(Triangle triangle) throws TriangleException {
        double ab = 0.0d, bc = 0.0d, ac = 0.0d;

        if (triangle != null || checkPointsInLine(triangle)){
            ab = sideCalculation(triangle.getA(), triangle.getB());
            bc = sideCalculation(triangle.getB(), triangle.getC());
            ac = sideCalculation(triangle.getA(), triangle.getC());
        }

        return ac == Math.hypot(ab, bc) || ab == Math.hypot(ac, bc) || bc == Math.hypot(ab, ac);
    }
}
