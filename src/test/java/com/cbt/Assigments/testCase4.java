package com.cbt.Assigments;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.VerifyResult;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class testCase4 {
    public static void main(String[] args) {
        WebDriver driver  = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a")).click();
        driver.findElement(By.name("firstname")).sendKeys("123");
        String expectedresult ="first name can only consist of alphabetical letters";
        String actualresult = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[1]/div/small[3]")).getText();
        VerifyResult.verifyEquals(expectedresult,actualresult);
        driver.close();

    }
}
