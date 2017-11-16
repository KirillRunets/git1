package com.runets.trainingproject.action;

import com.runets.trainingproject.entity.Point;
import com.runets.trainingproject.entity.Triangle;
import org.testng.annotations.DataProvider;

public class TriangleActionDataProvider {
    @DataProvider(name = "squareTriangleData")
    public static Object[][] squareTriangleData(){
        return new Object[][]{
                {6.0, new Triangle(new Point(2.0, 1.0), new Point(2.0, 5.0), new Point(5.0, 3.3))},
                {25.5, new Triangle(new Point(2.0, -4.0), new Point(-5.0, -6.0), new Point(1.0, 3.0))},
                {25.5, new Triangle(new Point(2.0, -4.0), new Point(1.0, 3.0), new Point(-5.0, -6.0))},
                {25.5, new Triangle(new Point(2.0, -4.0), new Point(1.0, 3.0), new Point(-5.0, -6.0))},

        };
    }

    @DataProvider(name = "perimeterTriangleData")
    public static Object[][] perimeterTriangleData(){
        return new Object[][]{
                {12.185402353554725, new Triangle(new Point(1.0, 1.0), new Point(2.0, 5.0), new Point(5.0, 3.3))},
                {12.653539864544367, new Triangle(new Point(4.0, 1.0), new Point(8.0, 5.9), new Point(6.0, 3.3))},
        };
    }

    @DataProvider (name = "rightTriangleData")
    public static Object[][] rightTriangleData(){
        return new Object[][]{
                {false, new Triangle(new Point(2.0, 1.0), new Point(2.0, 5.0), new Point(5.0, 3.3))},
                {true, new Triangle(new Point(1.0, 1.0), new Point(1.0, 5.0), new Point(5.0, 1.0))},

        };
    }

}
