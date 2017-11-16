package com.runets.trainingproject.observer;

import com.runets.trainingproject.entity.Triangle;
import com.runets.trainingproject.exception.TriangleException;

public interface OperationObserver {
    void valueChanged(Triangle triangle) throws TriangleException;
}
