package com.cbt.VyTrack;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.VerifyResult;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginNegativeTestCase {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        driver.findElement( By.id("prependedInput")).sendKeys("akif");
        driver.findElement(By.id("prependedInput2")).sendKeys("kavukcu");
        driver.findElement(By.id("_submit")).click();
        String expectedrslt = "Invalid user name or password.";
        String actualrslt= driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/div[1]/div")).getText();
        VerifyResult.verifyEquals(expectedrslt,actualrslt);
        driver.close();
    }
}
