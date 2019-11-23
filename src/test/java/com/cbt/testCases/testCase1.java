package com.cbt.testCases;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.VerifyResult;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class testCase1 {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome" );
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        BrowserUtils.wait(1);
        driver.findElement(By.name("full_name")). sendKeys("fullname");
        driver.findElement(By.name("email")).sendKeys("email@email.com");
        driver.findElement(By.name("wooden_spoon")).click();
        String expectedresult = "Thank you for signing up. Click the button below to return to the home page.";
        String actualresult = driver.findElement(By.name("signup_message")).getText();
        VerifyResult.verifyEquals(expectedresult,actualresult);


        driver.close();

    }
}
