package org.example.utilities;


import org.testng.Assert;

public class VerificationUtils {

    public void verifyTrue(boolean condition, String message) {
        Assert.assertTrue(condition, message);
    }

    public void verifyFalse(boolean condition, String message) {
        Assert.assertFalse(condition, message);
    }
}
