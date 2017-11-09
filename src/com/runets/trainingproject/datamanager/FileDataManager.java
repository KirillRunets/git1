package com.runets.trainingproject.datamanager;

import java.util.List;

public interface FileDataManager {
    List<String> readDataFile(String fileName);
    void createDataFile(String fileName);
    boolean writeDataToFile(List<String> data, String fileName);
}
