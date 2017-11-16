package com.runets.trainingproject.observer;

import com.runets.trainingproject.action.TriangleAction;
import com.runets.trainingproject.creator.AbstractCreator;
import com.runets.trainingproject.creator.TriangleCreator;
import com.runets.trainingproject.datamanager.impl.FileDataManagerImpl;
import com.runets.trainingproject.entity.Point;
import com.runets.trainingproject.entity.Triangle;
import com.runets.trainingproject.exception.TriangleException;
import com.runets.trainingproject.observer.impl.TriangleOperation;
import com.runets.trainingproject.observer.impl.TriangleOperationObserver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestObserver {
    private List<Triangle> triangleList = new ArrayList<>();
    private Map<Integer, TriangleOperationObserver> map = new HashMap<>();
    private final static String FILE_NAME = "file/testObserver.txt";


    @BeforeMethod
    public void setUp() throws TriangleException {
        List<String> dataList = new ArrayList<>();
        AbstractCreator creator = new TriangleCreator();
        dataList.add("2.0 1.1 2.0 5.0 5.0 3.0");
        dataList.add("4.0 5.0 6.0 5.0 5.0 7.0");
        dataList.add("2.4 1.5 2.6 5.7 5.0 6.0");

        FileDataManagerImpl.getInstance().createDataFile(FILE_NAME);
        FileDataManagerImpl.getInstance().writeDataToFile(dataList, FILE_NAME);

        triangleList = creator.createTriangleList(FILE_NAME);
        for (Triangle triangle : triangleList){
            map.put(triangle.getId(), new TriangleOperationObserver(triangle));
            TriangleOperation.getInstance().addObserver(map.get(triangle.getId()));
        }
    }

    @Test
    public void beforeChangedSquareTest() throws TriangleException {
        for (Triangle triangle : triangleList){
            Assert.assertEquals(TriangleAction.getInstance().square(triangle), map.get(triangle.getId()).getSquare());
        }
    }

    @Test
    public void beforeChangedPerimeterTest() throws TriangleException {
        for (Triangle triangle : triangleList){
            Assert.assertEquals(TriangleAction.getInstance().perimeter(triangle), map.get(triangle.getId()).getPerimeter(), 0.01);
        }
    }


    @Test
    public void afterChangedSquareTest() throws TriangleException {
        for (Triangle triangle : triangleList){
            triangle.setA(new Point(11.0, 5.0));
            Assert.assertEquals(TriangleAction.getInstance().square(triangle), map.get(triangle.getId()).getSquare());
        }
    }

    @Test
    public void afterChangedPerimeterTest() throws TriangleException {
        for (Triangle triangle : triangleList){
            triangle.setB(new Point(19.0, 5.0));
            Assert.assertEquals(TriangleAction.getInstance().perimeter(triangle), map.get(triangle.getId()).getPerimeter());
        }
    }
}
