package com.runets.trainingproject.datamanager;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

public class FileDataManagerImplDataProvider {
    @DataProvider(name = "writeDataProvider")
    public static Object[][] writeDataProvider(){
        List<String> list = new ArrayList<>();
        list.add("5.0 1.0 2.0 5.0 5.0 3.3");
        list.add("4.0 1.0 2.0 5.0 5.0 3.3");
        list.add("4.0 1.9 2.0 5.0 5.0 3.3");

        return new Object[][]{
                {true, list}

        };
    }
}
