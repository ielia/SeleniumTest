package org.seleniumTest.testng.dataProviders;

import org.testng.annotations.DataProvider;

public class SearchDataProvider {
    @DataProvider(name = "button")
    public static Object[][] button() {
        return new Object[][]{
                {"button", "testng"},
                {"button", "staircase"}
        };
    }

    @DataProvider(name = "submit")
    public static Object[][] submit() {
        return new Object[][]{
                {"submit", "testng"},
                {"submit", "staircase"}
        };
    }

    @DataProvider(name = "enter")
    public static Object[][] enter() {
        return new Object[][]{
                {"enter", "testng"},
                {"enter", "staircase"}
        };
    }
}

