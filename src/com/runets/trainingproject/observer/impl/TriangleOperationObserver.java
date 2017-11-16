package com.runets.trainingproject.observer.impl;

import com.runets.trainingproject.action.TriangleAction;
import com.runets.trainingproject.entity.Triangle;
import com.runets.trainingproject.exception.TriangleException;
import com.runets.trainingproject.observer.OperationObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class TriangleOperationObserver implements OperationObserver {
    private static Logger Logger = LogManager.getLogger(TriangleOperationObserver.class);
    private double square;
    private double perimeter;

    public TriangleOperationObserver(Triangle triangle) throws TriangleException {
        square = TriangleAction.getInstance().square(triangle);
        perimeter = TriangleAction.getInstance().perimeter(triangle);
    }

    @Override
    public void valueChanged(Triangle triangle) throws TriangleException {
        square = TriangleAction.getInstance().square(triangle);
        perimeter = TriangleAction.getInstance().perimeter(triangle);
    }

    public double getSquare() {
        return square;
    }
    public double getPerimeter() {
        return perimeter;
    }

    @Override
    public String toString() {
        return "TriangleOperationObserver{" +
                "square=" + square +
                ", perimeter=" + perimeter +
                '}';
    }
}
