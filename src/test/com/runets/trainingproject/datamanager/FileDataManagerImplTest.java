package com.runets.trainingproject.datamanager;

import com.runets.trainingproject.datamanager.impl.FileDataManagerImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class FileDataManagerImplTest {

    private final static String FILE_NAME = "file/file.txt";

    @BeforeTest
    public void testCreateDataFile(){
        FileDataManagerImpl.getInstance().createDataFile(FILE_NAME);
    }

    @Test (dataProvider = "writeDataProvider", dataProviderClass = FileDataManagerImplDataProvider.class)
    public void testWriteDataToFile(boolean actual, List<String> expected){
        Assert.assertEquals(actual, FileDataManagerImpl.getInstance().writeDataToFile(expected, FILE_NAME));
    }

    @Test
    public void readDataFile(){
        List<String> list = new ArrayList<>();
        list.add("5.0 1.0 2.0 5.0 5.0 3.3");
        list.add("4.0 1.0 2.0 5.0 5.0 3.3");
        list.add("4.0 1.9 2.0 5.0 5.0 3.3");
        Assert.assertEquals(list, FileDataManagerImpl.getInstance().readDataFile(FILE_NAME));
    }
}
