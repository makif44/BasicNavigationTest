package com.cbt.testCases;

import com.cbt.utilities.BrowserFactory;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class main {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("chrome");
        wait=new WebDriverWait(driver,10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa1.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
        WebElement fleet = driver.findElement(By.linkText("Fleet"));
        wait.until(ExpectedConditions.visibilityOf(fleet));
        fleet.click();
        WebElement vehicle=driver.findElement(By.linkText("Vehicles"));
        wait.until(ExpectedConditions.elementToBeClickable(vehicle));
        vehicle.click();
        WebElement loaderMask = driver.findElement(By.cssSelector("div[class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loaderMask));
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
    @Test
    public void test1(){
    String expected="All Cars";
    //wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".oro-subtitle"))));
    String acrual=driver.findElement(By.cssSelector(".oro-subtitle")).getText();
    Assert.assertEquals(expected,acrual);
    }
    @Test
    public void test2(){
        WebElement createCar=driver.findElement(By.cssSelector("[title=\"Create Car\"]"));

        Assert.assertTrue(createCar.isDisplayed());
    }






}

