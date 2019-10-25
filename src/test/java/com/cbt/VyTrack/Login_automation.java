package com.cbt.VyTrack;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_automation {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        WebElement inputbox = driver.findElement(By.id("prependedInput"));
        inputbox.sendKeys("user177");
        WebElement inputbox1 =driver.findElement(By.id("prependedInput2"));
        inputbox1.sendKeys("UserUser123");
        WebElement login = driver.findElement(By.id("_submit"));
        login.click();
        String expectedUrl="https://qa2.vytrack.com/";
        String actualUrl=driver.getCurrentUrl();
        StringUtility.verifyEquals(expectedUrl,actualUrl);
        driver.close();


    }
}
