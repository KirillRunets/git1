package com.runets.trainingproject.parser;

import com.runets.trainingproject.exception.ValidationException;
import com.runets.trainingproject.validation.TriangleValidation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.NumberFormat;
import java.text.ParseException;

public class TriangleParser {
    private static Logger Logger = LogManager.getLogger(TriangleParser.class);
    private final static TriangleParser INSTANCE = new TriangleParser();
    private final static int COORDINATE_AMOUNT = 6;

    private TriangleParser(){}

    public static TriangleParser getInstance(){
        return INSTANCE;
    }

    public double[] parseLineToCoordinates(String line, String delimeter) throws ValidationException {
        TriangleValidation triangleValidation = TriangleValidation.getInstance();
        double[] coordinates = new double[COORDINATE_AMOUNT];
        line = line.trim();
        String[] numbers = line.split(delimeter);

        if (!triangleValidation.isRightCoordinatesTriangleAmount(numbers.length)) {
            throw new ValidationException("There is a wrong amount of coordinates in file: " + numbers.length);
        }

        for (int i = 0; i < numbers.length; i++){
            if (!triangleValidation.checkWithRegex(numbers[i])){
                throw new ValidationException("The wrong value of coordinate: " + numbers[i]);
            }
        }

        for (int i = 0; i < numbers.length; i++){
            coordinates[i] = Double.parseDouble(numbers[i]);
        }
        return coordinates;
    }
}
