package com.cbt.testCases;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.VerifyResult;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class testCase2 {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        int actualCount= driver.findElements(By.className("list-group-item")).size();
        int expectedCount=48;
        VerifyResult.verifyEquals(expectedCount,actualCount);
        driver.close();
    }


}

