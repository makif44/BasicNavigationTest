package com.cbt.testCases;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.VerifyResult;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class testCase3 {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("/html/body/div/div[2]/div/ul/li[33]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/button[1]")).click();
        String expectedresult ="Clicked on button one!";
        String actualresult = driver.findElement(By.id("result")).getText();
        VerifyResult.verifyEquals(expectedresult,actualresult);
        driver.close();
    }
}
