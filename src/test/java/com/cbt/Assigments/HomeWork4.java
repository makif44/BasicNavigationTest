package com.cbt.Assigments;
import com.cbt.utilities.BrowserUtils;
import com.cbt.utilities.Driver;
import com.cbt.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.List;

public class HomeWork4 extends TestBase {
    WebDriverWait wait;
    @BeforeMethod
    public void setup1(){
        JavascriptExecutor js =(JavascriptExecutor) Driver.get();
        WebElement username=Driver.get().findElement(By.id("prependedInput"));
        WebElement password= Driver.get().findElement(By.id("prependedInput2"));
        WebElement submit= Driver.get().findElement(By.id("_submit"));
        BrowserUtils.wait(2);
        js.executeScript("arguments[0].setAttribute('value','storemanager85')",username);
        js.executeScript("arguments[0].setAttribute('value','UserUser123')",password);
        js.executeScript("arguments[0].click()",submit);
        Driver.get().findElement(By.linkText("Activities")).click();
        Driver.get().findElement(By.linkText("Calendar Events")).click();

        wait=new WebDriverWait(Driver.get(),15);
        WebElement load=Driver.get().findElement(By.xpath("//*[@class=\"loader-mask shown\"]"));
        wait.until(ExpectedConditions.invisibilityOf(load));
    }

    @Test
    public void test1(){
         WebElement treeDot=Driver.get().findElement(By.xpath("(//*[@class=\"more-bar-holder\"])[1]"));

        treeDot.click();
        WebElement view=Driver.get().findElement(By.xpath("((//*[@class=\"more-bar-holder\"])[1]/div/ul/li/ul/li/a)[1]"));
        WebElement edit=Driver.get().findElement(By.xpath("((//*[@class=\"more-bar-holder\"])[1]/div/ul/li/ul/li/a)[2]"));
        WebElement delete=Driver.get().findElement(By.xpath("((//*[@class=\"more-bar-holder\"])[1]/div/ul/li/ul/li/a)[3]"));
        Assert.assertEquals(view.getAttribute("title"),"View");
        Assert.assertEquals(edit.getAttribute("title"),"Edit");
        Assert.assertEquals(delete.getAttribute("title"),"Delete");

    }
    @Test
    public void test2(){

        Driver.get().findElement(By.xpath("//*[@class=\"column-manager dropdown\"]/a")).click();
        List<WebElement> list=Driver.get().findElements(By.xpath("(//*[@class=\"ui-sortable\"]/tr/td[3])"));
        for (int i=6; i>=0; i--){
            if(list.get(i).isSelected()){
                list.get(i).click();
            }
        }
       Assert.assertEquals(Driver.get().findElement(By.xpath("//*[@class=\"grid-header-cell__label\"]")).getText(),"TITLE");
    }
    @Test
    public void test3(){

        Driver.get().findElement(By.xpath("//*[@class=\"btn main-group btn-primary pull-right \"]")).click();
        WebElement load2=Driver.get().findElement(By.xpath("//*[@class=\"loader-mask shown\"]"));
        wait.until(ExpectedConditions.invisibilityOf(load2));
        Driver.get().findElement(By.xpath("//*[@class=\"btn-success btn dropdown-toggle\"]")).click();
        WebElement name1=Driver.get().findElement(By.xpath("//*[@class=\"action-button dropdown-item\"]"));
        WebElement name2=Driver.get().findElement(By.xpath("(//*[@class=\"main-group action-button dropdown-item\"])[1]"));
        WebElement name3=Driver.get().findElement(By.xpath("(//*[@class=\"main-group action-button dropdown-item\"])[2]"));
        Assert.assertEquals(name1.getText(),"Save And Close");
        Assert.assertEquals(name2.getText(),"Save And New");
        Assert.assertEquals(name3.getText(),"Save");
    }
    @Test
    public void test4(){

        Driver.get().findElement(By.xpath("//*[@class=\"btn main-group btn-primary pull-right \"]")).click();
        WebElement load2=Driver.get().findElement(By.xpath("//*[@class=\"loader-mask shown\"]"));
        wait.until(ExpectedConditions.invisibilityOf(load2));
        Driver.get().findElement(By.xpath("//*[@class=\"btn back icons-holder-text \"]")).click();
        Assert.assertTrue(Driver.get().findElement(By.xpath("//*[@class=\"oro-subtitle\"]")).isDisplayed());
    }
    @Test
    public void test5(){

    }
    @Test
    public void test6(){

    }
    @Test(description = "time section should not be able to display but not")
    public void test7(){
        Driver.get().findElement(By.xpath("//*[@class=\"btn main-group btn-primary pull-right \"]")).click();
        WebElement load2=Driver.get().findElement(By.xpath("//*[@class=\"loader-mask shown\"]"));
        wait.until(ExpectedConditions.invisibilityOf(load2));
        WebElement AllDayEvent= Driver.get().findElement(By.xpath("//*[@name=\"oro_calendar_event_form[allDay]\"]"));

        AllDayEvent.click();
        Assert.assertTrue(AllDayEvent.isSelected());

       WebElement StartTime=Driver.get().findElement(By.xpath("//*[@class='input-small timepicker-input start ui-timepicker-input']"));
        WebElement EndTime= Driver.get().findElement(By.xpath("//*[@class='input-small timepicker-input end ui-timepicker-input']"));
        WebElement startDate=Driver.get().findElement(By.xpath("//*[@class='input-small datepicker-input start hasDatepicker']"));
        WebElement endDate=Driver.get().findElement(By.xpath("//*[@class='input-small datepicker-input end hasDatepicker']"));

        Assert.assertTrue(StartTime.isDisplayed());
        Assert.assertTrue(EndTime.isEnabled());
        Assert.assertTrue(startDate.isEnabled());
        Assert.assertTrue(endDate.isEnabled());

    }
    @Test
    public void test8(){
        Driver.get().findElement(By.xpath("//*[@class=\"btn main-group btn-primary pull-right \"]")).click();
        WebElement load2=Driver.get().findElement(By.xpath("//*[@class=\"loader-mask shown\"]"));
        wait.until(ExpectedConditions.invisibilityOf(load2));
        WebElement Repeat= Driver.get().findElement(By.xpath("((//*[@class=\"control-group control-group-checkbox\"])[2]/div)[2]/input"));

        Repeat.click();
        Assert.assertTrue(Repeat.isSelected());
        WebElement Daily=Driver.get().findElement(By.xpath("//*[@class=\"recurrence-repeats__select\"]"));
        Assert.assertTrue(Daily.isEnabled());
    }
    @Test
    public void test9(){
        Driver.get().findElement(By.xpath("//*[@class=\"btn main-group btn-primary pull-right \"]")).click();
        WebElement load2=Driver.get().findElement(By.xpath("//*[@class=\"loader-mask shown\"]"));
        wait.until(ExpectedConditions.invisibilityOf(load2));
        WebElement Repeat= Driver.get().findElement(By.xpath("((//*[@class=\"control-group control-group-checkbox\"])[2]/div)[2]/input"));

        Repeat.click();
        Assert.assertTrue(Repeat.isSelected());
        WebElement Weekday=Driver.get().findElement(By.xpath("(//*[@type=\"radio\"])[1]"));
        WebElement never=Driver.get().findElement(By.xpath("(//*[@type=\"radio\"])[3]"));
        Weekday.click();
        never.click();
        Assert.assertTrue(Weekday.isSelected());
        Assert.assertTrue(never.isSelected());
        Assert.assertEquals(Driver.get().findElement(By.xpath("(//*[@class=\"controls\"])[17]/div/span")).getText(),"Daily every 1 day");

    }
    @Test
    public void test10(){
        Driver.get().findElement(By.xpath("//*[@class=\"btn main-group btn-primary pull-right \"]")).click();
        WebElement load2=Driver.get().findElement(By.xpath("//*[@class=\"loader-mask shown\"]"));
        wait.until(ExpectedConditions.invisibilityOf(load2));
        WebElement Repeat= Driver.get().findElement(By.xpath("((//*[@class=\"control-group control-group-checkbox\"])[2]/div)[2]/input"));

        Repeat.click();
        Assert.assertTrue(Repeat.isSelected());
        WebElement Weekday=Driver.get().findElement(By.xpath("(//*[@type=\"radio\"])[1]"));
        WebElement after=Driver.get().findElement(By.xpath("(//*[@type=\"radio\"])[4]"));
        Weekday.click();
        after.click();
        Driver.get().findElement(By.xpath("(//*[@class=\"recurrence-subview-control__number\"])[7]")).sendKeys("10");
        BrowserUtils.wait(2);
        String a =Driver.get().findElement(By.xpath("(//*[@class='control-group recurrence-summary alert-info']//span)[1]")).getText();
        String b=  Driver.get().findElement(By.xpath("(//*[@class='control-group recurrence-summary alert-info']//span)[2]")).getText();

        Assert.assertEquals(a+b,"Daily every 1 day, end after 10 occurrences");

    }
    @Test
    public void test11(){
        Driver.get().findElement(By.xpath("//*[@class=\"btn main-group btn-primary pull-right \"]")).click();
        WebElement load2=Driver.get().findElement(By.xpath("//*[@class=\"loader-mask shown\"]"));
        wait.until(ExpectedConditions.invisibilityOf(load2));
        WebElement Repeat= Driver.get().findElement(By.xpath("((//*[@class=\"control-group control-group-checkbox\"])[2]/div)[2]/input"));

        Repeat.click();
        Assert.assertTrue(Repeat.isSelected());
        WebElement Weekday=Driver.get().findElement(By.xpath("(//*[@type=\"radio\"])[1]"));
        WebElement byy=Driver.get().findElement(By.xpath("(//*[@type=\"radio\"])[5]"));
        Weekday.click();
        byy.click();
        Driver.get().findElement(By.xpath("//*[@class=\"datepicker-input hasDatepicker\"]")).sendKeys("Nov 29, 2019");
        BrowserUtils.wait(2);
        String a =Driver.get().findElement(By.xpath("(//*[@class='control-group recurrence-summary alert-info']//span)[1]")).getText();
        String b=  Driver.get().findElement(By.xpath("(//*[@class='control-group recurrence-summary alert-info']//span)[2]")).getText();

        Assert.assertEquals(a+b,"Daily every 1 day, end by Nov 29, 2019");

    }
    @Test
    public void test12(){
        Driver.get().findElement(By.xpath("//*[@class=\"btn main-group btn-primary pull-right \"]")).click();
        WebElement load2=Driver.get().findElement(By.xpath("//*[@class=\"loader-mask shown\"]"));
        wait.until(ExpectedConditions.invisibilityOf(load2));
        WebElement Repeat= Driver.get().findElement(By.xpath("((//*[@class=\"control-group control-group-checkbox\"])[2]/div)[2]/input"));

        Repeat.click();
        Assert.assertTrue(Repeat.isSelected());
        WebElement weekly= Driver.get().findElement(By.xpath("//*[@class=\"recurrence-repeats__select\"]"));
        weekly.click();
        WebElement weekl1= Driver.get().findElement(By.xpath("(//*[@class=\"recurrence-repeats__select\"]/option)[2]"));
        weekl1.click();
        WebElement monday= Driver.get().findElement(By.xpath("(//*[@value=\"monday\"])[3]"));
        WebElement friday=Driver.get().findElement(By.xpath("(//*[@value=\"friday\"])[3]"));
        WebElement never=Driver.get().findElement(By.xpath("(//*[@type=\"radio\"])[3]"));
        monday.click();
        friday.click();
        never.click();
        Assert.assertTrue(monday.isSelected());
        Assert.assertTrue(friday.isSelected());
        String a =Driver.get().findElement(By.xpath("(//*[@class='control-group recurrence-summary alert-info']//span)[1]")).getText();

        Assert.assertEquals(a,"Weekly every 1 week on Monday, Friday");



    }




}
