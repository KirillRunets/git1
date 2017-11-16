package com.runets.trainingproject.datamanager.impl;

import com.runets.trainingproject.datamanager.FileDataManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileDataManagerImpl implements FileDataManager {
    private static Logger Logger = LogManager.getLogger(FileDataManagerImpl.class);
    private static FileDataManagerImpl instance;

    private FileDataManagerImpl(){}

    public static FileDataManagerImpl getInstance(){
        if (instance == null){
            instance = new FileDataManagerImpl();
        }
        return instance;
    }

    @Override
    public List<String> readDataFile(String fileName) {
        List<String> triangles = new ArrayList<>();
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(fileName))){
            triangles = bufferedReader.lines().collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            Logger.fatal(e);
            throw new RuntimeException(e);
        } catch (IOException e) {
            Logger.error(e);
        }
        return triangles;
    }

    @Override
    public void createDataFile(String fileName) {
        Path filePath = Paths.get(fileName);
        if (!Files.exists(filePath)){
            try {
                Files.createFile(filePath);
            } catch (IOException e) {
                Logger.error(e);
            }
        }
    }

    @Override
    public boolean writeDataToFile(List<String> data, String fileName) {
        try (BufferedWriter bufferedReader = Files.newBufferedWriter(Paths.get(fileName))){
            for (String line : data){
                bufferedReader.write(line + "\n");
            }
        } catch (FileNotFoundException e) {
            Logger.fatal(e);
            throw new RuntimeException(e);
        } catch (IOException e) {
            Logger.error(e);
        }
        return true;
    }
}
