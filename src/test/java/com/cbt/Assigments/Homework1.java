package com.cbt.Assigments;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.VerifyResult;
import com.cbt.utilities.BrowserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Homework1 {
    @Test
    public void test1(){
        WebDriver driver = BrowserFactory.getDriver("chrome" );
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        BrowserUtils.wait(1);
        driver.findElement(By.name("full_name")). sendKeys("fullname");
        driver.findElement(By.name("email")).sendKeys("email@email.com");
        driver.findElement(By.name("wooden_spoon")).click();
        String expectedresult = "Thank you for signing up. Click the button below to return to the home page.";
        String actualresult = driver.findElement(By.name("signup_message")).getText();
        VerifyResult.verifyEquals(expectedresult,actualresult);


        driver.close();

    }
    @Test
    public void test2(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        int actualCount= driver.findElements(By.className("list-group-item")).size();
        int expectedCount=48;
        VerifyResult.verifyEquals(expectedCount,actualCount);
        driver.close();
    }
    @Test
    public void test3() {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("/html/body/div/div[2]/div/ul/li[33]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/button[1]")).click();
        String expectedresult ="Clicked on button one!";
        String actualresult = driver.findElement(By.id("result")).getText();
        VerifyResult.verifyEquals(expectedresult,actualresult);
        driver.close();
    }
    @Test
    public void test4() {
        WebDriver driver  = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a")).click();
        driver.findElement(By.name("firstname")).sendKeys("123");
        String expectedresult ="first name can only consist of alphabetical letters";
        String actualresult = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[1]/div/small[3]")).getText();
        VerifyResult.verifyEquals(expectedresult,actualresult);
        driver.close();

    }
    @Test
    public void test5() {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[2]/div/input")).sendKeys("123");
        String actualresult = driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[2]/div/small[3]")).getText();
        String expectedresut ="The last name can only consist of alphabetical letters and dash";
        VerifyResult.verifyEquals(expectedresut,actualresult);
        driver.close();
    }
    @Test
    public void test6() {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[3]/div/input")).sendKeys("user");
        String actuaresult= driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[3]/div/small[2]")).getText();
        String expextedresult="The username must be more than 6 and less than 30 characters long";
        VerifyResult.verifyEquals(expextedresult,actuaresult);
        driver.close();
    }
    @Test
    public void test7() {
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
    @Test
    public void test8(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://practice-cybertekschool.herokuapp.com");
        driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[40]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[6]/div/input")).sendKeys("5711234354");
        String expectdreesult = "Phone format is not correct";
        String actualresult= driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[6]/div/small[2]")).getText();
        VerifyResult.verifyEquals(expectdreesult,actualresult);
        driver.close();
    }
}


