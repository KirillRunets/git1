package com.runets.trainingproject.observer.impl;

import com.runets.trainingproject.entity.Triangle;
import com.runets.trainingproject.exception.TriangleException;
import com.runets.trainingproject.observer.OperationObserver;
import com.runets.trainingproject.observer.SubjectOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class TriangleOperation implements SubjectOperation{
    private static Logger Logger = LogManager.getLogger(TriangleOperation.class);
    private List<OperationObserver> operationObservers = new ArrayList<>();
    private static TriangleOperation instance;

    private TriangleOperation(){}

    public static TriangleOperation getInstance(){
        if (instance == null){
            instance = new TriangleOperation();
        }
        return instance;
    }

    @Override
    public void addObserver(OperationObserver operationObserver) {
        if (operationObserver != null){
            operationObservers.add(operationObserver);
        }
    }

    @Override
    public void removeObserver(OperationObserver operationObserver) {
        if (operationObserver != null){
            operationObservers.remove(operationObserver);
        }
    }

    @Override
    public void notifyObservers(Triangle triangle){
        for (OperationObserver operationObserver : operationObservers){
            try {
                operationObserver.valueChanged(triangle);
            } catch (TriangleException e) {
                Logger.error(e);
            }
        }
    }
}
