package com.cbt.Assigments;

import com.cbt.utilities.BrowserFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class main {
WebDriver driver;
WebDriverWait wait;

   @BeforeMethod
    public void setup(){
    driver= BrowserFactory.getDriver("chrome");
    driver.get("http://practice.cybertekschool.com/tables");
    wait= new WebDriverWait(driver,15);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("table1")));
   }
   @Test
   public void test1(){
       System.out.println(driver.findElement(By.id("table1")).getText());
   }
   @Test
   public void tes2(){
        int expectedColumn=6;
        int actuallColumn=driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th")).size();
       Assert.assertEquals(actuallColumn,expectedColumn);
   }
   @Test
   public void test3(){
       Assert.assertEquals(driver.findElements(By.xpath("//table[@id='table1']//tr")).size(),5);
   }
   @Test
   public void test4(){
       List<WebElement> list=driver.findElements(By.xpath("//table[@id='table1']//tr[3]"));
       for (WebElement each: list){
           System.out.println(each.getText());
       }
   }
   @Test
   public void test5(){
       int i=3;
       List<WebElement>lists=driver.findElements(By.xpath("//table[@id='table1']//tbody//tr["+i+"]//td"));
       for (WebElement each: lists){
           System.out.println(each.getText());
       }
   }
   @Test
   public void test6(){
       for (int i = 1; i <5 ; i++) {
           Assert.assertTrue(driver.findElement(By.xpath("//table[@id='table1']//tbody/tr["+i+"]/td[3]")).getText().contains("@"));
       }
   }
   @Test
   public void test7(){
       driver.findElement(By.xpath("//table[@id='table1']//th[1]")).click();
       List<WebElement>list=driver.findElements(By.xpath("//table[@id='table1']//tbody/tr//td[1]"));
       for (int i=0; i< list.size()-1; i++){
           String lastname=list.get(i).getText();
           String lastname1=list.get(i+1).getText();
           System.out.println(lastname);
           System.out.println(lastname1);
           System.out.println("=====");
           Assert.assertTrue(lastname.compareTo(lastname1)<0);
       }
   }
   @AfterMethod
    public void teardown(){
       driver.quit();
   }
}

