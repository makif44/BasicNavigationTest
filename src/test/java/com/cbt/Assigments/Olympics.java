package com.cbt.Assigments;

import com.cbt.utilities.BrowserUtils;
import com.cbt.utilities.Driver;
import com.cbt.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Olympics {
    @Test(description = "verify that ")
    public void test1(){
        Driver.get().get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table");
        for (int i=1; i<11; i++){

            int num=Integer.parseInt(Driver.get().findElement(By.xpath("//*[@class=\"wikitable sortable plainrowheaders jquery-tablesorter\"]//tbody//tr["+i+"]/td[1]")).getText());
            Assert.assertTrue(num==i);
        }
        Driver.close();

    }
    @Test
    public void test2(){
        Driver.get().get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table");
        Driver.get().findElement(By.xpath("//*[@class=\"wikitable sortable plainrowheaders jquery-tablesorter\"]//thead//tr//th[2]")).click();
        for (int i=1; i<11; i++){
            if(i==7||i==8){
                continue;
            }else{
        String countryName=Driver.get().findElement(By.xpath("//*[@class=\"wikitable sortable plainrowheaders jquery-tablesorter\"]//tbody//tr["+i+"]//th")).getText();
        String folowingCountryName=Driver.get().findElement(By.xpath("//*[@class=\"wikitable sortable plainrowheaders jquery-tablesorter\"]//tbody//tr["+(i+1)+"]//th")).getText();
        Assert.assertTrue(countryName.compareTo(folowingCountryName)<0);
            }
        }
        Driver.close();

    }
    @Test
    public void test3(){
        Driver.get().get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table");
        Driver.get().findElement(By.xpath("//*[@class=\"wikitable sortable plainrowheaders jquery-tablesorter\"]//thead//tr//th[2]")).click();
        for (int i=1; i<11; i++){
            if(i==8){
                continue;
            }
            int num=Integer.parseInt(Driver.get().findElement(By.xpath("//*[@class=\"wikitable sortable plainrowheaders jquery-tablesorter\"]//tbody//tr["+i+"]/td[1]")).getText());
            Assert.assertFalse(num==i);
        }
        Driver.close();

    }
}
