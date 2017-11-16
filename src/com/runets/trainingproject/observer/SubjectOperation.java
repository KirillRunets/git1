package com.runets.trainingproject.observer;

import com.runets.trainingproject.entity.Triangle;
import com.runets.trainingproject.exception.TriangleException;

public interface SubjectOperation {
    void addObserver(OperationObserver operationObserver);
    void removeObserver(OperationObserver operationObserver);
    void notifyObservers(Triangle triangle);
}
