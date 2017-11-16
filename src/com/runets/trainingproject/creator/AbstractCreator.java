package com.runets.trainingproject.creator;

import com.runets.trainingproject.datamanager.impl.FileDataManagerImpl;
import com.runets.trainingproject.entity.Triangle;
import com.runets.trainingproject.exception.ValidationException;
import com.runets.trainingproject.parser.TriangleParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractCreator {
    private static Logger Logger = LogManager.getLogger(AbstractCreator.class);
    private final static String DELIMETER = " ";

    public List<Triangle> createTriangleList(String fileName){
        List<Triangle> triangles = new ArrayList<>();
        List<String> lines = FileDataManagerImpl.getInstance().readDataFile(fileName);
        for (int i = 0; i < lines.size(); i++){
            try {
                double[] coordinates = TriangleParser.getInstance().parseLineToCoordinates(lines.get(i), DELIMETER);
                if (coordinates != null){
                    triangles.add(createTriangle(i, coordinates));
                }
            } catch (ValidationException e) {
                Logger.error(e);
            }
        }
        Logger.info("The length of triangles is a " + triangles.size());
        return triangles;
    }

    public abstract Triangle createTriangle(int id, double[] coordinates) throws ValidationException;
}
