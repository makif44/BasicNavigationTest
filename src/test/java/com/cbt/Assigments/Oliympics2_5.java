package com.cbt.Assigments;

import com.cbt.utilities.Driver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Oliympics2_5 {

    public String getCountryWithTheSmallestNumberOfGoldMedals(){
        String result="";
        int min=Integer.MAX_VALUE;
        for(int i=1; i<11; i++){
            int smallestSilver=Integer.parseInt(Driver.get().findElement(By.xpath("//*[@class=\"wikitable sortable plainrowheaders jquery-tablesorter\"]//tbody//tr["+i+"]/td[2]")).getText());
            if(smallestSilver<min){
                min=smallestSilver;
                result=Driver.get().findElement(By.xpath("//*[@class=\"wikitable sortable plainrowheaders jquery-tablesorter\"]//tbody//tr["+i+"]/th")).getText().trim();
            }
        }
        return result;
    }

    public String getCountryWithTheSmallestNumberOfSilverMedals(){
        String result="";
        int min=Integer.MAX_VALUE;
        for(int i=1; i<11; i++){
            int smallestSilver=Integer.parseInt(Driver.get().findElement(By.xpath("//*[@class=\"wikitable sortable plainrowheaders jquery-tablesorter\"]//tbody//tr["+i+"]/td[3]")).getText());
            if(smallestSilver<min){
                min=smallestSilver;
                result=Driver.get().findElement(By.xpath("//*[@class=\"wikitable sortable plainrowheaders jquery-tablesorter\"]//tbody//tr["+i+"]/th")).getText().trim();
            }
        }
        return result;
    }

    public String getCountryWithTheSmallestNumberOfBronzMedals(){
        String result="";
        int min=Integer.MAX_VALUE;
        for(int i=1; i<11; i++){
            int smallestSilver=Integer.parseInt(Driver.get().findElement(By.xpath("//*[@class=\"wikitable sortable plainrowheaders jquery-tablesorter\"]//tbody//tr["+i+"]/td[4]")).getText());
            if(smallestSilver<min){
                min=smallestSilver;
                result=Driver.get().findElement(By.xpath("//*[@class=\"wikitable sortable plainrowheaders jquery-tablesorter\"]//tbody//tr["+i+"]/th")).getText().trim();
            }
        }
        return result;
    }
    public void silverMedalNumber(){
        String result="";

        for(int i=1; i<11; i++){
            int SilverMedalNumber=Integer.parseInt(Driver.get().findElement(By.xpath("//*[@class=\"wikitable sortable plainrowheaders jquery-tablesorter\"]//tbody//tr["+i+"]/td[3]")).getText());
            result=Driver.get().findElement(By.xpath("//*[@class=\"wikitable sortable plainrowheaders jquery-tablesorter\"]//tbody//tr["+i+"]/th")).getText().trim();
            System.out.println(result+" won "+SilverMedalNumber+" silver medals");
        }
    }
    public void sumOfBronzeMedal(){

        for (int i =1 ; i <11 ; i++) {
            for (int j = 1; j <11 ; j++) {
                int SilverMedalNumber=Integer.parseInt(Driver.get().findElement(By.xpath("//*[@class=\"wikitable sortable plainrowheaders jquery-tablesorter\"]//tbody//tr["+i+"]/td[3]")).getText());
                int SilverMedalNumber2=Integer.parseInt(Driver.get().findElement(By.xpath("//*[@class=\"wikitable sortable plainrowheaders jquery-tablesorter\"]//tbody//tr["+j+"]/td[3]")).getText());
                if(SilverMedalNumber+SilverMedalNumber2==18){
                    System.out.print(Driver.get().findElement(By.xpath("//*[@class=\"wikitable sortable plainrowheaders jquery-tablesorter\"]//tbody//tr["+i+"]/th")).getText().trim()+" and ");
                    System.out.println(Driver.get().findElement(By.xpath("//*[@class=\"wikitable sortable plainrowheaders jquery-tablesorter\"]//tbody//tr["+j+"]/th")).getText().trim());
                }
            }
        }
    }

    @BeforeMethod
    public void setup(){
        Driver.get().get("https://en.wikipedia.org/wiki/2016_Summer_Olympics#Medal_table");
    }
    @AfterMethod
    public void teardown(){
        Driver.close();
    }
    @Test(description = "country with the smallest number of gold medals")
    public void test1(){
        String actualResult=getCountryWithTheSmallestNumberOfGoldMedals();
        Assert.assertEquals(actualResult,"Italy (ITA)");
    }
    @Test(description = "country with the smallest number of silver medals")
    public void test2(){
        String actualResult=getCountryWithTheSmallestNumberOfSilverMedals();
        Assert.assertEquals(actualResult,"South Korea (KOR)");
    }
    @Test(description = "country with the smallest number of bronze medals")
    public void test3(){
        String actualResult=getCountryWithTheSmallestNumberOfBronzMedals();
        Assert.assertEquals(actualResult,"South Korea (KOR)");
    }
    @Test
    public void test4(){
        silverMedalNumber();
    }
    @Test
    public void test5(){
        sumOfBronzeMedal();
    }
}
