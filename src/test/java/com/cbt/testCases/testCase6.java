package com.cbt.testCases;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.VerifyResult;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class testCase6 {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[3]/div/input")).sendKeys("user");
        String actuaresult= driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[3]/div/small[2]")).getText();
        String expextedresult="The username must be more than 6 and less than 30 characters long";
        VerifyResult.verifyEquals(expextedresult,actuaresult);
        driver.close();
    }
}
