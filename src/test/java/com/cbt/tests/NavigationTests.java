package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

public class NavigationTests {
    public static void main(String[] args) {
       /* WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://google.com");
        String expectedresult1=driver.getTitle();
        driver.navigate().to("https://etsy.com");
        String expectedresult2=driver.getTitle();
        driver.navigate().back();
        StringUtility.verifyEquals(expectedresult1,driver.getTitle());
        driver.navigate().forward();
        StringUtility.verifyEquals(expectedresult2,driver.getTitle());
        driver.close();
*/
        WebDriver driver1 = BrowserFactory.getDriver("firefox");
        driver1.get("http://google.com");
        String expectedresult3=driver1.getTitle();
        driver1.navigate().to("https://etsy.com");
        String expectedresult4=driver1.getTitle();
        driver1.navigate().back();
        StringUtility.verifyEquals(expectedresult3,driver1.getTitle());
        driver1.navigate().forward();
        StringUtility.verifyEquals(expectedresult4,driver1.getTitle());
        driver1.close();


    }
}

