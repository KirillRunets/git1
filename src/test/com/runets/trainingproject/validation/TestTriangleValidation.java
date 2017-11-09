package com.runets.trainingproject.validation;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTriangleValidation{

    @Test (dataProvider = "providerValidation", dataProviderClass = TriangleValidationDataProvider.class)
    public void testRegex(boolean actual, String expected){
        Assert.assertEquals(actual, TriangleValidation.getInstance().checkWithRegex(expected));
    }
}
