package com.cbt.Assigments;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.BrowserUtils;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.util.List;

public class HomeWork2 {
    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver= BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();


    }
    @AfterMethod
    public void teardown(){
        driver.quit();
    }
    @Test
    public void Testcase1(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.cssSelector("[href^='/reg")).click();
        Faker dommyData = new Faker();
        String birthdate= dommyData.name().firstName();
        driver.findElement(By.cssSelector("[name*='bir")).sendKeys(birthdate);
        String expextedmessage="The date of birth is not valid";
        String actualmesage= driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[8]/div/small[2]")).getText();
        Assert.assertEquals(expextedmessage,actualmesage);
    }
    @Test
    public void Testcase2(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.cssSelector("[href^='/reg")).click();
        List<WebElement> languages= driver.findElements(By.cssSelector("label[class=\"form-check-label\"]"));
        String actualresult="";
        for (WebElement language: languages){
            actualresult+=language.getText();
        }
        String expectedresult="C++JavaJavaScript";
        System.out.println("actual result is: "+actualresult);
        System.out.println("expected result is: "+expectedresult);
        Assert.assertEquals(actualresult,expectedresult);
    }

    @Test
    public void Testcase3(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.cssSelector("[href^='/reg")).click();
        driver.findElement(By.name("firstname")).sendKeys("a");
        String actualmessage=driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[1]/div/small[2]")).getText();
        String exppectedmessage="first name must be more than 2 and less than 64 characters long";
        Assert.assertEquals(actualmessage,exppectedmessage);

    }
    @Test
    public void Testcase4(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.cssSelector("[href^='/reg")).click();
        driver.findElement(By.name("lastname")).sendKeys("a");
        BrowserUtils.wait(2);
        String actualmessage= driver.findElement(By.xpath("//*[@id=\"registrationForm\"]/div[2]/div/small[2]")).getText();
        System.out.println(actualmessage);
        String expectemessage="The last name must be more than 2 and less than 64 characters long";
        System.out.println(expectemessage);
        Assert.assertEquals(expectemessage,actualmessage);
    }
    @Test
    public void Testcase5(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.cssSelector("[href^='/reg")).click();
        Faker dommyData = new Faker();
        driver.findElement(By.name("firstname")).sendKeys(dommyData.name().firstName());
        driver.findElement(By.name("lastname")).sendKeys(dommyData.name().lastName());
        driver.findElement(By.name("username")).sendKeys("makifkav");
        driver.findElement(By.name("email")).sendKeys("email@email.com");
        driver.findElement(By.name("password")).sendKeys("asdfgh123");
        driver.findElement(By.name("phone")).sendKeys("571-456-8765");
        driver.findElement(By.cssSelector("input[value=\"male\"]")).click();
        driver.findElement(By.name("birthday")).sendKeys("07/09/1988");
        WebElement departmanoffice=driver.findElement(By.name("department"));
        Select select= new Select(departmanoffice);
        select.selectByVisibleText("MCR");
        WebElement jobtitle=driver.findElement(By.name("job_title"));
        Select select1=new Select(jobtitle);
        select1.selectByVisibleText("QA");
        driver.findElement(By.id("inlineCheckbox2")).click();
        driver.findElement(By.id("wooden_spoon")).click();
        String actualresult=driver.findElement(By.xpath("//*[@id='content']/div/div/p")).getText();
        String expectedresult="You've successfully completed registration!";
        Assert.assertEquals(expectedresult,actualresult);
    }
    @Test
    public void Testcase6(){
        driver.get("https://www.tempmailaddress.com/");
        String email=driver.findElement(By.id("email")).getText();
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Sign Up For Mailing List")).click();
        driver.findElement(By.name("full_name")).sendKeys("akif kavukcu");
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("wooden_spoon")).submit();
        String expresult="Thank you for signing up. Click the button below to return to the home page.";
        String actresult=driver.findElement(By.cssSelector("h3")).getText();
        Assert.assertEquals(expresult,actresult);
        driver.navigate().to("https://www.tempmailaddress.com/");
        BrowserUtils.wait(10);
        String actualemail=driver.findElement(By.xpath("//tbody/tr[1]/td[2]")).getText();
        String expextedemail="Thanks for subscribing to practice.cybertekschool.com!";
        System.out.println("actual"+actualemail);
        System.out.println("expected"+expextedemail);
        Assert.assertEquals(actualemail,expextedemail);


    }
    @Test
    public void Testcase7(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("File Upload")).click();
        driver.findElement(By.id("file-upload")).sendKeys("C:\\Users\\HP\\Desktop\\New Text Document.txt");
        driver.findElement(By.id("file-submit")).submit();
        String expectedresult="New Text Document.txt";
        String actualresult=driver.findElement(By.id("uploaded-files")).getText();
        Assert.assertEquals(expectedresult,actualresult);
    }
    @Test
    public void Testcase8(){
        driver.get("https://practice-cybertekschool.herokuapp.com/");
        driver.findElement(By.linkText("Autocomplete")).click();
        driver.findElement(By.id("myCountry")).sendKeys("United States of America");
        driver.findElement(By.cssSelector("input[class=\"btn btn-primary\"]")).click();
        String expectedmessage="You selected: United States of America";
        String actualmessage=driver.findElement(By.id("result")).getText();
        Assert.assertEquals(expectedmessage,actualmessage);
    }
    @DataProvider(name = "testData")
    public static Object[][] testData(){
        return new Object[][]{{"//a[.='200']", "This page returned a 200 status code.\n" +
                "\n" +
                "For a definition and common list of HTTP status codes, go here"}, //1st set of data
                {"//a[.='301']","This page returned a 301 status code.\n" +
                "\n" +
                "For a definition and common list of HTTP status codes, go here"},
                {"//a[.='404']","This page returned a 404 status code.\n" +
                "\n" +
                "For a definition and common list of HTTP status codes, go here"},
                {"//a[.='500']","This page returned a 500 status code.\n" +
                "\n" +
                "For a definition and common list of HTTP status codes, go here"},
        };
    }

    @Test(dataProvider = "testData")
    public void Testcase9_10_11_12 (String element, String result){
        driver.get("http://practice.cybertekschool.com/status_codes");
        driver.findElement(By.xpath(element)).click();
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='example']/p")).getText(),result);

    }


    }

