package com.cbt.Assigments;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class homework3 {
    WebDriver driver;
    WebDriverWait  wait;

    @BeforeMethod
    public void setup(){
        driver= BrowserFactory.getDriver("Chrome");
        wait= new WebDriverWait(driver,10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://qa1.vytrack.com/");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123", Keys.ENTER);
        WebElement activities= driver.findElement(By.linkText("Activities"));
        wait.until(ExpectedConditions.visibilityOf(activities));
        activities.click();
        WebElement calenderEvents=driver.findElement(By.linkText("Calendar Events"));
        wait.until(ExpectedConditions.elementToBeClickable(calenderEvents));
        calenderEvents.click();
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("(//div[@class='loader-frame'])[1]"))));
    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
    @Test
    public void test1(){
        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Options')]")).isDisplayed());
    }
    @Test
    public void test2(){
        Assert.assertTrue(driver.findElement(By.xpath("//input[@value='1']")).isDisplayed(),"1");
    }
    @Test
    public void test3(){
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class='page-size pull-right form-horizontal']/div/div/button")).getText(),"25");
    }
    @Test
    public void test4(){
        List<WebElement>lists= driver.findElements(By.xpath("//*[@class='grid-body']/tr"));
        Assert.assertTrue(lists.size()==19);
    }
    @Test
    public void test5(){
        driver.findElement(By.xpath("//button[@class=\"btn btn-default btn-small dropdown-toggle\"]/input")).click();
        List<WebElement>checkboxes=driver.findElements(By.xpath("//input[@tabindex='-1']"));
        for (WebElement each:checkboxes){
            Assert.assertTrue(each.isSelected());
        }
    }
    @Test
    public void test6(){
        driver.findElement(By.xpath("(//tbody/tr)[8]")).click();
        WebElement loader=driver.findElement(By.xpath("//div[@class='loader-mask shown']"));
        wait.until(ExpectedConditions.invisibilityOf(loader));
        WebElement info=driver.findElement(By.xpath("//*[text()='General Information']"));
        wait.until(ExpectedConditions.visibilityOf(info));
        Assert.assertTrue(info.isDisplayed());
    }

}
