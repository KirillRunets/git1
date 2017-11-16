package com.runets.trainingproject.moduletest;

import com.runets.trainingproject.creator.AbstractCreator;
import com.runets.trainingproject.creator.TriangleCreator;
import com.runets.trainingproject.datamanager.impl.FileDataManagerImpl;
import com.runets.trainingproject.entity.Point;
import com.runets.trainingproject.entity.Triangle;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModuleTest {

    private final static String FILE_NAME = "file/module.txt";

    @BeforeMethod
    public void setUp(){
        List<String> dataList = new ArrayList<>();
        dataList.add("5.0 1.0 2.0 5.0 5.0 3.0");
        dataList.add("4.0 5.0 6.0 5.0 5.0 7.0");
        dataList.add("2.4 1.5 2.6 5.7 5.0 6.0");

        FileDataManagerImpl.getInstance().createDataFile(FILE_NAME);
        FileDataManagerImpl.getInstance().writeDataToFile(dataList, FILE_NAME);
    }

    @Test
    public void testWorkProgram(){
        AbstractCreator creator = new TriangleCreator();
        List<Triangle> actual = new ArrayList<>();
        actual.add(new Triangle(0, new Point(5.0, 1.0), new Point(2.0, 5.0), new Point(5.0, 3.0)));
        actual.add(new Triangle(1, new Point(4.0, 5.0), new Point(6.0, 5.0), new Point(5.0, 7.0)));
        actual.add(new Triangle(2, new Point(2.4, 1.5), new Point(2.6, 5.7), new Point(5.0, 6.0)));

        List<Triangle> expected = creator.createTriangleList(FILE_NAME);
        Assert.assertEquals(actual, expected);
    }
}
