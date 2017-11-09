package com.runets.trainingproject.validation;

import org.testng.annotations.DataProvider;

public class TriangleValidationDataProvider {
    @DataProvider(name = "providerValidation")
    public static Object[][] dataProviderTriangleValidation(){
        return new Object[][]{
                {true, "2.0"},
                {false, "2,0"},
                {false, ".002"},
                {true, "-2.0"}
        };
    }
}
