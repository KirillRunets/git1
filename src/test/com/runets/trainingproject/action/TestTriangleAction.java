package com.runets.trainingproject.action;

import com.runets.trainingproject.entity.Triangle;
import com.runets.trainingproject.exception.TriangleException;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestTriangleAction{
    TriangleAction triangleAction;

    @BeforeTest
    public void initTriangleAction(){
        triangleAction = TriangleAction.getInstance();
    }

    @Test(dataProvider = "squareTriangleData", dataProviderClass = TriangleActionDataProvider.class)
    public void testSquare(double actual, Triangle expected) throws TriangleException {
        Assert.assertEquals(actual, triangleAction.square(expected));
    }

    @Test(dataProvider = "perimeterTriangleData", dataProviderClass = TriangleActionDataProvider.class)
    public void testPerimeter(double actual, Triangle expected) throws TriangleException {
        Assert.assertEquals(actual, triangleAction.perimeter(expected));
    }

    @Test(dataProvider = "rightTriangleData", dataProviderClass = TriangleActionDataProvider.class)
    public void testIsRightTriangle(boolean actual, Triangle expected) throws TriangleException {
        Assert.assertEquals(actual, triangleAction.isRightTriangle(expected));
    }

}
