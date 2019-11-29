package com.cbt.Assigments;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.VerifyResult;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class testCase7 {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[4]/div/input")).sendKeys("testers@email");
        String expectedresult = "email address is not a validEmail format is not correct";
        String actualresult = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[4]/div/small[2]")).getText()
                +driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[4]/div/small[3]")).getText();
        VerifyResult.verifyEquals(expectedresult,actualresult);
        driver.close();
    }
}