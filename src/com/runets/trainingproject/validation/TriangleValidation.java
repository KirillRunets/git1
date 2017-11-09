package com.runets.trainingproject.validation;

import com.runets.trainingproject.entity.Point;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TriangleValidation {
    private final static int COORDINATE_AMOUNT = 6;

    private final static TriangleValidation INSTANCE = new TriangleValidation();

    private TriangleValidation(){}

    public static TriangleValidation getInstance(){
       return INSTANCE;
    }

    public boolean checkWithRegex(String number){
        Pattern p = Pattern.compile("-?[\\d]+[.]?[\\d]+|[\\d]+$");
        Matcher m = p.matcher(number);
        return m.matches();
    }

    public boolean isRightCoordinatesTriangleAmount(int length){
        return length == COORDINATE_AMOUNT;
    }

    public boolean isTriangle(Point point1, Point point2, Point point3){
        double firstSide = Math.hypot((point2.getX() - point1.getX()), (point2.getY() - point1.getY()));
        double secondSide = Math.hypot((point3.getX() - point2.getX()), (point3.getY() - point2.getY()));
        double thirdSide = Math.hypot((point3.getX() - point1.getX()), (point3.getY() - point1.getY()));

        return firstSide + secondSide > thirdSide && secondSide + thirdSide > firstSide && thirdSide + firstSide > secondSide;
    }
}
